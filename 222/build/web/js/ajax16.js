function ajax16(){
    var onetime = true;
    $('#delschform').submit(function(){
        if(onetime == true){
        $.post('delschedule', $('#delschform').serialize(), function(data){
             alert("successfull delete schedule");
             onetime = false;
            var rowid = document.getElementById("delschid").value;
            var rowidc = rowid + "dch";
                var thisrow = document.getElementById(rowidc);
                document.getElementById("scheduleforD").removeChild(thisrow);
            
           
            return;
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


