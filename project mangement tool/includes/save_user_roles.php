<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['project_id'])) {
	$project_id = $_POST['project_id'];
	$user_roles = $_POST['user_roles'];
	
	foreach ($user_roles as $user_role) {
		$query = "insert into `projectworkedon` (username, role, projectID) values ('".$user_role[0]."', '".$user_role[1]."', '".$project_id."')";

		mysqli_query($con, $query);
	}

	echo 0;
}

mysqli_close($con);

?>