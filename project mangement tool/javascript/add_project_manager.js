$(document).ready(function(){
	$('#qs').change(loadQualificationAvailable);
	$('#qas').change(loadUsersAndQualification);
	$('#add_project_manager_button').click(saveProjectManagers);

	$('#add_project_manager_modal').on('hidden.bs.modal', function(){
		$('#qs').val('invalid');

		$('#qsg').css('display', 'none');

		$('#aqu').css('display', 'none');
	});
});

function loadQualificationAvailable () {
	var qualification_type_selected = $("#qs option:selected").val();
	var proj_id = $('#project_name_big').attr('project_id');

	$('#qas').text('');

	if (qualification_type_selected == "All"){
		$('#qsg').slideUp();
		loadUsersAndQualification();
	} else if (qualification_type_selected != "invalid") {

		$.post("includes/get_project_qualifications.php", {qualification: qualification_type_selected,}, function(data){
			$('#qas').html('<option value="invalid">-- Please select ' + qualification_type_selected.toLowerCase() + ' --</option>');
			
			for (var i = 0; i < data.length; i++) {
				$('#qas').append('<option>' + data[i] + '</option>');
			}
		}, "json");

		$('#qtsl').text(qualification_type_selected + ':');

		$('#qsg').slideDown();
	}
}

function loadUsersAndQualification () {
	var qualification_selected = $('#qas option:selected').val();
	var qualification_type_selected = $("#qs option:selected").val();

	$.post("includes/get_all_users.php", {qualification_type: qualification_type_selected, qualification: qualification_selected}, function(user_details){
		$('#aqu').html('<label class="control-label">Users:</label>');

		for (var i = 0; i < user_details.length; i++) {
			printIndividualQualifications(user_details[i], i);
		}
		
		$('#aqu').slideDown();
	}, "json");
}

function printIndividualQualifications(user_details, incrementor){
	$.post("includes/get_individual_qualifications.php", {username: user_details.username}, function(user_qualifications){
		$('#aqu').append(generateAccordianPanel(user_details, user_qualifications, incrementor));
	}, "json");
}

function saveProjectManagers () {
	var checked_checkboxes = $('.user_checkboxes:checked');

	var pm_array = new Array();

	for (var i = 0; i < checked_checkboxes.length; i++) {
		pm_array.push($(checked_checkboxes[i]).next().text().trim());
	}

	$.post("includes/add_project_manager.php", {users: pm_array}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#add_project_manager_modal').modal('hide');
			loadProjects();
			displayAlert('The new project has been saved.');
		}
	}, "text");
}
