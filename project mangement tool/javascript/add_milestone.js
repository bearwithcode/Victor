$(document).ready(function(){
	$('#add_milestone_button').click(addMilestone);
});

function addMilestone() {
	var proj_id = $('#project_name_big').attr('project_id');
	var name = $('#milestone_name_input').val().trim();
	var date = $('#milestone_date_input').val().trim();

	$.post("includes/add_milestone.php", {project_id: proj_id, milestone_name: name, milestone_date: date}, function(data){
		if($.isNumeric(data) && data == 0){
			$('#add_milestone_modal').modal('hide');
			displayAlert('Milestone \"' + name + '\" has been successfully created.');
		}
	}, "text");
}