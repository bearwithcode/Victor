$(document).ready(function(){
	loadProjects();
	loadActiveProjects();
	loadProjectArchive();
	loadAllUsers();
});

function loadProjects () {
	$.post("includes/request_projects.php", {dashboard: "true"}, function(data){
		$('#no_of_projects_big').text(data.length);
		var no_of_tasks = 0;
		var project_html = "";

		for (var i = 0; i < data.length; i++) {
			project_html += "<tr class=\"project_row\" project-id=\"" + data[i].projectID + "\">";
			project_html += "<td>" + data[i].projectID + "</td>";
			project_html += "<td>" + data[i].name + "</td>";
			project_html += "<td>" + data[i].status + "</td>";
			project_html += "</tr>";

			$.ajax({
		        method: "POST",
		        url: "includes/request_my_tasks.php",
		        data: {project_id: data[i].projectID},
		        success: function(data){
		            no_of_tasks += data.length;
		        },
		        dataType: "json",
		        async: false //not recommended but no choice
		    });
		}

		$('#no_of_tasks_big').text(no_of_tasks);
		$('#project_table').html(project_html);
	}, "json");
}


function loadActiveProjects () {
	$.post("includes/request_active_projects.php", function(data){
		var project_html = "";
		for (var i = 0; i < data.length; i++) {
			project_html += "<tr class=\"project_row\" project-id=\"" + data[i].projectID + "\">";
			project_html += "<td>" + data[i].projectID + "</td>";
			project_html += "<td>" + data[i].name + "</td>";
			project_html += "<td>" + data[i].status + "</td>";
			project_html += "</tr>";
		}
		$('#all_active_project_table').html(project_html);
	}, "json");
}

function loadProjectArchive () {
	$.post("includes/load_project_archive.php", function(data){
		var project_html = "";
		var completed_projects = 0;
		var cancelled_projects = 0;

		for (var i = 0; i < data.length; i++) {
			project_html += "<tr>";
			project_html += "<td>" + data[i].projectID + "</td>";
			project_html += "<td>" + data[i].name + "</td>";
			project_html += "<td>" + data[i].status + "</td>";
			project_html += "</tr>";
			if (data[i].status == "Complete") {
				completed_projects++;
			} else if(data[i].status == "Cancelled"){
				cancelled_projects++;
			}

		}
		$('#project_archive_table').html(project_html);
		$('#number_of_completed_projects').text(completed_projects);
		$('#number_of_cancelled_projects').text(cancelled_projects);

	}, "json");
}

function loadAllUsers () {
	$.post("includes/get_all_users.php", {qualification_type: "All", sort_role: "true"}, function(data){
		var users_html = "";
		var project_members = 0;
		var project_managers = 0;
		var administrators = 0;

		for (var i = 0; i < data.length; i++) {
			users_html += "<tr>";
			users_html += "<td>" + data[i].fname + "</td>";
			users_html += "<td>" + data[i].lname + "</td>";
			users_html += "<td>" + data[i].username + "</td>";
			users_html += "<td>" + data[i].staffID + "</td>";
			users_html += "<td>" + data[i].email + "</td>";
			users_html += "<td>" + data[i].userrole + "</td>";
			users_html += "</tr>";

			switch (data[i].userrole){
				case "Project Member":
					project_members++;
					break;
				case "Project Manager":
					project_managers++;
					break;
				case "Administrator":
					administrators++;
					break;
			}
		}
		$('#all_users_table').html(users_html);
		$('#total_number_of_users').text(data.length);
		$('#number_of_project_members').text(project_members);
		$('#number_of_project_managers').text(project_managers);
		$('#number_of_administrators').text(administrators);
	}, "json");
}
