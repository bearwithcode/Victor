    <!-- START MODAL CREATE ROLES -->
    <div class="modal fade" id="create_roles_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="create_roles_modal_label">Create Roles</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label class="control-label">Existing Roles:</label>
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-4">
                    <ul id="role_list_0">
                    </ul>
                  </div>
                  <div class="col-md-4">
                    <ul id="role_list_1">
                    </ul>
                  </div>
                  <div class="col-md-4">
                    <ul id="role_list_2">
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <button class="btn btn-success" id="add_role_button">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
                Add Role
              </button>
            </div>
            <div id="role_text_boxes"></div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="create_roles_button">Create Roles</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL CREATE ROLES -->