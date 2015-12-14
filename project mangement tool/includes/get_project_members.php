<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();

/* This is the code you need to change a result row to JSON */

if (isset($_POST['qualification_type']) && isset($_POST['project_id'])) {
	$query_user = "";
	$qualification_type = $_POST['qualification_type'];
	$project_id = $_POST['project_id'];

	if (isset($_POST['qualification'])) {
		$qualification = $_POST['qualification'];
	}

	if ($qualification_type == "Role") {
		$query_user = "select ui1.fname \"fname\", ui1.lname \"lname\", ui1.email \"email\", ui1.username \"username\"
				from `projectworkedon` pwo1 join `userinfo` ui1
					on ui1.username = pwo1.username
				where pwo1.role = '".$qualification."' and ui1.username in (
					select `username`
					from `projectworkedon`
					where `projectID` = '".$project_id."'
				)
				order by ui1.fname";
	} elseif ($qualification_type == "Expertise") {
		$query_user = "select ui1.fname \"fname\", ui1.lname \"lname\", ui1.email \"email\", ui1.username \"username\"
				from `userexpertise` ue1 join `userinfo` ui1
				 	on ue1.username = ui1.username
				where ue1.expertise = '".$qualification."' and ui1.username in (
					select `username`
					from `projectworkedon`
					where `projectID` = '".$project_id."'
				)
				order by ui1.fname";
	} elseif ($qualification_type == "All") {
		$query_user = "select fname, lname, email, username
				from `userinfo`
				where `username` in (
					select `username`
					from `projectworkedon`
					where `projectID` = '".$project_id."'
				)
				order by `fname`";
	}

	$user_result = mysqli_query($con, $query_user);

	$json_result = array();

	while($project_row = mysqli_fetch_assoc($user_result)){
		$json_result[] = $project_row;
	}

	echo json_encode($json_result);
}

mysqli_close($con);

?>