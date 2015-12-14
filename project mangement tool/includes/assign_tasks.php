<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['users'])) {
	$project_id = $_POST['project_id'];
	$task_id = $_POST['task_id'];
	
	foreach ($_POST['users'] as $username) {
		$query = "insert into `taskworkedon` (projectID, taskID, username) values ('".$project_id."', '".$task_id."', '".$username."')";

		mysqli_query($con, $query);
	}

	$query = "update `task` set `taskStatus` = 'Active' where projectID = '".$project_id."' and taskID = '".$task_id."' ";

	mysqli_query($con, $query);

	echo 0;
}

mysqli_close($con);

?>