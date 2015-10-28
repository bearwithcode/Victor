function ajax21(){
    var onetime = true;
    $('#ww').submit(function(){
        if(onetime == true){
        $.post('wetherreport', $('#ww').serialize(), function(data){
            onetime = false;
            var wid = document.getElementById("chw").value;
            var did = wid + "dw";
            var aid = wid + "aw";
            
            var twodate = [];
            twodate = data.split(":");
            document.getElementById(did).innerHTML = twodate[0];
            document.getElementById(aid).innerHTML = twodate[1];
                       
            alert("update success");
            return;
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );  
        });
        return false;
        }
    });
}


