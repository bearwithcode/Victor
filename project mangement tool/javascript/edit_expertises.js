$(document).ready(function(){
	var counter_var = 0;
	$('#add_expertise_button').click(function(){
		addExpertiseTextBox(counter_var++);
	});

	$('#edit_expertises_modal').on('show.bs.modal', displayCurrentExpertises);

	$('#edit_expertises_modal').on('hidden.bs.modal', function(){
		counter_var = 0;
		$('#expertise_text_boxes').text(''); //empty div of all content
		for (var i = 0; i < 3; i++) {
			$('#expertise_list_' + i).text('');
		};
		
	});

	$('#create_expertises_button').click(saveExpertisesToDatabase);
});

function displayCurrentExpertises(){
	$.post("includes/get_expertises.php", function(data){
		var counter = 0;
		while (counter < data.length) {
			$('#expertise_list_' + (counter % 3)).append('<li class="form-control-static">' + data[counter] + '</li>');
			counter++;
		}

	}, "json");
}

function addExpertiseTextBox (current_count) {
	var text_box_code = '<div class="form-group" style="display: none;">'
              + '<label for="expertise_' + current_count + '" class="control-label">Expertise ' + (current_count + 1) + '</label>'
              + '<input type="text" class="form-control expertise_inputs" id="expertise_' + current_count + '">'
            + '</div>';

	$('#expertise_text_boxes').append(text_box_code);
	$('#expertise_' + current_count).parent().slideDown();
}

function saveExpertisesToDatabase(){
	var number_of_expertises = $('.expertise_inputs').length;
	
	//check for blank expertises also!!!!

	if (number_of_expertises > 0) {
		var expertise_array = new Array(number_of_expertises);

		for (var i = 0; i < number_of_expertises; i++) {
			expertise_array[i] = $('#expertise_' + i).val();
		} 

		var proj_id = $('#project_name_big').attr('project_id');

		$.post("includes/save_expertises.php", {data: expertise_array}, function(data){
			if($.isNumeric(data) && data == 0){
				$('#edit_expertises_modal').modal('hide');
				displayAlert('All expertises have been saved.');
			}
		}, "text");

		//console.log(expertise_array);
	} else{
		//display error message
	}
}