<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$method = $_SERVER['REQUEST_METHOD'];
if($method == 'GET')
{
    doGet();   
}

function doGet(){
    global $smarty;
    global $db;
    require_once("./config.php");
    $db = connectToDatabase();
    smartysetup();
    
    $mvname = $_GET['mvn'];
     
    $query = 'movie = ?';
    $mvm = new Moviemains();
    
    $infos = $mvm->Find($query,$mvname);
    
    /**single movie*/
    
    
    $mcomms = array();
    $mpics = array();
    
    $querys = 'fk_movie = ?';
    $mvs = new Moviesupps();
    

    $supinfos = array();
    $supinfos = $mvs->Find($querys,$infos[0]->id);
    
    foreach ($supinfos as $supin){
        $mcomms[] = $supin->photocomment;
        $mpics[] = $supin->photo;
    }
 
    $snums = count($mpics) - 1;
    
    $smarty->assign('num',$snums);
    $smarty->assign('name',$mvname);
    $smarty->assign('cat',$infos[0]->mgroup);
    $smarty->assign('info',$infos[0]->info);
    $smarty->assign('comms',$mcomms);
    $smarty->assign('pics',$mpics);
    $smarty->display('SearchResult.tpl');
}