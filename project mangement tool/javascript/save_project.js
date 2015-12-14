$(document).ready(function() {
	$('#create_project_button').click(createProject);
	$('#save_project_button').click(saveProject);
	$('#edit_project_modal').on('show.bs.modal', populateEditProjectModal);
	$('#create_project_modal').on('hidden.bs.modal', function(){
		$('#new_project_name').val('');
		$('#new_project_description').val('');
		$('#new_project_location').val('');
		$('#new_project_start_date').val('');
		$('#new_project_end_date').val('');
	});
});

function createProject () {
	var project_name = $('#new_project_name').val().trim();
	var project_description = $('#new_project_description').val().trim();
	var project_location = $('#new_project_location').val().trim();
	var project_start_date = $('#new_project_start_date').val().trim();
	var project_end_date = $('#new_project_end_date').val().trim();
	var is_okay = true;

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

	if (is_okay) {
		$.post("includes/save_project.php", {
			name: project_name,
			description: project_description,
			location: project_location,
			startdate: project_start_date,
			enddate: project_end_date,
			create: "true"
		}, function(data){
			if($.isNumeric(data) && data == 0){
				$('#create_project_modal').modal('hide');
				$('#add_project_manager_modal').modal('show');
			}
		}, "text");
	}
}

function saveProject () {
	var project_name = $('#current_project_name').val().trim();
	var project_description = $('#current_project_description').val().trim();
	var project_location = $('#current_project_location').val().trim();
	var project_start_date = $('#current_project_start_date').val().trim();
	var project_end_date = $('#current_project_end_date').val().trim();
	var project_id = $('#project_name_big').attr('project_id').trim();
	var is_okay = true;

	var project_status = $('#current_project_status').children('.btn.btn-default.active').text().trim();

	if (project_name == "") {
		$('#current_project_name').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_description == "") {
		$('#current_project_description').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_location == "") {
		$('#current_project_location').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_start_date == "") {
		$('#current_project_start_date').parent().addClass('has-error');
		is_okay = false;
	}
	if (project_end_date == "") {
		$('#current_project_end_date').parent().addClass('has-error');
		is_okay = false;
	}

	if (is_okay) {
		$.post("includes/save_project.php", {
			name: project_name,
			description: project_description,
			location: project_location,
			startdate: project_start_date,
			enddate: project_end_date,
			status: project_status,
			id: project_id,
			edit: "true"
		}, function(data){
			if($.isNumeric(data) && data == 0){
				displayProjectDetails(project_id);
				loadProjects();
				displayAlert("Edits to project have been saved.");
				$('#edit_project_modal').modal('hide');
			}
		}, "text");
	}	
}

function populateEditProjectModal(){
	var proj_id = $('#project_name_big').attr('project_id');

	$.post("includes/request_projects.php", {project_id: proj_id.toString()}, function(data){
		$('#current_project_name').val(data[0].name);

		$('#active_status').parent().removeClass('active');
		$('#complete_status').parent().removeClass('active');
		$('#cancelled_status').parent().removeClass('active');

		switch (data[0].status){
			case "Active":
				$('#active_status').parent().addClass('active');
				break;
			case "Complete":
				$('#complete_status').parent().addClass('active');
				break;
			case "Cancelled":
				$('#cancelled_status').parent().addClass('active');
				break;
		}

		$('#current_project_location').val(data[0].location);
		$('#current_project_start_date').val(data[0].startdate);
		$('#current_project_end_date').val(data[0].enddate);
		$('#current_project_description').val(data[0].description);

	}, "json");
}
