function ajax4(){
    $('#createaga').submit(function(){
          
        $.post('profileaga', $('#createaga').serialize(), function(data){          
            alert("successfull create profile for an angancy");
             
        }).fail(function() {         
            alert( "Posting failed." );
             
        });
        return false; 
    });
}


