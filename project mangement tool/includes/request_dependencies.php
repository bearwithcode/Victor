<?php
require_once 'config.php';

session_start();

$project_id = $_POST['project_id']; //find the tasks associated with this project id
$con = connectToDatabase();

$query = "select * from `taskdependencies` where `projectID` = '".$project_id."'";

$task_result = mysqli_query($con, $query);

$jsondata = array();

while($task_row = mysqli_fetch_assoc($task_result)){
	$jsondata[] = $task_row;
}

echo json_encode($jsondata);

mysqli_close($con);
?>