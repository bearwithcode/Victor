<?php
require_once 'config.php';

session_start();

$project_id = $_POST['project_id']; //find the tasks associated with this project id
$con = connectToDatabase();

$query = "select * from `task` where `projectID` = '".$project_id."'";

if (isset($_POST['task_id'])) {
	if (isset($_POST['dependencies'])) {
		$query = $query . " and `taskID` <> ".$_POST['task_id']."";
	} else{
		$query = $query . " and `taskID` = ".$_POST['task_id']."";
	}
	unset($_POST['task_id']);
}

$task_result = mysqli_query($con, $query);

$jsondata = array();

while($task_row = mysqli_fetch_assoc($task_result)){
	$jsondata[] = $task_row;
}

echo json_encode($jsondata);

mysqli_close($con);
?>