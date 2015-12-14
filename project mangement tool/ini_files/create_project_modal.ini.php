    <!-- START MODAL CREATE PROJECT -->
    <div class="modal fade" id="create_project_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="project_modal_label">Create Project</h4>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="new_project_name" class="control-label">Project Name:</label>
                <input type="text" class="form-control" id="new_project_name">
              </div>
              <div class="form-group">
                <label for="new_project_location" class="control-label">Location:</label>
                <input type="text" class="form-control" id="new_project_location">
              </div>
              <div class="form-group">
                <label for="new_project_start_date" class="control-label">Start Date:</label>
                <input type="text" class="form-control" id="new_project_start_date">
              </div>
              <div class="form-group">
                <label for="new_project_end_date" class="control-label">End Date:</label>
                <input type="text" class="form-control" id="new_project_end_date">
              </div>
              <div class="form-group">
                <label for="new_project_description" class="control-label">Description:</label>
                <textarea class="form-control" id="new_project_description"></textarea>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="create_project_button">Create project</button>
          </div>
        </div>
      </div>
    </div>
    <!-- END MODAL CREATE PROJECT -->