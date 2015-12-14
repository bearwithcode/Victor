    <!-- START MODAL ADD DEPENDENCIES -->
    <div class="modal fade" id="add_dependencies_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="add_dependencies_modal_label">Add Dependencies</h4>
          </div>
          <div class="modal-body">
            <form>
              <label for="dependencies_select" class="control-label">Select the predecessors of this task:
                <a href="#" rel="tooltip" data-toggle="tooltip" data-html="true" data-placement="right" title="Hold down the control (ctrl) button (Windows) or command (cmd) button (Mac) to select multiple options">
                  <span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>
                </a>
              </label>  
              <select class="form-control" id="dependencies_select" multiple>
              </select>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="save_dependencies_button">Save dependencies</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL ADD DEPENDENCIES -->    