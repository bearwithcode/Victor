function ajax20(){
    var onetime = true;
    $('#payticket').submit(function(){
        if(onetime == true){
        $.post('Paybooking', $('#payticket').serialize(), function(data){
            onetime = false;
            var tkid = document.getElementById("paytkid").value;
            var tknum = tkid + "p";
            
            if(parseInt(data) == 1){
                document.getElementById(tknum).innerHTML = true;
                alert("successfull pay for the ticket");
            }
            else{
                alert("Payment reject,please check the credit card is card");
            }
            
            
             
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


