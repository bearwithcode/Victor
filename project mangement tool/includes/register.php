<?php

require_once 'config.php';
session_start();

$con = connectToDatabase();
if(isset($_POST['firstname'])&&isset($_POST['lastname'])&&isset($_POST['username'])&&isset($_POST['staffid'])&&isset($_POST['email'])&&isset($_POST['password'])){
    $fname = $_POST['firstname'];
    $lname = $_POST['lastname'];
    $username = $_POST['username'];
    $staffid = $_POST['staffid'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    
    $query = "select count(`username`)
        from `userinfo`
        where `username` = '".$username."'";
    $result = mysqli_query($con, $query);

    $user_count = mysqli_fetch_array($result)[0];

    if ($user_count > 0) {
        echo -1;
    } else{
        $password = md5($password);

        $query = "INSERT INTO `userinfo` (`fname`, `lname`, `username`, `staffID`, `password`, `email`, `userrole`)
                 VALUES ('".$fname."', '".$lname."', '".$username."', '".$staffid."', '".$password."', '".$email."', 'Project Member')";
        mysqli_query($con, $query);
        $_SESSION['login_successful'] = true;
        $_SESSION['firstname'] = $fname;
        echo 0;
    }

} else{
    header("location: ../index.php");
}

mysqli_close($con);

?>