function displayAlert(message){
	var alert_html = '<div class="alert alert-success alert-dismissible fade in" role="alert">'
	  + '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'
	  + '<span aria-hidden="true">&times;</span>'
	  + '</button>'
	  + '<span>' + message + '</span>'
	+ '</div>';

	$('#alert_box').html(alert_html);
	setTimeout(function(){
		setTimeout(function(){
			$('.alert.alert-success.alert-dismissible').alert('close');
		}, 3000);
	}, 350);
}