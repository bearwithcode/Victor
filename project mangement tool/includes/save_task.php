<?php

require_once 'config.php';
session_start();
$con = connectToDatabase();

if(isset($_POST['create']) && $_POST['create'] == "true"){

    $task_name = $_POST['tn'];
    $task_description = $_POST['td'];
    $task_priority = $_POST['tp'];
    $days_required = $_POST['dr'];
    $optimistic_time = $_POST['ot'];
    $pessimistic_time = $_POST['pt'];
    $project_id = $_POST['project_id'];
    $percent_complete = 0;

    $query = "select max(taskID)
            from `task`
            where `projectID` = '".$project_id."'";

    $result = mysqli_fetch_array(mysqli_query($con, $query))[0];

    $task_id = $result + 1;

    $query = "INSERT INTO `task` (projectID, taskID, taskName, taskStatus, taskDetails, taskPriority, percentcomplete, daysrequired, optimisticdays, pessimisticdays)
              VALUES ('".$project_id."', '".$task_id."', '".$task_name."', 'Unassigned', '".$task_description."', '".$task_priority."', '".$percent_complete."', '".$days_required."', '".$optimistic_time."', '".$pessimistic_time."')";
    
    mysqli_query($con, $query);

    $query = "insert into `taskdependencies` (projectID, taskID)
            values ('".$project_id."', '".$task_id."')";

    mysqli_query($con, $query);
    echo 0;

} else if (isset($_POST['edit']) && $_POST['edit'] == "true"){

    $taskname = $_POST['taskname'];
    $description = $_POST['description'];
    $status = $_POST['status'];
    $priority = $_POST['priority'];
    $days_required = $_POST['days_required'];
    $optimistic_time = $_POST['optimistic_time'];
    $pessimistic_time = $_POST['pessimistic_time'];
    $project_id = $_POST['project_id'];
    $task_id = $_POST['task_id'];

    $query = "update `task`
            set `taskName` = '".$taskname."', `taskStatus` = '".$status."', `taskDetails` = '".$description."', `taskPriority` = '".$priority."',
            `daysrequired` = '".$days_required."', `optimisticdays` = '".$optimistic_time."', `pessimisticdays` = '".$pessimistic_time."'
            where `projectID` = '".$project_id."' and `taskID` = '".$task_id."'";
    
    mysqli_query($con, $query);
    echo 0;
}

mysqli_close($con);
?>
