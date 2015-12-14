/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var socket = null; 
var url = 'ws://localhost:8000/letschat';

var fontcols = new Object();
var username;//this user name
var usernames = [];
var usersi = 0;

var colourmap = new Object();
colourmap.red = "#ff0000";
colourmap.yellow ="#ffff00";
colourmap.blue="#0000ff";
colourmap.lime="#00ff00";
colourmap.aqua="#00ffff";
colourmap.fuschia="#ff00ff";
colourmap.maroon="#800000";
colourmap.green="#008000";
colourmap.navy="#000080";

var allofmsg;

window.onload = function(){
    doSetupSocket();
};

function doSetupSocket(){
    // Get a WebSocket - browser dependent!
    socket = ("MozWebSocket" in window ? new MozWebSocket(url) : new WebSocket(url));
    console.log("socket created");
    socket.onclose = function(msg) {
        alert("Connection closed");
    }
    socket.onmessage = handleUpdate;
}

function handleUpdate(msg){
    console.log("handle update");
    var info = JSON.parse(msg.data);
    
    var infodata = info['data'];
    
    var allchat = document.getElementById("chatlog");
    var ppl = document.getElementById("ppl");
    var rows = ppl.rows.length;
    
    while(rows > 1){
        ppl.deleteRow(rows - 1);
        rows --;
    }
    var i;
     for(i in infodata){
         var clientdata = infodata[i];
         if(clientdata['login'] == true){
             allofmsg = clientdata['allmsg'];
             loadDialog(allchat);
             var row = ppl.insertRow(ppl.rows.length);
             var cell = row.insertCell(0);
             
             var colorname = clientdata['colour'];
             var paintcolor = colourmap[colorname];
             fontcols[clientdata['uname']] = paintcolor;
             
             var tempstr = "<font style='color:" + paintcolor + "'>" + clientdata['uname'] + "</font>";
             cell.innerHTML = tempstr;
             
             if(usernames.indexOf(clientdata['uname']) == -1){
                usernames[usersi ++] = clientdata['uname'];
         }

        }
     }
}

function loadDialog(allchat){
    var dia = [];
    var diastr = "";
    
    for(var i = 0;i < allofmsg.length;i ++){
        dia = allofmsg[i].split(":");
        diastr += dia[0] + ":" + dia[1];
    }
    
    allchat.value = diastr;
}

function register(){
    username = document.getElementById('uname').value;
    
    if(usernames.indexOf(username) != -1){
        alert("username has already exist");
    }
    else{
        $('#reg').hide();
        $('#start').show();
        console.log("you are login");
        
        var data = new Object();
        data.uname = username;
        var command = new Object();
        
        command.action = "login";
        command.data = data;
        
        var stringversion = JSON.stringify(command);
        socket.send(stringversion);
    }
}

function send(){
    var send = document.getElementById("msg");
    var sendcontent = send.value;
    send.value = "";
    
    var data = new Object();
    data.msgcon = sendcontent;
    
    var command = new Object();
    command.action = "sendchat";
    command.data = data;
    
    var stringversion = JSON.stringify(command);
    socket.send(stringversion);    
}
