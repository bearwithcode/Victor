function ajax17(){
    var onetime = true;
    $('#confirmticket').submit(function(){
        if(onetime == true){
        $.post('newticket', $('#confirmticket').serialize(), function(data){
            
            onetime = false;
            alert("successfull create ticket");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}

