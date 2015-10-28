/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    var indexdiv = 0;
    
    $('#add').on("click",function(e){
        $('#Mymovie tr:last').after('<tr></tr>');
        $('#Mymovie tr:last').append('<td></td><td></td>');
                      
        $('#Mymovie tr:last').children().each(function(i,n){
            if(i == 0)
            {
                $(n).append("<div></div>");
                $(n).children().addClass('targets');
                //$(n).children().attr('name','pics[]');
                              
                $(n).children().attr('id','target' + indexdiv);
                var newele = document.getElementById('target' + indexdiv);
                newele.addEventListener("dragover",FileDragover,false);
                newele.addEventListener("drop",FileDrop,false);
                
                indexdiv ++;
            }
            else if(i == 1){                
                $(n).append("<textarea rows='7' cols='20'></textarea>");
                $(n).children().attr('name','comms[]');
            }            
        });
    });
});

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