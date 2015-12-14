<?php

require_once 'config.php';
session_start();
$username = $_SESSION['username'];
$con = connectToDatabase();

if (isset($_POST['project_id'])) {
	$project_id = $_POST['project_id'];
	
	foreach ($_POST['data'] as $rolename) {
		$query = "insert into `projectroles` (projectID, rolename) values ('".$project_id."', '".$rolename."')";

		mysqli_query($con, $query);
	}

	echo 0;
}

mysqli_close($con);

?>