            <div id="project_overview" class="body_divisions">
              <div class="row placeholders">
                <div class="col-xs-4">
                  <h1 id="people_in_project_big"></h1>
                  <h4>People in Project</h4>
                </div>
                <div class="col-xs-4">
                  <h1 id="percent_complete_big"></h1>
                  <h4>Complete</h4>
                  <span>
                    <div class="progress">
                      <div id="percent_complete_progress" class="progress-bar progress-bar-striped progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
                    </div>
                  </span>
                </div>
                <div class="col-xs-4">
                  <h1>45</h1>
                  <h4>Days to Completion</h4>
                </div>
              </div>

              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th colspan="2">Project Details</th>
                    </tr>
                  </thead>
                  <tbody id="project_table_details">
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
                <?php 
                  if (isset($_SESSION['role']) && ($_SESSION['role'] == "Administrator" || $_SESSION['role'] == "Project Manager")) {
                    echo '<div class="pull-left">
                            <button class="btn btn-primary" data-toggle="modal" data-target="#edit_project_modal">
                              <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                              Edit Project
                            </button>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#create_roles_modal">
                              <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                              Create Roles
                            </button>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#assign_project_members_modal">
                              <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                              Assign Project Members
                            </button>
                          </div>';
                  }
                ?>    
              </div>
            </div>