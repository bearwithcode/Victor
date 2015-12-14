$(document).ready(function(){
	$('#change_password_modal').on('hidden.bs.modal', resetPasswordModal);
	$('#save_password_button').click(validatePassword);
});

function validatePassword () {
	var current_pw = $('#current_password').val().trim();
	var new_pw = $('#new_password').val().trim();
	var new_confirm_pw = $('#new_confirm_password').val().trim();

	if (new_pw != new_confirm_pw) {
		//display error message
	} else{
		$.post("includes/change_password.php", {current_password: current_pw, new_password: new_pw}, function(data){
			if($.isNumeric(data) && data == 0){
				$('#change_password_modal').modal('hide');
				displayAlert('The new password has been saved.');
			}
		}, "text");
	}
}

function resetPasswordModal () {
	$('#current_password').val('');
	$('#new_password').val('');
	$('#new_confirm_password').val('');
}