<?php

require_once 'config.php';
session_start();
$username = $_SESSION['username'];
$con = connectToDatabase();

if(isset($_POST['create']) && $_POST['create'] == "true"){

    $project_name = $_POST['name'];
    $status = "Active";
    $description = $_POST['description'];
    $location = $_POST['location'];
    
    // $pattern = '/^(((0[1-9]|[12][0-9]|3[01])([/])(0[13578]|10|12)([/])(\d{4}))|(([0][1-9]|[12][0-9]|30)([/])(0[469]|11)([/])(\d{4}))|((0[1-9]|1[0-9]|2[0-8])([/])(02)([/])(\d{4}))|((29)(\.|-|\/)(02)([/])([02468][048]00))|((29)([/])(02)([/])([13579][26]00))|((29)([/])(02)([/])([0-9][0-9][0][48]))|((29)([/])(02)([/])([0-9][0-9][2468][048]))|((29)([/])(02)([/])([0-9][0-9][13579][26])))';
    
    $start_date = date("Y-m-d", strtotime($_POST['startdate']));
    $end_date = date("Y-m-d", strtotime($_POST['enddate']));
    
    // if(!preg_match($pattern, $start_date) || !preg_match($pattern, $end_date)){
    //     header("location: ../dashboard.php"); //not sure if this handling error is right, I just redirect it
    // }
    
    $percent_complete = 0;

    $query = "INSERT INTO `project` (name, status, description, location, startdate, percentcomplete, enddate)
              VALUES ('".$project_name."', '".$status."', '".$description."', '".$location."', '".$start_date."', '".$percent_complete."', '".$end_date."')";

    mysqli_query($con, $query);

    $query = "SELECT COUNT(`projectID`) FROM `project`";

    $result = mysqli_fetch_array(mysqli_query($con, $query));

    $query = "select max(`projectID`) from `project`";

    $_SESSION['created_proj_id'] = mysqli_fetch_array(mysqli_query($con, $query))[0];

    // $stmt = mysqli_prepare($con, 'INSERT INTO `project` (name, status, description, location, startdate, percentcomplete, enddate) VALUES (?, ?, ?, ?, ?, ?, ?)');
    // mysqli_stmt_bind_param($stmt, 'sssssis', $project_name, $status, $description, $location, $start_date, $percent_complete, $end_date);
    
    // echo mysqli_stmt_execute($stmt);

    //$stmt->execute();
    
    // $stmt = $con->prepare('INSERT INTO `projectworkedon` (projectID, Username) VALUES (?, ?)');
    // $stmt->bind_param('ss',$con->insert_id,$username);
    
    // $stmt->execute();

    echo 0;

} else if (isset($_POST['edit']) && $_POST['edit'] == "true"){
    $project_name = $_POST['name'];
    $status = $_POST['status'];
    $description = $_POST['description'];
    $location = $_POST['location'];
    $project_id = $_POST['id'];
    
    // $pattern = '/^(((0[1-9]|[12][0-9]|3[01])([/])(0[13578]|10|12)([/])(\d{4}))|(([0][1-9]|[12][0-9]|30)([/])(0[469]|11)([/])(\d{4}))|((0[1-9]|1[0-9]|2[0-8])([/])(02)([/])(\d{4}))|((29)(\.|-|\/)(02)([/])([02468][048]00))|((29)([/])(02)([/])([13579][26]00))|((29)([/])(02)([/])([0-9][0-9][0][48]))|((29)([/])(02)([/])([0-9][0-9][2468][048]))|((29)([/])(02)([/])([0-9][0-9][13579][26])))';
    
    $start_date = date("Y-m-d", strtotime($_POST['startdate']));
    $end_date = date("Y-m-d", strtotime($_POST['enddate']));
    
    $query = "UPDATE `project`
              SET `name`='".$project_name."', `status`='".$status."', `description`='".$description."', `location`='".$location."', `startdate`='".$start_date."', `enddate`='".$end_date."'
              WHERE `projectID`='".$project_id."'";
    
    mysqli_query($con, $query);

    // $stmt = mysqli_prepare($con, 'INSERT INTO `project` (name, status, description, location, startdate, percentcomplete, enddate) VALUES (?, ?, ?, ?, ?, ?, ?)');
    // mysqli_stmt_bind_param($stmt, 'sssssis', $project_name, $status, $description, $location, $start_date, $percent_complete, $end_date);
    
    // echo mysqli_stmt_execute($stmt);

    //$stmt->execute();
    
    // $stmt = $con->prepare('INSERT INTO `projectworkedon` (projectID, Username) VALUES (?, ?)');
    // $stmt->bind_param('ss',$con->insert_id,$username);
    
    // $stmt->execute();

    echo 0;
}

mysqli_close($con);
?>
