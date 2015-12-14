<?php
require_once 'config.php';

session_start();

$username = $_SESSION['username']; //user this session variable to search database for the projects that this user is involved in
$con = connectToDatabase();

/* This is the code you need to change a result row to JSON */


$query = "select `fname`, `lname`, `username`, `staffID`, `email`, `userrole`
		 from `userinfo`
		 where `username` = '".$username."'";

$query_result = mysqli_query($con, $query);

echo json_encode(mysqli_fetch_assoc($query_result));

mysqli_close($con);

?>