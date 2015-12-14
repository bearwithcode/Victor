<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$project_id = $_POST['project_id'];
$task_id = $_POST['task_id'];

$query = "select `username`, DATE_FORMAT(`commentDate`, '%h:%i:%s%p %d-%b-%Y') `commentDate`, `commentDetails`
		from `comment`
		where `taskID` = '".$task_id."' and `projectID` = '".$project_id."'";

$comment_result = mysqli_query($con, $query);

$json_array = array();

while ($comment_row = mysqli_fetch_assoc($comment_result)) {
	$json_array[] = $comment_row;
}

echo json_encode($json_array);

mysqli_close($con);

?>