<?php
namespace WebSocket\Application;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ChatApplication
 *
 * @author victor
 */
class ChatApplication extends Application{
    private static $colourNamesArray = array('red', 'green', 'blue', 'aqua', 
        'fuschia', 'lime', 'maroon', 'navy', 'yellow');
    private static $colourcounter = 0;
    private static $msgrec = [];
    private $_clients = array();


    public function onConnect($client) {
        $id = $client->getClientId();
        $this->_clients[$id] = $client;
        
        $info = array();
        $info['colour'] = ChatApplication::$colourNamesArray[ChatApplication::$colourcounter];
              
        ChatApplication::$colourcounter++;
        if (ChatApplication::$colourcounter == 9)
            ChatApplication::$colourcounter = 0;
                        
        $client->setClientInfo($info);
    }

    public function onData($data, $client) {
        $decodedData = $this->_decodeData($data);
        
        $action = $decodedData['action'];
        $info = $decodedData['data'];
        $this->_process($client, $action, $info);
    }

    public function onDisconnect($client) {
        $id = $client->getClientId();
        unset($this->_clients[$id]);
    }

    public function _process($client, $action, $info) {
        $infoarray = $client->getClientInfo();
        
        if($action == "login"){
            $infoarray['uname'] = $info['uname']; 
            $infoarray['login'] = true;
            echo $infoarray['uname']." is login now\n";
        }
        
        if($action == "sendchat"){
            $who = $infoarray['uname'];
            $msg = $info['msgcon'];
            ChatApplication::$msgrec[] = $who.":".$msg."\n";
        }
        
        $client->setClientInfo($infoarray);
        $updateData = $this->_composeUpdateMessage();
        $encodedUpdate = $this->_encodeData('update', $updateData);
        
        foreach ($this->_clients as $sendto) {
            $sendto->send($encodedUpdate);
        }
    }
    
    private function _composeUpdateMessage(){
        $msgdata = array();
        
        foreach ($this->_clients as $aclient){
            $info = $aclient->getClientInfo();
            $info['allmsg'] = ChatApplication::$msgrec;//each client update there massage
            
            $msgdata[] = $info;
        }
        return $msgdata;
    }

}
