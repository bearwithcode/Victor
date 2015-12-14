<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$query = "select max(`projectID`) from `project`";

echo mysqli_fetch_array(mysqli_query($con, $query))[0];

?>