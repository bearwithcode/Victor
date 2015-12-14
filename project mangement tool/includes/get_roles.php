<?php

require_once 'config.php';
session_start();
$username = $_SESSION['username'];
$con = connectToDatabase();

if (isset($_POST['project_id'])) {
	$project_id = $_POST['project_id'];
	
	$query = "select `rolename` from `projectroles`
				where `projectID`='".$project_id."' or `projectID`='-1'
				order by `projectID`";

	$query_result = mysqli_query($con, $query);

	$jsondata = array();

	while($role_row = mysqli_fetch_array($query_result)){
		$jsondata[] = $role_row[0];
	}

	echo json_encode($jsondata);
}

mysqli_close($con);

?>