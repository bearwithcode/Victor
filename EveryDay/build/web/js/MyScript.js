window.onload = function () {
    $('.datepicker').datepicker({
    });
    
    var newpic= document.getElementById('targets');
    newpic.addEventListener("dragover",FileDragover,false);
    newpic.addEventListener("drop",FileDrop,false);
};

function getdiary(date) {
    $.get('getDiaryCon',{
        time:date
    },function(response){
        $('#diarycontent').html(response);
    }).fail(function (){
        alert( "Getting failed." );
    });
}

function checkfeild(){
    var newcontent = $('#newcontent').val();
    var time = $('#when').val();
    if(newcontent == "" || time == ""){
        alert("none of these input should be empty");
        return false;
    }
    else{
        return true;
    }
}

function cleanimg(){
    var dropdiv = document.getElementById('targets');
    dropdiv.innerHTML = "";
}

function handleFileSelect(afile,evt){
    var reader = new FileReader();
    var filetypes = /^(image\/jpeg|image\/png|image\/gif)$/;
    
    if(!filetypes.test(afile.type)){
        alert("please select file jpeg png or gif");
        return;
    }
    
    reader.onload = function(e){
        evt.target.innerHTML += "<img src = '" + e.target.result + "' style='float:left' width ='100'/>";
        evt.target.innerHTML += "<input visibility: hidden name = 'pic' value = '" + e.target.result +"'/>";
    }
    reader.readAsDataURL(afile);
}

function FileDragover(evt){
    evt.preventDefault();
}

function FileDrop(evt){  
    evt.preventDefault();

    var files = evt.dataTransfer.files;
    var num = files.length;
    var i = 0;
    for(i = 0;i < num;i++){
        var afile = files[i];
        handleFileSelect(afile,evt);
    }           
}


