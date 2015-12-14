    <!-- START MODAL PROJECT MANAGER -->
    <div class="modal fade" id="add_project_manager_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="add_project_manager_modal_label">Add Project Manager</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label class="control-label">Search by:</label>
              <select id="qs" class="form-control">
                <option value="invalid">-- Please select qualification to search by --</option>
                <option value="All">All</option>
                <option value="Expertise">Expertise</option>
                <option value="Role">Role</option>
              </select>
            </div>
            <div class="form-group" style="display: none;" id="qsg">
              <label class="control-label" id="qtsl"></label>
              <select id="qas" class="form-control">
              </select>
            </div>
            <div class="panel-group" id="aqu" role="tablist" aria-multiselectable="true">
            </div> <!-- End of panel group -->
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="add_project_manager_button">Add Project Manager</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL PROJECT MANAGER -->  