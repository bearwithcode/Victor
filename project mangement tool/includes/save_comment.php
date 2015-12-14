<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$project_id = $_POST['project_id'];
$task_id = $_POST['task_id'];
$username = $_SESSION['username'];
$comment = mysqli_real_escape_string($con, $_POST['comment']);

$query = "insert into `comment` (projectID, taskID, username, commentDate, commentDetails)
		values ('".$project_id."', '".$task_id."', '".$username."', SYSDATE(), '".$comment."')";

mysqli_query($con, $query);

echo 0;

mysqli_close($con);

?>