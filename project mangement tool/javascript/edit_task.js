$(document).ready(function(){
	$('#edit_task_modal').on('show.bs.modal', populateEditTaskModal);

	$('#edit_task_button').click(saveTaskChanges);
});

function saveTaskChanges () {
	var task_name = $('#current_task_name').val();
	var task_description = $('#current_task_description').val();

	var task_status = $('#task_status_div > .btn.btn-default.active').text().trim();

	var task_priority = $('#task_priority_div > .btn.btn-default.active').text().trim();

	var task_days_required = $('#current_task_days_required').val();
	var task_optimistic_time = $('#current_task_op_time').val();
	var task_pessimistic_time = $('#current_task_pes_time').val();

	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();

	//check for blanks

	$.post("includes/save_task.php", {
		taskname: task_name,
		description: task_description,
		status: task_status,
		priority: task_priority,
		days_required: task_days_required,
		optimistic_time: task_optimistic_time,
		pessimistic_time: task_pessimistic_time,
		project_id: proj_id,
		task_id: taskid,
		edit: "true"
	}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#edit_task_modal').modal('hide');
			displayTaskDetails(taskid);
			displayAlert("Task \"" + task_name + "\" successfully edited.");
		}
	}, "text");
}

function populateEditTaskModal () {
	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();

	$.post("includes/request_tasks.php", {task_id: taskid, project_id: proj_id}, function(data){
		$('#current_task_name').val(data[0].taskName);
		$('#current_task_description').val(data[0].taskDetails);

		$('.task_status_input').parent().removeClass('active');

		switch(data[0].taskStatus){
			case "Active":
				$('#edit_active_status').parent().addClass('active');
				break;
			case "Cancelled":
				$('#edit_cancelled_status').parent().addClass('active');
				break;
			case "Completed":
				$('#edit_completed_status').parent().addClass('active');
				break;
		}

		$('.task_priority_input').parent().removeClass('active');

		switch(data[0].taskPriority){
			case "Low":
				$('#edit_low_priority').parent().addClass('active');
				break;
			case "Medium":
				$('#edit_medium_priority').parent().addClass('active');
				break;
			case "High":
				$('#edit_high_priority').parent().addClass('active');
				break;
		}

		$('#current_task_days_required').val(data[0].daysrequired);
		$('#current_task_op_time').val(data[0].optimisticdays);
		$('#current_task_pes_time').val(data[0].pessimisticdays);
	}, "json");
}