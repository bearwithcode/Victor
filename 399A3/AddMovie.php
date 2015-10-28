<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$method = $_SERVER['REQUEST_METHOD'];
if($method == 'POST')
{
    doPost();
}
else{
    doGet();
}

function doGet(){
    global $smarty;
    require_once("./config.php");
    smartysetup();
    $smarty->display('AddMovie.tpl');
}

function doPost(){
    global $smarty;
    global $db;
    require_once("./config.php");
    
    smartysetup();
    $db = connectToDatabase();
    
    if(isset($_POST['mvname'])&&isset($_POST['mvcategory'])&&isset($_POST['sum'])&&isset($_POST['pics'])&&isset($_POST['comms'])){
        $mvname = filter_input(INPUT_POST,'mvname', FILTER_SANITIZE_STRING);
        $cat = filter_input(INPUT_POST,'mvcategory', FILTER_SANITIZE_STRING);
        $sum = filter_input(INPUT_POST,'sum', FILTER_SANITIZE_STRING);
        //$pics = filter_input_array(INPUT_POST, 'pics', FILTER_SANITIZE_STRING);
        $pics = $_POST['pics'];
        //$comms = filter_input_array(INPUT_POST, 'comms', FILTER_SANITIZE_STRING);
        $comms = $_POST['comms'];
        
        $moviem = new Moviemains();

        $moviem->movie = $mvname;
        $moviem->mgroup = $cat;
        $moviem->info = $sum;
        
        
        if($moviem->save() == false){
            die("Database record save failure");
        }
        
        
        $id = $moviem->id;
        for($i = 0;$i < count($pics);$i ++){
            $movies = new Moviesupps();
            $movies->fk_movie = $id;
            $movies->photo = $pics[$i];
            $movies->photocomment = $comms[$i];
            
            if($movies->save() == false){
                die("sumplement datas record save failure");
            }
        }
       
        $smarty->assign("headt","Movie records");
        $smarty->assign('mname',$mvname);
        $smarty->assign('mnum',$id);
        $smarty->assign('picnum',count($pics));
        $smarty->display('AddReport.tpl');
    }
    else{
        $errorMsg = "please input all the things first";
        $smarty ->assign('error',$errorMsg);
        $smarty ->display("error.tpl");
    }
}

















