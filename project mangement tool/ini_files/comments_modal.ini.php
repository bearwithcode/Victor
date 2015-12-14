    <!-- START MODAL COMMENTS -->
    <div class="modal fade" id="comment_modal" tabindex="-1" role="dialog" aria-labelledby="project_modal_label" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="comment_modal_label">Comments</h4>
          </div>
          <div class="modal-body">
            <div id="comment_div">
            </div> <!-- end comment div -->
            <br>
            <div class="form-group">
              <label for="new_comment" class="control-label">Your comment:</label>
              <textarea class="form-control" id="new_comment"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary disabled" id="add_comment_button">Add Comment</button>
          </div>
        </div>
      </div>
    </div>    
    <!-- END MODAL COMMENTS -->