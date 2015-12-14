<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();

if (isset($_POST['qualification'])) {
	$query = "";
	$qualification = $_POST['qualification'];

	if ($qualification == "Role") {
		if (isset($_POST['project_id'])) {
			$query = "select distinct `rolename`
				 from `projectroles`
				 where `projectID` = '".$project_id."' or `projectID` = '-1'";
		} else{
			$query = "select distinct `rolename`
				 from `projectroles`";
		}
	} elseif ($qualification == "Expertise") {
		if (isset($_POST['project_id'])) {
			$query = "select distinct ue1.expertise
				 from `projectworkedon` pwo1 join `userexpertise` ue1
				 	on pwo1.username = ue1.username
				 where pwo1.projectID = '".$project_id."'";
		} else{
			$query = "select distinct ue1.expertise
				 from `projectworkedon` pwo1 join `userexpertise` ue1
				 	on pwo1.username = ue1.username";
		}
	}

	$query_result = mysqli_query($con, $query);

	mysqli_error($con);

	$json_result = array();

	while($project_row = mysqli_fetch_array($query_result)){
		$json_result[] = $project_row[0];
	}

	echo json_encode($json_result);
}

mysqli_close($con);

?>