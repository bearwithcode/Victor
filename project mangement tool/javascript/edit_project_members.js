$(document).ready(function(){
	$('#qualification_type_select').change(loadQualifications);
	$('#qualification_available_select').change(loadUsersWithQualifications);
	$('#assign_project_members_button').click(getSelectedUsers);
	$('#assign_roles_modal_button').click(saveUsersAndRoles);

	$('#assign_project_members_modal').on('hidden.bs.modal', resetProjectMemberAssignmentModal);
	$('#assign_roles_modal').on('hidden.bs.modal', resetAssignRolesModal);
});

function getSelectedUsers () {
	var checked_checkboxes = $('.user_checkboxes:checked');
	var proj_id = $('#project_name_big').attr('project_id');

	$.post("includes/get_roles.php", {project_id: proj_id}, function(data){
		for (var i = 0; i < checked_checkboxes.length; i++) {
			printSelectedUserAndDropDown($(checked_checkboxes[i]).next().text().trim(), data);
		}

		$('#assign_project_members_modal').modal('hide');
		$('#assign_roles_modal').modal('show');
	}, "json");
}

function printSelectedUserAndDropDown(username, roles){
	var roles_available = '<option value="invalid">-- Please select a role for this user --</option>';

	for (var i = 0; i < roles.length; i++) {
		roles_available += '<option value="' + roles[i] + '">' + roles[i] + '</option>';
	}

	var single_user = '<div class="form-group">'
						+ '<label class="control-label col-sm-2 selected_user">' + username + '</label> '
						+ '<div class="col-sm-10">'
							+ '<select class="form-control">'
								+ roles_available
							+ '</select>'
						+ '</div>'
					+ '</div>';

	$('#assign_roles_modal_form').append(single_user);
}

function saveUsersAndRoles () {
	var selected_users = $('.selected_user');

	var user_role_array = new Array();

	for (var i = 0; i < selected_users.length; i++) {
		var single_user = [$(selected_users[i]).text(), $(selected_users[i]).next().children('.form-control').val()];
		user_role_array.push(single_user);
	}

	$.post("includes/save_user_roles.php", {project_id: $('#project_name_big').attr('project_id'), user_roles: user_role_array}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#assign_roles_modal').modal('hide');
			displayAlert('All users and their roles have been saved.');
		}
	}, "text");
}

function loadQualifications () {
	var qualification_type_selected = $("#qualification_type_select option:selected").val();

	$('#qualification_available_select').text('');

	if (qualification_type_selected == "All"){
		$('#qualification_available_group').slideUp();
		loadUsersWithQualifications();
	} else if (qualification_type_selected != "invalid") {

		$.post("includes/get_qualifications.php", {qualification: qualification_type_selected}, function(data){
			$('#qualification_available_select').html('<option value="invalid">-- Please select ' + qualification_type_selected.toLowerCase() + ' --</option>');
			
			for (var i = 0; i < data.length; i++) {
				$('#qualification_available_select').append('<option>' + data[i] + '</option>');
			}
		}, "json");

		$('#qualification_type_label').text(qualification_type_selected + ':');

		$('#qualification_available_group').slideDown();
	}
}

function loadUsersWithQualifications () {
	var qualification_selected = $('#qualification_available_select option:selected').val();
	var qualification_type_selected = $("#qualification_type_select option:selected").val();
	var proj_id = $('#project_name_big').attr('project_id');

	$.post("includes/get_users.php", {qualification_type: qualification_type_selected, qualification: qualification_selected, project_id: proj_id}, function(user_details){
		$('#qualified_users').html('<label class="control-label">Users:</label>');

		for (var i = 0; i < user_details.length; i++) {
			getAndPrintIndividualQualifications(user_details[i], i);
		}
		
		$('#qualified_users').slideDown();
	}, "json");
}

function getAndPrintIndividualQualifications(user_details, incrementor){
	$.post("includes/get_individual_qualifications.php", {username: user_details.username}, function(user_qualifications){
		$('#qualified_users').append(generateAccordianPanel(user_details, user_qualifications, incrementor));
	}, "json");
}

function generateAccordianPanel(user_details, user_qualifications, incrementor){
	var expertise_list = '';
	var role_list = '';

	for (var i = 0; i < user_qualifications.expertises.length; i++) {
		expertise_list += '<li>' + user_qualifications.expertises[i] + '</li>';
	}

	for (var i = 0; i < user_qualifications.roles.length; i++) {
		role_list += '<li>' + user_qualifications.roles[i] + '</li>';
	}	

	var panel = '<div class="panel panel-default">'
	    + '<div class="panel-heading" role="tab">'
	      + '<h4 class="panel-title">'
	        + '<input class="user_checkboxes" type="checkbox">'
	        + '<a class="collapsed" data-toggle="collapse" data-parent="#qualified_users" href="#user_' + incrementor + '_collapse"> '
	        + user_details.username
	        + '</a>'
	      + '</h4>'
	    + '</div>'
	    + '<div id="user_' + incrementor + '_collapse" class="panel-collapse collapse" role="tabpanel">'
	      + '<div class="panel-body">'
		      + '<ul>'
		      	+ '<li>' + user_details.fname + ' ' + user_details.lname + '</li>'
		      	+ '<li>' + user_details.email + '</li>'
		      	+ '<li>Expertises:'
		      		+ '<ul>'
		      		+ expertise_list
		      		+ '</ul>'
		      	+ '</li>'
		      	+ '<li>Roles:'
		      		+ '<ul>'
		      		+ role_list
		      		+ '</ul>'
		      	+ '</li>'
		      + '</ul>'
	      + '</div>'
	    + '</div>'
	+ '</div>'

	return panel;
}

function resetProjectMemberAssignmentModal () {
	$('#qualification_type_select').val('invalid');

	$('#qualification_available_group').css('display', 'none');

	$('#qualified_users').css('display', 'none');
}

function resetAssignRolesModal () {
	$('#assign_roles_modal_form').text('');
}
