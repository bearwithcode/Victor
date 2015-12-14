$(document).ready(function(){
	$('#new_comment').keyup(checkComment);

	$('#comment_modal').on('show.bs.modal', fillCommentModal);

	$('#comment_modal').on('hidden.bs.modal', function(){
		$('#new_comment').val('');
		$('#add_comment_button').addClass('disabled');
	});

	$('#add_comment_button').click(addComment);
});

function fillCommentModal () {
	var comments = '';
	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();

    $.post("includes/get_comments.php", {project_id: proj_id, task_id: taskid}, function(data){
    	for (var i = 0; i < data.length; i++) {
    		comments += '<div class="media comment_div"><div class="media-body">';
	    	comments += '<h4 class="media-heading">' + data[i].username + '<output class="text-muted"> on ' + data[i].commentDate + '</output></h4>';
	    	comments += '<span class="glyphicon glyphicon-comment" aria-hidden="true"></span> ' + data[i].commentDetails;
	    	comments += '</div></div>';
    	}
    	if (data.length == 0) {
    		comments = '<p class="text-center">There are no comments for this task yet.</p>';
    	}
    	$('#comment_div').html(comments);
    }, "json");
}

function checkComment () {
	var new_comment = $('#new_comment').val().trim();

	if (new_comment != "") {
		$('#add_comment_button').removeClass('disabled');
	} else{
		$('#add_comment_button').addClass('disabled');
	}
}

function addComment () {
	var new_comment = $('#new_comment').val().trim();
	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();

	$.post("includes/save_comment.php", {project_id: proj_id, task_id: taskid, comment: new_comment}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#new_comment').val('');
			$('#add_comment_button').addClass('disabled');
			$('#comment_div').text('');
			fillCommentModal();
		}
	}, "text");
}