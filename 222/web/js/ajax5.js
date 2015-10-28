function ajax5(){
    var onetime = true;
    
    $('#AprofilePanel').submit(function(){
        if(onetime == true){ 
        $.post('Aprofilecenter', $('#AprofilePanel').serialize(), function(data){
            onetime = false;
            alert("successfull create profile for an angancy");
             
        }).fail(function() {
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false; 
    }
    });
}


