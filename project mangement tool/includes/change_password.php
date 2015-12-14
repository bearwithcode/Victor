<?php
require_once 'config.php';

session_start();

$con = connectToDatabase();
$username = $_SESSION['username'];

if (isset($_POST['current_password']) && isset($_POST['new_password'])) {
	$current_password = md5($_POST['current_password']);
	$new_password = md5($_POST['new_password']);

	$query = "select count(*)
			 from `userinfo`
			 where username = '".$username."' and password = '".$current_password."'";

	$query_result = mysqli_query($con, $query);

	$user_exists = mysqli_fetch_array($query_result)[0];

	if ($user_exists) {
		$query = "update `userinfo` set `password` = '".$new_password."'
				 where `username` = '".$username."'";

		mysqli_query($con, $query);
		
		echo 0;
	} else{
		echo -1;
	}
}

mysqli_close($con);

?>