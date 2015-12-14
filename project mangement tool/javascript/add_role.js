$(document).ready(function(){
	var counter_var = 0;
	$('#add_role_button').click(function(){
		addRoleTextBox(counter_var++);
	});

	$('#create_roles_modal').on('show.bs.modal', displayCurrentRoles);

	$('#create_roles_modal').on('hidden.bs.modal', function(){
		counter_var = 0;
		$('#role_text_boxes').text(''); //empty div of all content
		for (var i = 0; i < 3; i++) {
			$('#role_list_' + i).text('');
		}
	});

	$('#create_roles_button').click(saveRolesToDatabase);
});

function displayCurrentRoles(){
	var proj_id = $('#project_name_big').attr('project_id');
	$.post("includes/get_roles.php", {project_id: proj_id.toString()}, function(data){
		var counter = 0;
		while (counter < data.length) {
			$('#role_list_' + (counter % 3)).append('<li class="form-control-static">' + data[counter] + '</li>');
			counter++;
		}

	}, "json");
}

function addRoleTextBox (current_count) {
	var text_box_code = '<div class="form-group" style="display: none;">'
              + '<label for="role_' + current_count + '" class="control-label">Role ' + (current_count + 1) + '</label>'
              + '<input type="text" class="form-control role_inputs" id="role_' + current_count + '">'
            + '</div>';

	$('#role_text_boxes').append(text_box_code);
	$('#role_' + current_count).parent().slideDown();
}

function saveRolesToDatabase(){
	var number_of_roles = $('.role_inputs').length;
	
	//check for blank roles also!!!!

	if (number_of_roles > 0) {
		var role_array = new Array(number_of_roles);

		for (var i = 0; i < number_of_roles; i++) {
			role_array[i] = $('#role_' + i).val();
		} 

		var proj_id = $('#project_name_big').attr('project_id');

		$.post("includes/save_roles.php", {project_id: proj_id.toString(), data: role_array}, function(data){
			if($.isNumeric(data) && data == 0){
				$('#create_roles_modal').modal('hide');
				displayAlert('All roles have been saved.');
			}
		}, "text");

		//console.log(role_array);
	} else{
		//display error message
	}
}