$(document).ready(function(){
    $('#creform').submit(function(){
          
        $.post('updatecard', $(this).serialize(), function(data){
           
            alert("successfully update card infomation");
             
        }).fail(function() {         
            alert( "Posting failed." );
             
        });
        return false; 
    });
});


