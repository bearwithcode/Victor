$(document).ready(function(){
	$('#update_task_modal').on('show.bs.modal', function(){
		var percent_complete = $('#percent_complete_big_task').text().trim();
		var percent_value = percent_complete.substring(0, percent_complete.indexOf("%"));

		$('#update_task_slider_value').text(percent_complete);
		$('#update_task_slider').val(percent_value);
	});

	$('#update_task_slider').mousemove(updateInterface);
	$('#update_task_slider').click(updateInterface);	
	$('#update_task_slider').on('swipemove', updateInterface);
	$('#update_task_button').click(updateTask);
});

function updateInterface () {
	var percent_complete = $(this).val();
	$('#update_task_slider_value').text(percent_complete + "%");
}

function updateTask () {
	var updated_value = $('#update_task_slider').val();
	$('#percent_complete_big_task').text(updated_value + "%");
	$('#percent_complete_task').css("width", updated_value + "%");

	$.post("includes/update_task.php", {percent_complete: updated_value, task_id: $('#current_task_id').text().trim(), project_id: $('#project_name_big').attr('project_id')}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#update_task_modal').modal('hide');
			displayAlert('Update saved.');
		}
	}, "text");
}