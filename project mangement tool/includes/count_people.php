<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['project_id'])) {
	$project_id = $_POST['project_id'];
	
	$query = "select count(*) from `projectworkedon` where `projectID`='".$project_id."'";

	$result = mysqli_fetch_array(mysqli_query($con, $query));

	echo $result[0];
}

mysqli_close($con);

?>