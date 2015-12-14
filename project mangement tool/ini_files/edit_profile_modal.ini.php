    <!-- START MODAL EDIT PROFILE -->
    <div class="modal fade" id="edit_profile_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="profile_modal_label">Edit Profile</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label for="current_username" class="col-sm-2 control-label">Username:</label>
                <div class="col-sm-10">
                  <p class="form-control-static" id="current_username"></p>
                </div>
              </div>
              <div class="form-group">
                <label for="current_staff_id" class="col-sm-2 control-label">Staff ID:</label>
                <div class="col-sm-10">
                  <p class="form-control-static" id="current_staff_id"></p>
                </div>
              </div>
              <div class="form-group">
                <label for="current_role" class="col-sm-2 control-label">Role:</label>
                <div class="col-sm-10">
                  <p class="form-control-static" id="current_role"></p>
                </div>
              </div>
            </form>
            <div class="form-group">
              <label for="current_first_name" class="control-label">First Name:</label>
              <input type="text" class="form-control" id="current_first_name">
            </div>
            <div class="form-group">
              <label for="current_last_name" class="control-label">Last Name:</label>
              <input type="text" class="form-control" id="current_last_name">
            </div>
            <div class="form-group">
              <label for="current_email" class="control-label">Email:</label>
              <input type="text" class="form-control" id="current_email">
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="save_edit_profile_button">Save edits</button>
          </div>
        </div>
      </div>
    </div>
    <!-- END MODAL EDIT PROFILE -->