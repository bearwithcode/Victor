<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

$project_id = $_POST['project_id'];
$milestone_date = date("Y-m-d", strtotime($_POST['milestone_date']));
$milestone_name = $_POST['milestone_name'];

$query = "insert into `milestone` (projectID, date, name) values ('".$project_id."', '".$milestone_date."', '".$milestone_name."')";
mysqli_query($con, $query);

echo 0;
?>