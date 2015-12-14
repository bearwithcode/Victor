<?php
require_once 'config.php';

session_start();

$project_id = $_POST['project_id']; //find the tasks associated with this project id
$username = $_SESSION['username'];
$con = connectToDatabase();

$query = "select `username`
		from `projectmanager` 
		where `projectID` = '".$project_id."' and `username` = '".$username."'";

$result = mysqli_query($con, $query);

if (mysqli_num_rows($result) == 1) {
	echo "Is Manager";
} else{
	echo "Not Manager";
}

mysqli_close($con);
?>