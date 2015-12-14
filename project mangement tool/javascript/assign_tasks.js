$(document).ready(function(){
	$('#qualification_select').change(loadQualification);
	$('#qualifications_available_select').change(loadUsersWithQualification);
	$('#assign_task_button').click(saveTaskAssignment);

	$('#assign_task_modal').on('hidden.bs.modal', function(){
		$('#qualification_select').val('invalid');

		$('#qualification_selected_group').css('display', 'none');

		$('#all_qualified_users').css('display', 'none');
	});
});

function loadQualification () {
	var qualification_type_selected = $("#qualification_select option:selected").val();
	var proj_id = $('#project_name_big').attr('project_id');

	$('#qualifications_available_select').text('');

	if (qualification_type_selected == "All"){
		$('#qualification_selected_group').slideUp();
		loadUsersWithQualification();
	} else if (qualification_type_selected != "invalid") {

		$.post("includes/get_project_qualifications.php", {qualification: qualification_type_selected, project_id: proj_id}, function(data){
			$('#qualifications_available_select').html('<option value="invalid">-- Please select ' + qualification_type_selected.toLowerCase() + ' --</option>');
			
			for (var i = 0; i < data.length; i++) {
				$('#qualifications_available_select').append('<option>' + data[i] + '</option>');
			}
		}, "json");

		$('#qualification_type_selected_label').text(qualification_type_selected + ':');

		$('#qualification_selected_group').slideDown();
	}
}

function loadUsersWithQualification () {
	var qualification_selected = $('#qualifications_available_select option:selected').val();
	var qualification_type_selected = $("#qualification_select option:selected").val();
	var proj_id = $('#project_name_big').attr('project_id');

	$.post("includes/get_project_members.php", {qualification_type: qualification_type_selected, qualification: qualification_selected, project_id: proj_id}, function(user_details){
		$('#all_qualified_users').html('<label class="control-label">Users:</label>');

		for (var i = 0; i < user_details.length; i++) {
			getAndPrintIndividualQualification(user_details[i], i);
		}
		
		$('#all_qualified_users').slideDown();
	}, "json");
}

function getAndPrintIndividualQualification(user_details, incrementor){
	$.post("includes/get_individual_qualifications.php", {username: user_details.username}, function(user_qualifications){
		$('#all_qualified_users').append(generateAccordianPanel(user_details, user_qualifications, incrementor));
	}, "json");
}

function saveTaskAssignment () {
	var checked_checkboxes = $('.user_checkboxes:checked');
	
	var user_assignment_array = new Array();

	for (var i = 0; i < checked_checkboxes.length; i++) {
		user_assignment_array.push($(checked_checkboxes[i]).next().text().trim());
	}

	$.post("includes/assign_tasks.php", {project_id: $('#project_name_big').attr('project_id'), task_id: $('#current_task_id').text().trim(), users: user_assignment_array}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#assign_task_modal').modal('hide');
			displayAlert('Project member assignment to this task has been saved.');
		}
	}, "text");

}
