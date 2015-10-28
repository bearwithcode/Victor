function ajax19(){
    var onetime = true;
    $('#chosenseat').submit(function(){
        if(onetime == true){
        $.post('switchseat', $('#chosenseat').serialize(), function(data){
            var tkid = document.getElementById("ticketid").value;
            var tknum = tkid + "n";
            
            document.getElementById(tknum).innerHTML = data
            
            onetime = false;
            alert("successfull switch the seat");
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


