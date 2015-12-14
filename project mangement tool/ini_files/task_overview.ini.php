            <div id="task_overview" class="body_divisions hidden">
              <div class="row placeholders">
                <div class="col-xs-6">
                  <h1 id="days_required_big"></h1>
                  <h4>Days Required</h4>
                </div>
                <div class="col-xs-6">
                  <h1 id="percent_complete_big_task"></h1>
                  <h4>Complete</h4>
                  <span>
                    <div class="progress">
                      <div id="percent_complete_task" class="progress-bar progress-bar-striped progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
                    </div>
                  </span>
                </div>
              </div>

              <div>
                <button id="return_to_tasks" class="btn btn-info">
                  <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
                  Return to Tasks
                </button>
              </div>

              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th colspan="2">Task Details</th>
                    </tr>
                  </thead>
                  <tbody id="task_table_details">
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
                <div class="pull-left">

                  <span class="hidden" id="task_manipulation_div">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#edit_task_modal">
                      <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                      Edit Task
                    </button>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#assign_task_modal">
                      <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                      Assign Task
                    </button>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#add_dependencies_modal">
                      <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                      Add Dependencies
                    </button>
                  </span>

                  <button class="btn btn-primary" data-toggle="modal" data-target="#update_task_modal">
                    <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
                    Update Task Progress
                  </button>
                  <button class="btn btn-primary" data-toggle="modal" data-target="#propose_subtask_modal">
                    <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                    Propose Subtask
                  </button>
                  <button class="btn btn-primary" data-toggle="modal" data-target="#comment_modal">
                    <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
                    <span id="comment_button_text"></span>
                  </button>
                </div>
              </div>
            </div>