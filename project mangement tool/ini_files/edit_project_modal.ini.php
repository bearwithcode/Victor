    <!-- START MODAL EDIT PROJECT -->
    <div class="modal fade" id="edit_project_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="project_modal_label">Edit Project</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label for="current_project_name" class="control-label">Name:</label>
              <input type="text" class="form-control" id="current_project_name">
            </div>
            <div class="form-group">
              <label class="control-label">Project Status:</label>
              <br>
              <div id="current_project_status" class="btn-group btn-group-justified" data-toggle="buttons">
                <label class="btn btn-default">
                  <input type="radio" name="project_status" autocomplete="off" id="active_status">Active
                </label>
                <label class="btn btn-default">
                  <input type="radio" name="project_status" autocomplete="off" id="complete_status">Complete
                </label>
                <label class="btn btn-default">
                  <input type="radio" name="project_status" autocomplete="off" id="cancelled_status">Cancelled
                </label>
              </div>
            </div>
            <div class="form-group">
              <label for="current_project_location" class="control-label">Location:</label>
              <input type="text" class="form-control" id="current_project_location">
            </div>
            <div class="form-group">
              <label for="current_project_start_date" class="control-label">Start Date:</label>
              <input type="text" class="form-control" id="current_project_start_date">
            </div>
            <div class="form-group">
              <label for="current_project_end_date" class="control-label">End Date:</label>
              <input type="text" class="form-control" id="current_project_end_date">
            </div>
            <div class="form-group">
              <label for="current_project_description" class="control-label">Description:</label>
              <textarea class="form-control" id="current_project_description"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="save_project_button">Save changes</button>
          </div>
        </div>
      </div>
    </div>
    <!-- END MODAL EDIT PROJECT -->