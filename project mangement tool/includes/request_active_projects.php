<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$query = "select `projectID`, `name`, `status`
		from `project`
		where `status` = 'Active'";

$project_result = mysqli_query($con, $query);

$jsondata = array();

while($project_row = mysqli_fetch_assoc($project_result)){
	$jsondata[] = $project_row;
}

echo json_encode($jsondata);

mysqli_close($con);

?>