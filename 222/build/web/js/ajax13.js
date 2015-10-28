function ajax13(){
    var onetime = true;
    $('#newfleet').submit(function(){
        if(onetime == true){
        $.post('newfleet', $('#newfleet').serialize(), function(data){
            
            onetime = false;
            alert("successfull create the fleet");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false;
        }
    });
}


