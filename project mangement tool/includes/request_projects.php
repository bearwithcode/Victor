<?php
require_once 'config.php';

session_start();

$username = $_SESSION['username']; //user this session variable to search database for the projects that this user is involved in
$con = connectToDatabase();

if ($_SESSION['role'] == "Administrator" && isset($_POST['dashboard'])) {
	$query = "select `projectID`, `name`, `status`, `description`,
			`location`, DATE_FORMAT(`startdate`, '%d-%m-%Y') `startdate`,
			`percentcomplete`, DATE_FORMAT(`enddate`, '%d-%m-%Y') `enddate`
			from `project`
			where `status` = 'Active'";

	$query = $query . " order by 1";

	$project_result = mysqli_query($con, $query);
	if (mysqli_error($con)) {
		echo mysqli_error($con);
		echo "\n";
		echo $query;
	}

	$jsondata = array();

	while($project_row = mysqli_fetch_assoc($project_result)){
		$jsondata[] = $project_row;
	}

	unset($_POST['dashboard']);
	
	echo json_encode($jsondata);
} else{
	/* This is the code you need to change a result row to JSON */
	$query = "(select project.projectID, `name`, `status`, `description`,
			`location`, DATE_FORMAT(`startdate`, '%d-%m-%Y') `startdate`,
			`percentcomplete`, DATE_FORMAT(`enddate`, '%d-%m-%Y') `enddate`
		from `project` join `projectmanager` 
			on project.projectID = projectmanager.projectID";

	if (isset($_POST['project_id'])) {
		$query = $query . " where project.projectID = '".$_POST['project_id']."'";
	}
	if (isset($_POST['dashboard'])) {
		$query = $query . " and project.status = 'Active' and projectmanager.username = '".$_SESSION['username']."'";
	} 

	$query = $query . ")";

	$query = $query . " union (select project.projectID, `name`, `status`, `description`,
			`location`, DATE_FORMAT(`startdate`, '%d-%m-%Y') `startdate`,
			`percentcomplete`, DATE_FORMAT(`enddate`, '%d-%m-%Y') `enddate`
			from `project` join `projectworkedon`
				on project.projectID = projectworkedon.projectID";

	if (isset($_POST['project_id'])) {
		$query = $query . " where project.projectID = '".$_POST['project_id']."'";
	} 
	if (isset($_POST['dashboard'])) {
		$query = $query . " and project.status = 'Active' and projectworkedon.username = '".$_SESSION['username']."'";
	} 
	$query = $query . ") order by 1";

	$project_result = mysqli_query($con, $query);
	if (mysqli_error($con)) {
		echo mysqli_error($con);
		echo "\n";
		echo $query;
	}

	$jsondata = array();

	while($project_row = mysqli_fetch_assoc($project_result)){
		$jsondata[] = $project_row;
	}

	echo json_encode($jsondata);
}

mysqli_close($con);

?>