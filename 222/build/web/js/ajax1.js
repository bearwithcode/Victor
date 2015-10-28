$(document).ready(function(){
    $('#customerform').submit(function(){
          
        $.post('updatepersonal', $(this).serialize(), function(data){
           
            alert("successfully update personal infomation");
             
        }).fail(function() {         
            alert( "Posting failed." );
             
        });
        return false; 
    });
});


