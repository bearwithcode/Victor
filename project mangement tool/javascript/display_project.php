<?php 
session_start();
header("Content-type: application/javascript");
?>

$('#project_table').on("click", "tr", function(){
	var proj_id = $(this).attr('project-id');

	displayProjectDetails(proj_id);
	
	loadTasks(proj_id);

	$('.dashboard_side_nav').addClass('hidden');
	$('.project_side_nav').removeClass('hidden');
	$('#overview').addClass('hidden');
	$('#project').removeClass('hidden');
    $('.project_side_nav > li[nav-index="1"] > a').trigger('click');
});

function loadTasks (proj_id) {
	//get all tasks associated with this project
	$.post("includes/request_tasks.php", {project_id: proj_id.toString()}, function(data){
		var tasks_html = "";
		var project_complete_percentage = 0;

		for (var i = 0; i < data.length; i++) {
			tasks_html += "<tr class=\"task_row\" task-id=\"" + data[i].taskID + "\">";
			tasks_html += "<td>" + data[i].taskID + "</td>";
			tasks_html += "<td>" + data[i].taskName + "</td>";
			tasks_html += "<td>" + data[i].taskStatus + "</td>";
			tasks_html += "<td>" + data[i].taskPriority + "</td>";
			tasks_html += "<td>" + data[i].taskDetails + "</td>";
			tasks_html += "</tr>";
			project_complete_percentage += parseInt(data[i].percentcomplete);
		}

		var length = parseInt(data.length);

		if (length != 0) {
			project_complete_percentage = Math.floor(project_complete_percentage / length);
		}

		$('#percent_complete_big').text(project_complete_percentage + '%');
		$('#percent_complete_progress').css('width', project_complete_percentage + '%');
		$('#project_table_all_tasks').html(tasks_html);
		$('#all_tasks_remaining_big').text(data.length);
		$('#tasks_remaining_badge').text(data.length);
	}, "json");

	$.post("includes/request_my_tasks.php", {project_id: proj_id.toString()}, function(data){
		var tasks_html = "";

		for (var i = 0; i < data.length; i++) {
			tasks_html += "<tr class=\"task_row\" task-id=\"" + data[i].taskID + "\">";
			tasks_html += "<td>" + data[i].taskID + "</td>";
			tasks_html += "<td>" + data[i].taskName + "</td>";
			tasks_html += "<td>" + data[i].taskStatus + "</td>";
			tasks_html += "<td>" + data[i].taskPriority + "</td>";
			tasks_html += "<td>" + data[i].taskDetails + "</td>";
			tasks_html += "</tr>";
		}
		
		$('#project_table_my_tasks').html(tasks_html);
		$('#my_tasks_remaining_big').text(data.length);
	}, "json");

	$.post("includes/count_people.php", {project_id: proj_id.toString()}, function(data){
		if ($.isNumeric(data)) {
			$('#people_in_project_big').text(data);
		} else{
			$('#people_in_project_big').text("0");
		}
	}, "text");
}

function displayProjectDetails (proj_id) {
	//get the projects
	$.post("includes/request_projects.php", {project_id: proj_id.toString()}, function(data){
		$('#project_name_big').text(data[0].name);
		$('#project_name_big').attr("project_id", proj_id.toString());
		var role = <?php echo('"'.$_SESSION['role'].'"') ?>;

		if (role == "Administrator") {
			$('#project_management_buttons').removeClass('hidden');
			$('#create_task_div').removeClass('hidden');
			$('#task_manipulation_div').removeClass('hidden');	
		} else {
			$.post("includes/get_project_managers.php", {project_id: proj_id.toString()}, function(data){
				if (data == "Is Manager") {
					$('#project_management_buttons').removeClass('hidden');
					$('#create_task_div').removeClass('hidden');
					$('#task_manipulation_div').removeClass('hidden');
				} else{
					$('#project_management_buttons').addClass('hidden');
					$('#create_task_div').addClass('hidden');
					$('#task_manipulation_div').addClass('hidden');
				}
			}, "text");
		}

		var project_html = "";
		
		project_html += "<tr>";
		project_html += "<td>Project Status:</td>";
		project_html += "<td>" + data[0].status + "</td>";
		project_html += "</tr>";

		project_html += "<tr>";
		project_html += "<td>Project Description:</td>";
		project_html += "<td>" + data[0].description + "</td>";
		project_html += "</tr>";

		project_html += "<tr>";
		project_html += "<td>Location:</td>";
		project_html += "<td>" + data[0].location + "</td>";
		project_html += "</tr>";

		project_html += "<tr>";
		project_html += "<td>Start Date:</td>";
		project_html += "<td id=\"project_start_date\">" + data[0].startdate + "</td>";
		project_html += "</tr>";

		project_html += "<tr>";
		project_html += "<td>End Date:</td>";
		project_html += "<td>" + data[0].enddate + "</td>";
		project_html += "</tr>";

		$('#project_table_details').html(project_html);

		var end_date = moment(data[0].enddate, "DD-MM-YYYY");
		var current_date = moment();
		var days_to_completion = parseInt(end_date.diff(current_date, 'days'));

		if (days_to_completion < 0) {
			days_to_completion = 0;
		}

		$('#days_to_completion_big').text(days_to_completion);
		$('#percent_complete_big').text(data[0].percentcomplete + "%");
		$('#percent_complete_progress').attr('style', 'width: ' + data[0].percentcomplete + '%;');
	}, "json");
}
