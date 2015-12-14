<?php

function connectToDatabase(){
    
    $server = 'localhost';
    $dbusername = 'root';
    $dbpassword = 'sasakixi';
    $database = '311';
    global $con;
   
    $con = new mysqli($server, $dbusername, $dbpassword,$database) or die("Unable to connect to the MySQL!");
    
    return $con;
}


