function ajax15(){
    var onetime = true;
    $('#addschedule').submit(function(){
        if(onetime == true){
        $.post('newschedule', $('#addschedule').serialize(), function(data){
            
            onetime = false;
            alert("successfull add a new schedule");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


