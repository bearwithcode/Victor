<?php

require_once 'config.php';
session_start();
$username = $_SESSION['username'];
$con = connectToDatabase();

$query = "select `expertise` from `userexpertise`
			where `username` = '".$username."'
			order by `username`";

$query_result = mysqli_query($con, $query);

$jsondata = array();

while($role_row = mysqli_fetch_array($query_result)){
	$jsondata[] = $role_row[0];
}

echo json_encode($jsondata);

mysqli_close($con);

?>