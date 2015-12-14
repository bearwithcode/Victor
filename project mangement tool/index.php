<?php
session_start();
if(isset($_SESSION['login_successful']) && $_SESSION['login_successful']){
    header("location: dashboard.php");
}
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/sticky-footer.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Project Management System</a>
        </div>

        <!-- HI VICTOR
        The form below is the login form.
        Please be careful when you add your php code
        -->

        <form class="navbar-form navbar-right login-form" method="post" action="includes/login.php">
            <div class="form-group">
              <input type="text" placeholder="Username" name="username" class="form-control" required autofocus>
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Sign in
              <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
            </button>
          </form>
      </div>
      <?php 
      if(isset($_SESSION['login_successful']) && !$_SESSION['login_successful']){
        echo ('<div class="alert alert-danger text-center" role="alert">We were unable to log you in with the information you provided.</div>');
        unset($_SESSION['login_successful']);
      }
      ?>
    </nav>

    <div class="jumbotron">
      <div class="container">
        <h1>Welcome!</h1>
        <p>If you are new to the Project Management System, please sign up below. If you are an existing user, please sign in above.</p>
        <!-- <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p> -->
      </div>
    </div>

    <div class="container">

      <!-- HI VICTOR
        The form below is the register form.
        Please be careful when you add your php code
       -->

       <form class="form-signup">
        <h2 class="form-signup-heading">Sign Up Here</h2>
        <label for="inputFirstName" class="sr-only">First Name</label>
        <input type="text" id="inputFirstName" name="firstname" class="form-control" placeholder="First Name" required>

        <label for="inputLastName" class="sr-only">Last Name</label>
        <input type="text" id="inputLastName" name="lastname" class="form-control" placeholder="Last Name" required>

        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required>

        <label for="inputStaffId" class="sr-only">Staff ID</label>
        <input type="text" id="inputStaffId" name="staffid" class="form-control" placeholder="Staff ID" required>

        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required>

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" length="6" placeholder="Password" required>

        <label for="inputConfirmPassword" class="sr-only">Confirm Password</label>
        <input type="password" id="inputConfirmPassword" class="form-control" length="6" placeholder="Confirm Password" required>

        <button type="button" class="btn btn-lg btn-primary btn-block form-signup-submit-button" id="sign_up_button">Sign Up Now!</button>
      </form>

    </div> <!-- /container -->

    <footer class="footer">
      <div class="container">
        <p class="text-muted">&copy; 2015 Michael Kong, Victor</p>
      </div>
    </footer>
    <script src="javascript/jquery.min.js"></script>
    <script src="javascript/signup.js"></script>
  </body>
</html>
