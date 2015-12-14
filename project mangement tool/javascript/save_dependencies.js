$(document).ready(function(){
	$('#add_dependencies_modal').on('show.bs.modal', displayTasks);

	$('#add_dependencies_modal').on('hidden.bs.modal', function(){
		$('#dependencies_select').text('');
	});

	$('#save_dependencies_button').click(saveDependencies);
});

function displayTasks () {
	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();

	$.post("includes/request_tasks.php", {task_id: taskid, project_id: proj_id, dependencies: "true"}, function(data){
		var dependencies_html = '';

		for (var i = 0; i < data.length; i++) {
			dependencies_html += '<option chosen_id="' + data[i].taskID + '">' + data[i].taskID + ': ' + data[i].taskName + '</option>';
		}

		$('#dependencies_select').html(dependencies_html);
	}, "json");
}

function saveDependencies () {
	var proj_id = $('#project_name_big').attr('project_id');
	var taskid = $('#current_task_id').text().trim();
	var selected_dependencies = [];

	$('#dependencies_select :selected').each(function(i, selected){ 
		selected_dependencies[i] = $(selected).attr('chosen_id');
	});

	$.post("includes/save_dependencies.php", {task_id: taskid, project_id: proj_id, dependencies: selected_dependencies}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#add_dependencies_modal').modal('hide');
			displayAlert('The dependencies for this task have been saved.');
		}
	}, "text");
}
