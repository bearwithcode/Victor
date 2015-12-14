    <!-- START MODAL UPDATE TASK -->
    <div class="modal fade" id="update_task_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="update_task_modal_label">Update Task</h4>
          </div>
          <div class="modal-body">
            <label class="control-label" for="update_task_slider">Slide the slider to update the progress of this task:</label>
            <div class="input-group">
              <input type="range" class="form-control" id="update_task_slider">
              <span class="input-group-addon" id="update_task_slider_value">90%</span>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="update_task_button">Update Task</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL UPDATE TASK -->  