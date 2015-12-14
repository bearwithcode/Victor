<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();

if (isset($_POST['qualification'])) {
	$query = "";
	$qualification = $_POST['qualification'];

	if ($qualification == "Role") {
		$query = "select distinct `role`
				 from `projectworkedon`";
	} elseif ($qualification == "Expertise") {
		$query = "select distinct `expertise`
				 from `userexpertise`";
	}

	$query_result = mysqli_query($con, $query);

	$json_result = array();

	while($project_row = mysqli_fetch_array($query_result)){
		$json_result[] = $project_row[0];
	}

	echo json_encode($json_result);
}

mysqli_close($con);

?>