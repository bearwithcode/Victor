    <!-- START MODAL EDIT EXPERTISES -->
    <div class="modal fade" id="edit_expertises_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="edit_expertises_modal_label">Edit Expertises</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label class="control-label">Your Existing Expertises:</label>
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-4">
                    <ul id="expertise_list_0">
                    </ul>
                  </div>
                  <div class="col-md-4">
                    <ul id="expertise_list_1">
                    </ul>
                  </div>
                  <div class="col-md-4">
                    <ul id="expertise_list_2">
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <button class="btn btn-success" id="add_expertise_button">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
                Add Expertise
              </button>
            </div>
            <div id="expertise_text_boxes"></div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="create_expertises_button">Create Expertises</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL EDIT EXPERTISES -->