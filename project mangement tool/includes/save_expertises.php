<?php

require_once 'config.php';
session_start();
$username = $_SESSION['username'];
$con = connectToDatabase();

foreach ($_POST['data'] as $expertisename) {
	$query = "insert into `userexpertise` (username, expertise) values ('".$username."', '".$expertisename."')";

	mysqli_query($con, $query);
}

echo 0;

mysqli_close($con);

?>