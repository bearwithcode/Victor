<?php
require_once 'config.php';

session_start();

$project_id = $_POST['project_id']; //find the tasks associated with this project id
$con = connectToDatabase();

$query = "select *
		from `task` t1 join `taskworkedon` two1
			on (t1.taskID = two1.taskID) and (t1.projectID = two1.projectID)
		where two1.projectID = '".$project_id."' and two1.username = '".$_SESSION['username']."'";

$task_result = mysqli_query($con, $query);

echo mysqli_error($con);

$jsondata = array();

while($task_row = mysqli_fetch_assoc($task_result)){
	$jsondata[] = $task_row;
}

echo json_encode($jsondata);

mysqli_close($con);
?>