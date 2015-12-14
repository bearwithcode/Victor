<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- <link rel="icon" href="../../favicon.ico"> -->

    <title>Dashboard</title>

    <style type="text/css">
    .project_row{
      cursor: pointer;
    }
    .task_row{
      cursor: pointer;
    }
    textarea{
      resize: vertical;
    }
    #alert_box{
      margin-top: 5px;
      position: fixed;
      top: 0;
      left: 50%;
      transform: translateX(-50%);
      z-index: 2000;
    }
    </style>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- jQuery UI CSS -->
    <link href="css/jquery-ui.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div id="alert_box"></div>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="dashboard.php">Project Management System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#" data-toggle="modal" data-target="#edit_expertises_modal">Add Expertises
              <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
            </a></li>
            <li><a href="#" data-toggle="modal" data-target="#change_password_modal">Change Password 
              <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
            </a></li>
            <li><a href="#" data-toggle="modal" data-target="#edit_profile_modal">Edit Profile 
              <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            </a></li>
            <li><a href="includes/logout.php">Logout 
              <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
            </a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar dashboard_side_nav">
            <li class="active side_nav" nav-index="1"><a href="#">Dashboard</a></li>
            <li class="side_nav" nav-index="2"><a href="#">Project Archive</a></li>
            <li class="side_nav" nav-index="3"><a href="#">View All Users</a></li>
          </ul>
          <ul class="nav nav-sidebar hidden project_side_nav">
            <li class="active side_nav" nav-index="1"><a href="#">Project Overview</a></li>
            <li class="side_nav" nav-index="2"><a href="#">Tasks <span class="badge" id="tasks_remaining_badge"></span></a></li>
          </ul>
          <ul class="nav nav-sidebar hidden project_side_nav">
            <li class="side_nav" nav-index="3" id="gantt_c"><a href="#">Gantt Chart</a></li>
            <li class="side_nav" nav-index="4" id="apn_pert"><a href="#">Activity Precedence Network &amp; PERT Analysis</a></li>
            <li class="side_nav" nav-index="5"><a href="#">Constructive Cost Model (COCOMO)</a></li>
            <li class="side_nav" nav-index="6"><a href="#">Function Points</a></li>
          </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">  
          <!-- BEGIN OVERVIEW DIV -->
          <div id="overview" class="main_divisions">
            <h1 class="page-header"><?php echo $_SESSION['firstname'] ?>'s Dashboard</h1>
            <div class="row placeholders">
              <div class="col-xs-6">
                <h1 id="no_of_projects_big"></h1>
                <h4>Active Projects</h4>
              </div>
              <div class="col-xs-6">
                <h1 id="no_of_tasks_big"></h1>
                <h4>Active Tasks</h4>
              </div>
            </div>

            <?php 
              if (isset($_SESSION['role']) && $_SESSION['role'] == "Administrator") {
                echo '<div class="pull-right">
                        <button class="btn btn-success" data-toggle="modal" data-target="#create_project_modal">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
                          Create Project
                        </button>
                      </div>';
              }
            ?>

            <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active"><a href="#my_projects" role="tab" data-toggle="tab">My Projects</a></li>
              <li role="presentation"><a href="#all_active_tasks" role="tab" data-toggle="tab">All Active Projects</a></li>
            </ul>

            <div class="tab-content">
              <div role="tabpanel" class="tab-pane fade in active" id="my_projects">
                <div class="table-responsive">
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Project ID</th>
                        <th>Project Name</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody id="project_table">
                      <!-- <tr>
                        <td>1</td>
                        <td>Eating Management System</td>
                        <td>Not completed</td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Marathon Management System</td>
                        <td>Cancelled</td>
                      </tr> -->
                    </tbody>
                  </table>
                </div>
              </div>
              <div role="tabpanel" class="tab-pane fade" id="all_active_tasks">
                <div class="table-responsive">
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Project ID</th>
                        <th>Project Name</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody id="all_active_project_table">
                      <!-- <tr>
                        <td>1</td>
                        <td>Eating Management System</td>
                        <td>Not completed</td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Marathon Management System</td>
                        <td>Cancelled</td>
                      </tr> -->
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!-- END OVERVIEW DIV -->

          <!-- BEGIN PROJECT DIV -->
          <div id="project" class="main_divisions hidden">
            <h1 class="page-header">
              <span id="project_name_big"></span>
              <div class="pull-right">
                <button id="return_to_dashboard" class="btn btn-info">
                  <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
                  Return to Dashboard
                </button>
              </div>
            </h1>
            <?php 
              include("ini_files/project_overview.ini.php");
              include("ini_files/project_tasks.ini.php");
              include("ini_files/task_overview.ini.php");
              include("ini_files/gantt_chart.ini.php");
              include("ini_files/apn_pert.ini.php");
              include("ini_files/function_points.ini.php");
              include("ini_files/cocomo.ini.php");
            ?>
          </div>
          <!-- END PROJECT DIV -->

          <!-- BEGIN PROJECT ARCHIVE DIV -->
          <div id="project_archive" class="main_divisions hidden">
            <h1 class="page-header">Project Archive</h1>
            <div class="row placeholders">
              <div class="col-xs-6">
                <h1 id="number_of_completed_projects"></h1>
                <h4>Complete Projects</h4>
              </div>
              <div class="col-xs-6">
                <h1 id="number_of_cancelled_projects"></h1>
                <h4>Cancelled Projects</h4>
              </div>
            </div>

            <div class="table-responsive">
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>Project ID</th>
                    <th>Project Name</th>
                    <th>Status</th>
                  </tr>
                </thead>
                <tbody id="project_archive_table">
                  <!-- <tr>
                    <td>Project Status:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Project Description:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Location:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Start Date:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>End Date:</td>
                    <td></td>
                  </tr> -->
                </tbody>
              </table>
            </div>
          </div>
          <!-- END PROJECT ARCHIVE DIV -->

          <!-- BEGIN ALL USERS DIV -->
          <div id="all_users_div" class="main_divisions hidden">
            <h1 class="page-header">All Users</h1>
            <div class="row placeholders">
              <div class="col-xs-3">
                <h1 id="total_number_of_users"></h1>
                <h4>Number of Users</h4>
              </div>
              <div class="col-xs-3">
                <h1 id="number_of_project_members"></h1>
                <h4>Number of Project Members</h4>
              </div>
              <div class="col-xs-3">
                <h1 id="number_of_project_managers"></h1>
                <h4>Number of Project Managers</h4>
              </div>
              <div class="col-xs-3">
                <h1 id="number_of_administrators"></h1>
                <h4>Number of Administrators</h4>
              </div>
            </div>

            <div class="table-responsive">
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Staff ID</th>
                    <th>Email</th>
                    <th>Role</th>
                  </tr>
                </thead>
                <tbody id="all_users_table">
                  <!-- <tr>
                    <td>Project Status:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Project Description:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Location:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Start Date:</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>End Date:</td>
                    <td></td>
                  </tr> -->
                </tbody>
              </table>
            </div>
          </div>
          <!-- END ALL USERS DIV -->
        </div>
      </div>
    </div>

    <?php
      include("ini_files/add_dependencies_modal.ini.php");
      include("ini_files/assign_project_members_modal.ini.php");
      include("ini_files/assign_roles_modal.ini.php");
      include("ini_files/assign_task_modal.ini.php");
      include("ini_files/change_password_modal.ini.php");
      include("ini_files/create_project_modal.ini.php");
      include("ini_files/create_roles_modal.ini.php");
      include("ini_files/create_task_modal.ini.php");
      include("ini_files/edit_expertises_modal.ini.php");
      include("ini_files/edit_profile_modal.ini.php");
      include("ini_files/edit_project_modal.ini.php");
      include("ini_files/edit_task_modal.ini.php");
      include("ini_files/project_manager_modal.ini.php");
      include("ini_files/update_task_modal.ini.php");
      include("ini_files/add_milestone_modal.ini.php");
      include("ini_files/comments_modal.ini.php");
    ?>

    <!-- START MODAL TASK DETAILS -->
    <div class="modal fade" id="task_details_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="task_details_modal_label">Task Details</h4>
          </div>
          <div class="modal-body">
            <div></div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL TASK DETAILS -->    

    <span class="hidden">
      <span id="expected_time"></span>
      <span id="standard_deviation"></span>   
    </span>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="javascript/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="javascript/jquery-ui.min.js"></script>
    <script src="javascript/go.js"></script>
    <script src="javascript/display_alert.js"></script>
    <script src="javascript/load_projects.js"></script>
    <script src="javascript/display_project.php"></script>
    <script src="javascript/save_project.js"></script>
    <script src="javascript/add_role.js"></script>
    <script src="javascript/edit_profile.js"></script>
    <script src="javascript/edit_project_members.js"></script>
    <script src="javascript/change_password.js"></script>
    <script src="javascript/display_task.js"></script>
    <script src="javascript/create_task.js"></script>
    <script src="javascript/edit_expertises.js"></script>
    <script src="javascript/save_dependencies.js"></script>
    <script src="javascript/assign_tasks.js"></script>
    <script src="javascript/add_project_manager.js"></script>
    <script src="javascript/jgestures.js"></script>
    <script src="javascript/update_task.js"></script>
    <script src="javascript/edit_task.js"></script>
    <script src="javascript/add_milestone.js"></script>
    <script src="javascript/comment.js"></script>
    <script src="javascript/apn_pert.js"></script>
    <script src="javascript/moment.js"></script>
    <script src="javascript/gantt_chart.js"></script>
    <script src="javascript/cocomo.js"></script>
    <script src="javascript/function_points.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
      $('#return_to_dashboard').click(function(){
        $('#overview').removeClass('hidden');
        $('#project').addClass('hidden');
        $('.dashboard_side_nav').removeClass('hidden');
        $('.dashboard_side_nav > li[nav-index="1"] > a').trigger('click');
        $('.project_side_nav').addClass('hidden');
        $('#percent_complete_progress').attr('style', 'width: 0%;');
      });

      $('#return_to_tasks').click(function(){
        $('#project_tasks').removeClass('hidden');
        $('#task_overview').addClass('hidden');
      });

      $(function () {
        $('[data-toggle="tooltip"]').tooltip({ selector: "a" });
      });

      $("#new_project_start_date").datepicker({
        changeMonth: true,//this option for allowing user to select month
        changeYear: true, //this option for allowing user to select from year range
        dateFormat: "dd-mm-yy"
      });
      $("#new_project_end_date").datepicker({
        changeMonth: true,//this option for allowing user to select month
        changeYear: true, //this option for allowing user to select from year range
        dateFormat: "dd-mm-yy"
      });
      $("#current_project_start_date").datepicker({
        changeMonth: true,//this option for allowing user to select month
        changeYear: true, //this option for allowing user to select from year range
        dateFormat: "dd-mm-yy"
      });
      $("#current_project_end_date").datepicker({
        changeMonth: true,//this option for allowing user to select month
        changeYear: true, //this option for allowing user to select from year range
        dateFormat: "dd-mm-yy"
      });
      $("#milestone_date_input").datepicker({
        changeMonth: true,//this option for allowing user to select month
        changeYear: true, //this option for allowing user to select from year range
        dateFormat: "dd-mm-yy"
      });
      $('.dashboard_side_nav > .side_nav').click(function(){
        $('.active.side_nav').removeClass('active');
        $('.main_divisions').addClass('hidden');
        $(this).addClass('active');
        switch(parseInt($(this).attr('nav-index'))){
          case 1:
            $('#overview').removeClass('hidden');
            break;
          case 2:
            $('#project_archive').removeClass('hidden');
            break;
          case 3:
             $('#all_users_div').removeClass('hidden');
            break;
        }
      });

      $('.project_side_nav > .side_nav').click(function(){
        $('.active.side_nav').removeClass('active');
        $(this).addClass('active');
        $('.body_divisions').addClass('hidden');
        switch(parseInt($(this).attr('nav-index'))){
          case 1:
            $('#project_overview').removeClass('hidden');
            break;
          case 2:
            $('#project_tasks').removeClass('hidden');
            break;
          case 3:
            $('#gantt_chart').removeClass('hidden');
            break;
          case 4:
            $('#activity_precedence_network').removeClass('hidden');
            break;
          case 5:
            $('#cocomo').removeClass('hidden');
            break;
          case 6:
            $('#function_points').removeClass('hidden');
            break;
        }
      });
    });
    </script>
  </body>
</html>