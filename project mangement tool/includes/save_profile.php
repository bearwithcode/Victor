<?php
require_once 'config.php';

session_start();

$username = $_SESSION['username']; //user this session variable to search database for the projects that this user is involved in
$con = connectToDatabase();

if (isset($_POST['firstname']) && isset($_POST['lastname']) && isset($_POST['email'])) {
	$query = "update `userinfo`
              set `fname`='".$_POST['firstname']."', `lname`='".$_POST['lastname']."', `email`='".$_POST['email']."'
              where `username`='".$username."'";

	mysqli_query($con, $query);

	echo 0;
}

mysqli_close($con);

?>