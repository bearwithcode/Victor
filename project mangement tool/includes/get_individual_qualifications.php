<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();

if (isset($_POST['username'])) {
	$query = "select `expertise`
			from `userexpertise`
			where `username` = '".$_POST['username']."'
			limit 3";

	$result = mysqli_query($con, $query);

	$expertise_array = array();

	while($project_row = mysqli_fetch_array($result)){
		$expertise_array[] = $project_row[0];
	}

	$query = "select `role`
			from `projectworkedon`
			where `username` = '".$_POST['username']."'
			limit 3";

	$result = mysqli_query($con, $query);

	$role_array = array();

	while($project_row = mysqli_fetch_array($result)){
		$role_array[] = $project_row[0];
	}

	$result_array = array();

	$result_array['expertises'] = $expertise_array;
	$result_array['roles'] = $role_array;

	echo json_encode($result_array);
}

?>