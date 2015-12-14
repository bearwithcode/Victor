    <!-- START MODAL CREATE TASK  -->
    <div class="modal fade" id="create_task_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="task_details_modal_label">Create Task</h4>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="new_task_name" class="control-label">Task Name:</label>
                <input type="text" class="form-control" id="new_task_name">
              </div>
              <div class="form-group">
                <label for="new_task_description" class="control-label">Task Description:</label>
                <textarea class="form-control" id="new_task_description"></textarea>
              </div>
              <div class="form-group">
                <label class="control-label">Task Priority:</label>
                <br>
                <div id="task_priority_div" class="btn-group btn-group-justified" data-toggle="buttons">
                  <label class="btn btn-default">
                    <input type="radio" name="task_priority_input" autocomplete="off" id="low_priority">Low
                  </label>
                  <label class="btn btn-default">
                    <input type="radio" name="task_priority_input" autocomplete="off" id="medium_priority">Medium
                  </label>
                  <label class="btn btn-default">
                    <input type="radio" name="task_priority_input" autocomplete="off" id="high_priority">High
                  </label>
                </div>
              </div>
              <div class="form-group">
                <label for="new_task_days_required" class="control-label">Days Required:</label>
                <input type="text" class="form-control" id="new_task_days_required">
              </div>
              <div class="form-group">
                <label for="new_task_op_time" class="control-label">Optimistic Time (Days):</label>
                <input type="text" class="form-control" id="new_task_op_time">
              </div>
              <div class="form-group">
                <label for="new_task_pes_time" class="control-label">Pessimistic Time (Days):</label>
                <input type="text" class="form-control" id="new_task_pes_time">
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="create_task_button">Create Task</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL CREATE TASK -->