function ajax18(){
    var onetime = true;
    $('#confirmDticket').submit(function(){
        if(onetime == true){
        $.post('deletebooking', $('#confirmDticket').serialize(), function(data){
            alert("successfull delete booking");
            var thisrow = document.getElementById("dtkid");
                document.getElementById("listbookingd").removeChild(thisrow);
            onetime = false;
           
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


