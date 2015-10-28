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
else if($method == 'POST')
{
    doPost();
}

function doGet(){
    global $smarty;
    global $db;
    require_once("./config.php");
    smartysetup();
    $smarty->display('SearchMovie.tpl');
}

function doPost(){
    global $smarty;
    global $db;
    require_once("./config.php");
    $db = connectToDatabase();
    smartysetup();
    $movies = array();
    $namelinks = array();
    if(isset($_POST['mvcategory'])){
        $cat = filter_input(INPUT_POST,'mvcategory', FILTER_SANITIZE_STRING);
        
        $mvm = new Moviemains();
        
        $query = "mgroup = ?";
        $movies = $mvm->Find($query,$cat);
        
        
        foreach ($movies as $tm){
            $namelinks[] = $tm->movie;
        }   
        
        
        $smarty->assign('mvks',$namelinks);
        $smarty->assign('cat',$cat);
        $smarty->display('SearchReport.tpl');
    }
}
