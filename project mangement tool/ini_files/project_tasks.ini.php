            <div id="project_tasks" class="body_divisions hidden">
              <div class="row placeholders">
                <div class="col-xs-6">
                  <h1 id="my_tasks_remaining_big"></h1>
                  <h4>Tasks You Have Left</h4>
                </div>
                <div class="col-xs-6">
                  <h1 id="all_tasks_remaining_big"></h1>
                  <h4>All Tasks Remaining</h4>
                </div>
              </div>
              <div class="pull-right hidden" id="create_task_div">
                <button class="btn btn-success" data-toggle="modal" data-target="#create_task_modal">
                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
                  Create Task
                </button>
              </div>
              <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#my_tasks" role="tab" data-toggle="tab">My Tasks</a></li>
                <li role="presentation"><a href="#all_tasks" role="tab" data-toggle="tab">All Tasks</a></li>
              </ul>

              <!-- Tab panes -->
              <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="my_tasks">
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>Task ID</th>
                          <th>Name</th>
                          <th>Status</th>
                          <th>Priority</th>
                          <th>Details</th>
                        </tr>
                      </thead>
                      <tbody id="project_table_my_tasks">
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
                <div role="tabpanel" class="tab-pane fade" id="all_tasks">
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>Task ID</th>
                          <th>Name</th>
                          <th>Status</th>
                          <th>Priority</th>
                          <th>Details</th>
                        </tr>
                      </thead>
                      <tbody id="project_table_all_tasks">
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
              </div>
            </div>