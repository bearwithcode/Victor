$(document).ready(function() {
	$('#edit_profile_modal').on('show.bs.modal', getProfileDetails);
	$('#save_edit_profile_button').click(saveProfileDetails);
});

function getProfileDetails () {
	$.post("includes/get_profile.php", function(data){
		$('#current_username').text(data.username);
		$('#current_staff_id').text(data.staffID);
		$('#current_role').text(data.userrole);
		$('#current_first_name').val(data.fname);
		$('#current_last_name').val(data.lname);
		$('#current_email').val(data.email);
	}, "json");
}

function saveProfileDetails () {
	var c_fname = $('#current_first_name').val();
	var c_lname = $('#current_last_name').val();
	var c_email = $('#current_email').val();

	$.post("includes/save_profile.php", {firstname: c_fname, lastname: c_lname, email: c_email}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#edit_profile_modal').modal('hide');
			displayAlert('Changes to profile have been saved.');
		}
	}, "text");
}
