<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$username = $_SESSION['username'];

$query = "(select project.projectID, `name`, `status`
	from `project` join `projectmanager` 
		on project.projectID = projectmanager.projectID
	where projectmanager.username = '".$username."' and (`status` = 'Complete' or `status` = 'Cancelled'))
	union (select project.projectID, `name`, `status`
		from `project` join `projectworkedon`
			on project.projectID = projectworkedon.projectID
		where projectworkedon.username = '".$username."' and (`status` = 'Complete' or `status` = 'Cancelled'))";

$project_result = mysqli_query($con, $query);

$jsondata = array();

while($project_row = mysqli_fetch_assoc($project_result)){
	$jsondata[] = $project_row;
}

echo json_encode($jsondata);

mysqli_close($con);

?>