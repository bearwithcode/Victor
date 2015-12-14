$(document).ready(function(){
	$('#create_task_button').click(createTask);

	$('#create_task_modal').on('hidden.bs.modal', function(){
		$('input.form-control').val('');
		$('textarea.form-control').val('');
		$('#task_priority_div').children('.btn.btn-default.active').removeClass('active');
	});
});

function createTask () {
	var task_name = $('#new_task_name').val().trim();
	var task_description = $('#new_task_description').val().trim();
	var task_priority = $('#task_priority_div').children('.btn.btn-default.active').text().trim();
	var days_required = $('#new_task_days_required').val().trim();
	var optimistic_time = $('#new_task_op_time').val().trim();
	var pessimistic_time = $('#new_task_pes_time').val().trim();
	var proj_id = $('#project_name_big').attr('project_id');
	var is_okay = true;

	/* implement error message
	if (project_name == "") {
		$('#new_project_name').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_description == "") {
		$('#new_project_description').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_location == "") {
		$('#new_project_location').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_start_date == "") {
		$('#new_project_start_date').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_end_date == "") {
		$('#new_project_end_date').parent().addClass('has-error');
		is_okay = false;
	}
	*/

	if (is_okay) {
		$.post("includes/save_task.php", {
			tn: task_name,
			td: task_description,
			tp: task_priority,
			dr: days_required,
			ot: optimistic_time,
			pt: pessimistic_time,
			project_id: proj_id,
			create: "true"
		}, function(data){
			if($.isNumeric(data) && data == 0){
				loadTasks(proj_id);
				$('#create_task_modal').modal('hide');
				displayAlert(task_name + ' has been successfully created.');
			}
		}, "text");
	}
}
 