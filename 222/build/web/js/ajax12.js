function ajax12(){
    var onetime = true;
    $('#addroute').submit(function(){
        if(onetime == true){
        $.post('createroute', $('#addroute').serialize(), function(data){
            
            onetime = false;
            alert("successfull create the route");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false;
        }
    });
}

