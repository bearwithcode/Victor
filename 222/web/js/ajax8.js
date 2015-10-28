function ajax8(){
    var onetime = true;
    $('#conch').submit(function(){
        if(onetime == true){ 
        $.post('changeInventory', $('#conch').serialize(), function(data){  
                var thisid = document.getElementById("chitem").value;
                var newcost =  document.getElementById("ccost").value;
                var newavail = document.getElementById("cavail").value;
                
                var thiscost = thisid + "c";
                var thisavail = thisid + "a";
                document.getElementById(thiscost).innerHTML = newcost;
                document.getElementById(thisavail).innerHTML = newavail;
                
                alert("change successfully");
                onetime = false;
                return;
    
        }).fail(function() {  
            onetime = false;
            alert( "delete failed." );
             
        });
        return false; 
        }
    });
}


