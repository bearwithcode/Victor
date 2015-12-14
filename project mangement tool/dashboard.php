<?php session_start(); 
if(isset($_SESSION['login_successful']) && $_SESSION['login_successful']){
    include("ini_files/dashboard.ini.php");
} else{
    header("location: index.php");
}
?>

