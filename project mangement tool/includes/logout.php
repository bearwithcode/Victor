<?php
session_start();
unset($_SESSION['login_successful']);
unset($_SESSION['firstname']);
unset($_SESSION['username']);
unset($_SESSION['role']);
session_destroy();
header("location: ../index.php");
?>