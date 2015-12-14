<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();

/* This is the code you need to change a result row to JSON */
$query_user = "select max(projectID)
			from `project`";

echo mysqli_fetch_array(mysqli_query($con, $query_user))[0];

mysqli_close($con);

?>