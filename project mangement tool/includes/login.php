<?php

require_once 'config.php';
$con = connectToDatabase();

$posts = $_POST;

foreach ($posts as $key => $value)
    $posts[$key] = trim ($value);

if(isset($posts['password']) && isset($posts['username'])){
    $password = md5($posts['password']);
    $username = $posts['username'];
}
 else {
    die('should not be empty');
}

$sql = "SELECT * FROM `userinfo` WHERE `password` = '$password' AND `username` = '$username'";

$result = $con->query($sql);
session_start();
if($result){
    if(mysqli_num_rows($result) > 0){
        $_SESSION['login_successful'] = true; 
        $row = mysqli_fetch_assoc($result);
        $_SESSION['firstname'] = $row['fname'];
        $_SESSION['username'] = $row['username'];
        $_SESSION['role'] = $row['userrole'];
        header("location: ../dashboard.php");
    } 
    else{
        $_SESSION['login_successful'] = false;
        header("location: ../index.php");
    }
}
else{
    $_SESSION['login_successful'] = false;
    header("location: ../index.php");
}

mysqli_close($con);

?>