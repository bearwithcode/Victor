<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if (isset($_POST['users'])) {
	$project_id = $_SESSION['created_proj_id'];

	foreach ($_POST['users'] as $username) {
		$query = "insert into `projectmanager` (username, projectID) values ('".$username."', '".$project_id."')";
		mysqli_query($con, $query);
	}

	echo 0;
}
?>