<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['percent_complete'])) {
	$task_id = $_POST['task_id'];
	$project_id = $_POST['project_id'];
	
	$query = "update `task`
			set percentcomplete = '".$_POST['percent_complete']."'
			where projectID = '".$project_id."' and taskID = '".$task_id."'";

	mysqli_query($con, $query);
	
	echo 0;
}

mysqli_close($con);

?>