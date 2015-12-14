$(document).ready(function(){
	$('#project_table_my_tasks').on("click", "tr", displayTask);

	$('#project_table_all_tasks').on("click", "tr", displayTask);
});

function displayTask () {
	var proj_id = $('#project_name_big').attr('project_id');
	var task_id = $(this).attr('task-id');

	displayTaskDetails(task_id);

	$('#project_tasks').addClass('hidden');
	$('#task_overview').removeClass('hidden');

	$.post("includes/get_comments.php", {project_id: proj_id, task_id: task_id}, function(data){
		console.log(data.length);
		console.log(data);
		$('#comment_button_text').html('Comments <span class="badge">' + data.length + '</span>');
    }, "json");
}

function displayTaskDetails (taskid) {
	var proj_id = $('#project_name_big').attr('project_id');

	//get the tasks
	$.post("includes/request_tasks.php", {task_id: taskid, project_id: proj_id}, function(data){
		var task_html = "";
		
		task_html += "<tr>";
		task_html += "<td>Task Name:</td>";
		task_html += "<td>" + data[0].taskName + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Task ID:</td>";
		task_html += "<td id=\"current_task_id\">" + data[0].taskID + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Status:</td>";
		task_html += "<td>" + data[0].taskStatus + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Task Details:</td>";
		task_html += "<td>" + data[0].taskDetails + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Task Priority:</td>";
		task_html += "<td>" + data[0].taskPriority + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Optimistic Time (Days):</td>";
		task_html += "<td>" + data[0].optimisticdays + "</td>";
		task_html += "</tr>";

		task_html += "<tr>";
		task_html += "<td>Pessimistic Time (Days):</td>";
		task_html += "<td>" + data[0].pessimisticdays + "</td>";
		task_html += "</tr>";

		$('#task_table_details').html(task_html);

		$('#task_overview_name').text(data[0].taskName);
		$('#days_required_big').text(data[0].daysrequired);
		$('#percent_complete_big_task').text(data[0].percentcomplete + "%");
		$('#percent_complete_task').attr('style', 'width: ' + data[0].percentcomplete + '%;');
	}, "json");
}
