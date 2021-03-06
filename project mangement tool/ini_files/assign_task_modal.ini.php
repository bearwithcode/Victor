    <!-- START MODAL ASSIGN TASK -->
    <div class="modal fade" id="assign_task_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="assign_task_modal_label">Assign Task</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label class="control-label">Search by:</label>
              <select id="qualification_select" class="form-control">
                <option value="invalid">-- Please select qualification to search by --</option>
                <option value="All">All</option>
                <option value="Expertise">Expertise</option>
                <option value="Role">Role</option>
              </select>
            </div>
            <div class="form-group" style="display: none;" id="qualification_selected_group">
              <label class="control-label" id="qualification_type_selected_label"></label>
              <select id="qualifications_available_select" class="form-control">
              </select>
            </div>
            <div class="panel-group" id="all_qualified_users" role="tablist" aria-multiselectable="true">
            </div> <!-- End of panel group -->
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="assign_task_button">Assign Task</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL ASSIGN TASK --> 