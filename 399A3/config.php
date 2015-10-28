<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once("adodb/adodb.inc.php");
require_once('adodb/adodb-active-record.inc.php');
require_once("Smarty/libs/Smarty.class.php");

class Moviemains extends ADOdb_Active_record{
    var $_table = 'Moviemains';
}

class Moviesupps extends ADOdb_Active_record{
    var $_table = 'Moviesupps';
}

const DIR_SEP = DIRECTORY_SEPARATOR;  
define('SITE_ROOT', dirname(__FILE__).DIR_SEP);  

$smarty = new Smarty;  
$db = null;

function smartysetup(){
    global $smarty;
    
    $smarty->template_dir = SITE_ROOT.'templates'.DIR_SEP;  
    $smarty->compile_dir  = SITE_ROOT.'templates_c'.DIR_SEP;  
    $smarty->config_dir   = SITE_ROOT.'configs'.DIR_SEP;  
    $smarty->cache_dir    = SITE_ROOT.'cache'.DIR_SEP; 
}

function connectToDatabase(){
    $dsn = 'mysqli://root:sasakixi@localhost/movies';
    global $db;
    $db = ADONewConnection($dsn);
    
    if (!$db) {
        die("Failed to connect to database : " . $dsn);
    }
    
    ADOdb_Active_Record::SetDatabaseAdapter($db);   
    ADOdb_Active_Record::ClassHasMany('Moviemains','Moviesupps','fk_movie');
    
    return $db;
}