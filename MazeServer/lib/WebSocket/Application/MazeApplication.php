<?php
namespace WebSocket\Application;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MazeApplication
 *
 * @author Victor
 */
class MazeApplication extends Application{
    private static $colourNamesArray = array('red', 'green', 'blue', 'aqua', 
        'fuschia', 'lime', 'maroon', 'navy', 'yellow');
    private static $colourcounter = 0;
    
    private static $facedir = array('up','down','left','right');
    private static $facecounter = 0;
    
    private $_clients = array();
    private static $block = [];//a block of maze raw datas
    private static $jpblock = [];//a block of maze data ready to convert to json
    private static $jblock = [];//a block of maze been jason stringfied
    
    private static $harmtype = "";//what kind of harm 
    private static $target = "";
    private static $maker = "";//username who cause damage, or death
    private static $damage = array();//record who get damage and how bad
    
    private static $bulldet;//detect if there is fire in the maze every should be warned
    private static $fpos = [];//the i and j for bullet
    private static $firedir;
    
            function __construct() {
        MazeApplication::$block = MazeApplication::inidataformaze(MazeApplication::$block);       
        MazeApplication::$jpblock = MazeApplication::generator(MazeApplication::$block);
    }
  
    public function onConnect($client) {
        $id = $client->getClientId();
        $this->_clients[$id] = $client;
                     
        $info = array();
        $info['colour'] = MazeApplication::$colourNamesArray[MazeApplication::$colourcounter];
              
        MazeApplication::$colourcounter++;
        if (MazeApplication::$colourcounter == 9)
            MazeApplication::$colourcounter = 0;
                        
        $client->setClientInfo($info);
    }

    public function onData($data, $client) {
        $decodedData = $this->_decodeData($data);
        
        $action = $decodedData['action'];
        $info = $decodedData['data'];
        $this->_process($client, $action, $info);
    }

    private function _process($client, $action, $info){   
        $infoarray = $client->getClientInfo();
              
        if($action == "start"){		
            $posij = MazeApplication::inipos();
            $infoarray['alive'] = true;//you are live when u connect
            $infoarray['facing'] = MazeApplication::$facedir[MazeApplication::$facecounter];//initialize facing
            $infoarray['health'] = 10;//ini health
            $infoarray['pi'] = $posij[0]; //ini position i
            $infoarray['pj'] = $posij[1]; //ini position j
            $infoarray['diemsg'] = "";//ini die massage
            MazeApplication::$jpblock[$posij[0]][$posij[1]] = 2;
            
            MazeApplication::$facecounter++;
            if(MazeApplication::$facecounter == 3)
                MazeApplication::$facecounter = 0;  
            
            echo $infoarray['uname']." is now starting the game\n";
        }
        
        if($action == "quit"){
            $infoarray['alive'] = false;
            $infoarray['diemsg'] = "";
            MazeApplication::$harmtype = "";
             MazeApplication::$jpblock[$info['pi']][$info['pj']] = 0;

            echo $infoarray['uname']." is out of the game\n";
        }
        
        if($action == "login"){
            $infoarray['uname'] = $info['uname']; 
            $infoarray['login'] = true;
            echo $infoarray['uname']." is login now\n";
        }
        
        if($action == "changedir"){
            switch ($info['dir']){
                case'up':$infoarray['facing'] = "up";break;
                case'down':$infoarray['facing'] = "down";break;
                case'left':$infoarray['facing'] = "left";break;
                case'right':$infoarray['facing'] = "right";break;
            }
            echo $infoarray['uname']." turn ".$infoarray['facing']."\n";
        }
        
        $targeti = -1;
        $targetj = -1;//target i and j
        
        if($action == "move"){
            switch ($info['dir']){
                case'up':{
                    if(MazeApplication::$jpblock[$infoarray['pi'] - 1][$infoarray['pj']] == 2){
                        MazeApplication::$harmtype = "collision";
                        MazeApplication::$maker = $infoarray['uname'];
                        $targeti = $infoarray['pi'] - 1;
                        $targetj = $infoarray['pj'];
                    }
                    else if(MazeApplication::$jpblock[$infoarray['pi'] - 1][$infoarray['pj']] == 0){
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 0;
                        $infoarray['pi'] -= 1;
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 2;
                        echo $infoarray['uname']." move forward 1 step to ".$infoarray['facing']."\n";
                    }                                               
                }break;
                case'down':{
                    if(MazeApplication::$jpblock[$infoarray['pi'] + 1][$infoarray['pj']] == 2){
                        MazeApplication::$harmtype = "collision";
                        MazeApplication::$maker = $infoarray['uname'];
                        $targeti = $infoarray['pi'] + 1;
                        $targetj = $infoarray['pj'];
                    }
                    else if(MazeApplication::$jpblock[$infoarray['pi'] + 1][$infoarray['pj']] == 0){
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 0;
                        $infoarray['pi'] += 1;
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 2;
                        echo $infoarray['uname']." move forward 1 step to ".$infoarray['facing']."\n";
                    }                     
                }break;
                case'left':{
                    if(MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj'] - 1] == 2){
                        MazeApplication::$harmtype = "collision";
                        MazeApplication::$maker = $infoarray['uname'];
                        $targeti = $infoarray['pi'];
                        $targetj = $infoarray['pj'] - 1;
                    }
                    else if(MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj'] - 1] == 0){
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 0;
                        $infoarray['pj'] -= 1;
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 2;  
                        echo $infoarray['uname']." move forward 1 step to ".$infoarray['facing']."\n";
                    }
                }break;
                case'right':{
                    if(MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj'] + 1] == 2){
                        MazeApplication::$harmtype = "collision";
                        MazeApplication::$maker = $infoarray['uname'];
                        $targeti = $infoarray['pi'];
                        $targetj = $infoarray['pj'] + 1;
                    }
                    else if(MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj'] + 1] == 0){
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 0;
                        $infoarray['pj'] += 1;
                        MazeApplication::$jpblock[$infoarray['pi']][$infoarray['pj']] = 2;  
                        echo $infoarray['uname']." move forward 1 step to ".$infoarray['facing']."\n";
                    }                   
                }break;
            }           
        }
        
        if($action == "fire"){
            $maxdamage = 16;
            
            MazeApplication::$maker = $infoarray['uname'];
            MazeApplication::$bulldet = true;
            MazeApplication::$fpos[0] = $infoarray['pi'];
            MazeApplication::$fpos[1] = $infoarray['pj'];
            MazeApplication::$firedir = $infoarray['facing'];
            echo $infoarray['uname']." is firing ".$infoarray['facing']."\n";
                                  
            $ti = $infoarray['pi'];
            $tj = $infoarray['pj'];
            switch (MazeApplication::$firedir){                
                case 'up':{
                    for($i = 0;$i < 3;$i ++){
                        if($ti - $i - 1 >= 0){
                            $ti -= 1;
                            if(MazeApplication::$jpblock[$ti][$tj] == 1){
                                $maxdamage /= 4;
                            }
                            else if(MazeApplication::$jpblock[$ti][$tj] == 2){
                                MazeApplication::$harmtype = "damage";
                                foreach ($this->_clients as $tclient){//tclient means target client
                                    $tinfo = $tclient->getClientInfo();
                                    if($ti == $tinfo['pi']&&$tj == $tinfo['pj']){
                                        MazeApplication::$damage[$tinfo['uname']] = $maxdamage;
                                        if($tinfo['health'] - $maxdamage <=0){
                                            $infoarray['health'] += 2;
                                            echo $infoarray['uname']." killed ".$tinfo['uname']." and get two health\n";
                                        }
                                        else{
                                            echo $infoarray['uname']." cause ".$tinfo['uname']." ".$maxdamage." damges\n";
                                        }
                                        break;
                                    }
                                }
                                $maxdamage /= 2;
                            }
                            else{
                                $maxdamage /= 2;
                            }
                        }
                    }
                }break;
                case 'down':{
                    for($i = 0;$i < 3;$i ++){
                        if($ti + $i + 1 >= 0){
                            $ti += 1;
                            if(MazeApplication::$jpblock[$ti][$tj] == 1){
                                $maxdamage /= 4;
                            }
                            else if(MazeApplication::$jpblock[$ti][$tj] == 2){
                                MazeApplication::$harmtype = "damage";
                                foreach ($this->_clients as $tclient){//tclient means target client
                                    $tinfo = $tclient->getClientInfo();
                                    if($ti == $tinfo['pi']&&$tj == $tinfo['pj']){
                                        MazeApplication::$damage[$tinfo['uname']] = $maxdamage;
                                        if($tinfo['health'] - $maxdamage <=0){
                                            $infoarray['health'] += 2;
                                            echo $infoarray['uname']." killed ".$tinfo['uname']." and get two health\n";
                                        }
                                        else{
                                            echo $infoarray['uname']." cause ".$tinfo['uname']." ".$maxdamage." damges\n";
                                        }
                                        break;
                                    }
                                }
                                $maxdamage /= 2;
                            }
                            else{
                                $maxdamage /= 2;
                            }
                        }
                    }
                }break;
                case 'left':{
                    for($i = 0;$i < 3;$i ++){
                        if($tj - $i - 1 >= 0){
                            $tj -= 1;
                            if(MazeApplication::$jpblock[$ti][$tj] == 1){
                                $maxdamage /= 4;
                            }
                            else if(MazeApplication::$jpblock[$ti][$tj] == 2){
                                MazeApplication::$harmtype = "damage";
                                foreach ($this->_clients as $tclient){//tclient means target client
                                    $tinfo = $tclient->getClientInfo();
                                    if($ti == $tinfo['pi']&&$tj == $tinfo['pj']){
                                        MazeApplication::$damage[$tinfo['uname']] = $maxdamage;
                                        if($tinfo['health'] - $maxdamage <=0){
                                            $infoarray['health'] += 2;
                                            echo $infoarray['uname']." killed ".$tinfo['uname']." and get two health\n";
                                        }
                                        else{
                                            echo $infoarray['uname']." cause ".$tinfo['uname']." ".$maxdamage." damges\n";
                                        }
                                        break;
                                    }
                                }
                                $maxdamage /= 2;
                            }
                            else{
                                $maxdamage /= 2;
                            }
                        }
                    }
                }break;
                case 'right':{
                    for($i = 0;$i < 3;$i ++){
                        if($tj + $i + 1 >= 0){
                            $tj += 1;
                            if(MazeApplication::$jpblock[$ti][$tj] == 1){
                                $maxdamage /= 4;
                            }
                            else if(MazeApplication::$jpblock[$ti][$tj] == 2){
                                MazeApplication::$harmtype = "damage";
                                foreach ($this->_clients as $tclient){//tclient means target client
                                    $tinfo = $tclient->getClientInfo();
                                    if($ti == $tinfo['pi']&&$tj == $tinfo['pj']){
                                        MazeApplication::$damage[$tinfo['uname']] = $maxdamage;
                                        if($tinfo['health'] - $maxdamage <=0){
                                            $infoarray['health'] += 2;
                                            echo $infoarray['uname']." killed ".$tinfo['uname']." and get two health\n";
                                        }
                                        else{
                                            echo $infoarray['uname']." cause ".$tinfo['uname']." ".$maxdamage." damges\n";
                                        }
                                        break;
                                    }
                                }
                                $maxdamage /= 2;
                            }
                            else{
                                $maxdamage /= 2;
                            }
                        }
                    }
                }break;
            }
        }
        
               
        if(MazeApplication::$harmtype == "collision"){
            $infoarray['diemsg'] = "collision";
            foreach ($this->_clients as $aclient){
                $ainfo = $aclient->getClientInfo();
                if($targeti == $ainfo['pi']&&$targetj == $ainfo['pj']){
                    $infoarray['maker'] = $ainfo['uname'];
                    MazeApplication::$target = $ainfo['uname'];
                    break;
                }
            }
        }
        
        MazeApplication::$jblock = MazeApplication::JstringMaze(MazeApplication::$jpblock);//convert to string
        
        
        $client->setClientInfo($infoarray);
        
        $updateData = $this->_composeUpdateMessage();
                     
        /****reset all these after used*****/
        MazeApplication::$harmtype = "";
        MazeApplication::$maker = "";      
        MazeApplication::$target = "";
        MazeApplication::$damage = array();
        
        $encodedUpdate = $this->_encodeData('update', $updateData);
        
        foreach ($this->_clients as $sendto) {
            $sendto->send($encodedUpdate);
        }
    }
    
    private function _composeUpdateMessage() {//each clent get all client message
        $msgdata = array();
        foreach ($this->_clients as $aclient) {
            $info = $aclient->getClientInfo();
            
            if(array_key_exists('uname', $info)){
                if($info['uname'] != MazeApplication::$maker){
                if(MazeApplication::$harmtype == "collision"){
                    if($info['uname'] == MazeApplication::$target){
                        $info['diemsg'] = "collision";
                        $info['maker'] = MazeApplication::$maker;
                    }
                }
            
                if(MazeApplication::$harmtype == "damage"){
                    if(array_key_exists($info['uname'], MazeApplication::$damage)){
                        $thealth = $info['health'] - MazeApplication::$damage[$info['uname']];
                        if($thealth <= 0){
                            $info['diemsg'] = "shot";
                            $info['maker'] = MazeApplication::$maker;
                        }
                        else{
                            $info['health'] = $thealth;
                            echo $info['uname']." lost ".MazeApplication::$damage[$info['uname']]." health\n";
                        }
                    }
                }
            }
            }
            
                               
            if(MazeApplication::$bulldet == true){
                $info['firedir'] = MazeApplication::$firedir;
                $info['fi'] = MazeApplication::$fpos[0];
                $info['fj'] = MazeApplication::$fpos[1];
                $info['fith'] = true;//fire in the hole                
            }
            else{
                $info['fith'] = false;
            }
                      
            $info['mazedt'] = MazeApplication::$jblock;//each client should updata there maze
            $msgdata[] = $info;
            $aclient->setClientInfo($info);
        }
        MazeApplication::$bulldet = false;   //reset,otherwise fire everywhere    
        return $msgdata;
    }
    
    public function onDisconnect($client) {
        $id = $client->getClientId();
        unset($this->_clients[$id]);
    }

    public function inidataformaze($block){
        for($i = 0;$i < count($block);$i ++)
            {
                $block[$i] = [];
            }
            
            for($i = 0;$i < 50;$i ++)//ini maze with 1
            {
                for($j = 0;$j < 50;$j++)
                {
                    $block[$i][$j] = 1;
                }
            }
        return $block;
    }

    public function generator($a){//I use shot gun algorithm to ramdom generator maze, which I invent it and name it
                $countr = 0;
                while($countr < 70)//random spread 50 holes on the wall
                {
                    $random = range(0, 49);
                    shuffle($random);
                    $x = $random[0];
                    $y = $random[1];
                    if($x != 0&&$x != 49&&$y != 0&&$y != 49){
                       $a[$y][$x] = 0;
                       $countr++;     
                    }
                }
                
                $statistic = [];               
                for($i = 0;$i <= 49;$i ++)
                {
                    for($j = 0;$j <= 49;$j ++)
                    {
                        if($a[$i][$j] == 0){
                            $cell = [$i,$j];
                            $statistic[] = $cell;
                        }
                    }
                }
                
                for($i = 0;$i < count($statistic);$i ++)//make a holes spread like 'cross' pattern from 4 direction, which reach end or another road stop push down the wall
                {
                    $tcell = $statistic[$i];
                    $curri = $tcell[0];
                    $currj = $tcell[1];
                            
                    //dig to up
                    $curri--;
                    while($curri >= 0){
                        if($a[$curri][$currj] == 0)
                            break;
                        if($a[$curri][$currj - 1] == 0 || $a[$curri][$currj + 1] == 0){//left or right,
                            $a[$curri][$currj] = 0;
                            break;
                        }
                        $a[$curri][$currj] = 0;
                            $curri--;
                    }
                            
                    $curri = $tcell[0];
                    $currj = $tcell[1];
                            
                    //dig to down
                    $curri++;
                    while($curri <= 49){
                        if($a[$curri][$currj] == 0)
                            break;
                        if($a[$curri][$currj - 1] == 0 || $a[$curri][$currj + 1] == 0){
                            $a[$curri][$currj] = 0;
                            break;
                        }
                        $a[$curri][$currj] = 0;                               
                        $curri++;
                    }
                            
                    $curri = $tcell[0];
                    $currj = $tcell[1];
                            
                    //dig to left
                    $currj--;
                    while($currj >= 0){
                        if($a[$curri][$currj] == 0)
                            break;
                        if($a[$curri - 1][$currj] == 0 || $a[$curri + 1][$currj] == 0){
                            $a[$curri][$currj] = 0;
                            break;
                        }
                        $a[$curri][$currj] = 0;                                 
                        $currj--;
                    }
                            
                    $curri = $tcell[0];
                    $currj = $tcell[1];
                            
                    //dig to right
                    $currj++;
                    while($currj <= 49){
                        if($a[$curri][$currj] == 0)
                            break;
                        if($a[$curri - 1][$currj] == 0 || $a[$curri + 1][$currj] == 0){
                            $a[$curri][$currj] = 0;
                            break;
                        }
                        $a[$curri][$currj] = 0;
                        $currj++;
                    }
                }
                return $a;
            }
            
            public function JstringMaze($a){//this is for generate stringfy json datas
                 for($i = 0;$i < 50;$i++)
                {
                    $str = "";
                    for($j = 0;$j < 50;$j++)
                    {
                        $str = $str.$a[$i][$j];
                    }
                    $jsonformat[] = $str;
                }
                return $jsonformat;
            }
    
	public function inipos(){
                $posarr;
                $random = range(0,49);
                while(true){
                    shuffle($random);
                    $i = $random[0];
                    shuffle($random);
                    $j = $random[0];
                    if(MazeApplication::$jpblock[$i][$j] == 0){
                            $posarr[0] = $i;
                            $posarr[1] = $j;
                            break;
                    }
                }               
                return $posarr;
            }
            
}
