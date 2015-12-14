$(document).ready(function(){
	$('#sign_up_button').click(executeSignUp);
});

function executeSignUp () {
	var first_name = $('#inputFirstName').val().trim();
	var last_name = $('#inputLastName').val().trim();
	var user_name = $('#inputUsername').val().trim();
	var staff_id = $('#inputStaffId').val().trim();
	var user_email = $('#inputEmail').val().trim();
	var user_password = $('#inputPassword').val().trim();
	var user_confirm_password = $('#inputConfirmPassword').val().trim();
	var is_okay = true;

	if (first_name == "" || last_name == "" || user_name == "" || staff_id == "" || user_email == "" || user_password == "") {
		is_okay = false;
	}

	if (user_password != user_confirm_password) {
		//display error message for password mismatch
		is_okay = false;
	}

	if (is_okay) {
		$.post("includes/register.php",
			{
				firstname: first_name,
				lastname: last_name,
				username: user_name,
				staffid: staff_id,
				email: user_email,
				password: user_password
			},
			function(data){
				if ($.isNumeric(data)) {
					if (data == 0) {
						window.location = "dashboard.php";
					} else if (data == -1) {
						//display error message that username already exists
					}
				} else{
					console.log(data);
				}
			},
			"text"
		);
	}
}