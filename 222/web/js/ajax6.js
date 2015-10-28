function ajax6(){
    var onetime = true;
    $('#customerprofile').submit(function(){
        if(onetime == true){
        $.post('Cusprofilecenter', $('#customerprofile').serialize(), function(data){       
            onetime = false;
                alert("successfull modify profile for an customer");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false;
        }
    });
}


