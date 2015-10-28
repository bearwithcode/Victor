function ajax9(){
    var onetime = true;
    $('#confirmd').submit(function(){
        if(onetime == true){ 
        $.post('deleteInventory', $('#confirmd').serialize(), function(data){    
                var rowid = document.getElementById("ditem").value;
                var thisrow = document.getElementById(rowid);
                document.getElementById("listallin").removeChild(thisrow);
                alert("delete successfully");
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


