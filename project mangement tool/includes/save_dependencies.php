<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['dependencies'])) {
	$project_id = $_POST['project_id'];
	$task_id = $_POST['task_id'];

	//delete the dependency on the start node
	$query = "delete from `taskdependencies`
			where `projectID` = '".$project_id."' and `taskID` = '".$task_id."' and `precedingTask` = '0'";		

	mysqli_query($con, $query);

	foreach ($_POST['dependencies'] as $dependency) {
		$query = "insert into `taskdependencies` (projectID, taskID, precedingTask) values ('".$project_id."', '".$task_id."', '".$dependency."')";

		mysqli_query($con, $query);
	}

	echo 0;
}

?>