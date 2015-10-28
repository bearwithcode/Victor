/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var indexdiv = 0;
function doAdd(){
    var tb = document.getElementById('Myshow');
    var r = tb.insertRow();
    var c1 = r.insertCell();
    var c2 = r.insertCell();
    
    c1.innerHTML = "<div class = 'targets' id = '" + 'target' + indexdiv + "'></div>";
    
    var newdev = document.getElementById('target' + indexdiv);
    newdev.addEventListener("dragover",FileDragover,false);
    newdev.addEventListener("drop",FileDrop,false);
    
    c2.innerHTML = "<textarea rows='7' cols='20' name = 'comms[]'></textarea>"
    indexdiv ++;
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
        evt.target.innerHTML += "<input visibility: hidden name = 'pics[]' value = '" + e.target.result +"'/>";
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

function doaddp(){
    var showtime = document.getElementById('stime');
    var date = document.getElementById('d');
    var performances = document.getElementById('Per');
    
    var sv = showtime.value;
    var dv = date.value;
    
    var start = document.getElementById('sd');
    var end = document.getElementById('ed');
    
    var temps = start.value.replace(/-/g,"/");
    var tempe = end.value.replace(/-/g,"/");
    var tempd = dv.replace(/-/g,"/");
    
    var ds = new Date(Date.parse(temps));
    var de = new Date(Date.parse(tempe));
    var dd = new Date(Date.parse(tempd));
    
    if(dd >= ds && dd <= de){
        performances.value += dv + ','+ sv +';\n'
    }
    else{
        alert('the date should be between start and end');
    }  
}




