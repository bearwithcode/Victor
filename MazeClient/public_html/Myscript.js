/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var socket = null; 
var url = 'ws://localhost:8000/mazerunner';
var canvas,context;

var peopleup,
    peopledown,
    peopleleft,   
    peopleright;
   
peopleup = new Image();
peopleup.src = "image/up.png";
    
peopledown = new Image();
peopledown.src = "image/down.png";
    
peopleleft = new Image();
peopleleft.src = "image/left.png";  
    
peopleright = new Image();
peopleright.src = "image/right.png";

var startx = 10,
    starty = 10;//maze first point start to draw

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

var pi,
    pj;//this user positon
var facing;//this user facing
var username;//this user name
var alive = false;//this user live or unactive
var mazematrix = [];

var facedir = ["up","donw","left","right"];
var health;//the user health
var login = false;//this is for checking if user have login
var usersname = [];//user name list for all login
var usersi = 0;

var fireball = [];
fireball[0] = new Image();
fireball[0].src = "image/fire1.PNG";
    
fireball[1] = new Image();
fireball[1].src = "image/fire2.PNG";
    
fireball[2] = new Image();
fireball[2].src = "image/fire3.PNG";
    
window.onload = function(){
    canvas = document.getElementById("lookwhatIdrew");
    context = canvas.getContext("2d");
    doSetupSocket();
};

function doSetupSocket() 
{
    // Get a WebSocket - browser dependent!
    socket = ("MozWebSocket" in window ? new MozWebSocket(url) : new WebSocket(url));
    console.log("socket created");
    socket.onclose = function(msg) {
        alert("Connection closed");
    }
    socket.onmessage = handleUpdate;
}

function handleUpdate(msg)
{    
    var firei,firej;
    var firesig = false;
    var firedir;//I handle all the fire datas as some special datas
    
    console.log("handle update");
    var info = JSON.parse(msg.data);
    
    var infodata = info['data'];
    
    var i;
    var persons = document.getElementById('persons');
    var currentHealth = document.getElementById('health');
    persons.innerHTML="";
    var str = "";
    var maze;
    for(i in infodata){
        var clientdata = infodata[i];
        if(clientdata['login'] == true){//you have to login to see the maze
            var cname = clientdata['uname'];
            maze = clientdata['mazedt'];
            var colorname = clientdata['colour'];
            var paintcolor = colourmap[colorname];
            
            if(cname == username){
                login = clientdata['login'];
                alive = clientdata['alive'];
                facing = clientdata['facing'];
                pi = clientdata['pi'];
                pj = clientdata['pj'];
                if(alive == true){
                    health = clientdata['health'];
                    currentHealth.innerHTML = "<font style='color:" + paintcolor + "'>" + health + "</font> ";                    
                    if(clientdata['diemsg'] == "collision"){
                        alert("you have collision with " + clientdata['maker']);
                        currentHealth.innerHTML = ""; 
                        alive = false;
                        doquit();
                    }  
                    if(clientdata['diemsg'] == "shot"){
                        alert("you have been shot by " + clientdata['maker']);
                        currentHealth.innerHTML = ""; 
                        alive = false;
                        doquit();
                    }
                }
                               
            }

            if(clientdata['alive'] == true){//only people alive should draw in the maze
                var facing = clientdata['facing'];
                var ppi = clientdata['pi'];
                var ppj = clientdata['pj'];            
                LoadPeople(ppi,ppj,facing,paintcolor);
            }
             
            firesig = clientdata['fith'];
            //if(firesig == true)
                //alert("get firing signal");
            firei = clientdata['fi'];
            firej = clientdata['fj'];
            firedir = clientdata['firedir'];
            
            str = str + "<font style='color:" + paintcolor + "'>" + cname + "</font>, "; 
        }
        
        if(usersname.indexOf(clientdata['uname']) == -1){
            usersname[usersi ++] = clientdata['uname'];
        }
    } 
    
    if(login == true){                 
        persons.innerHTML = str;
        mazematrix = LoadMaze(maze); 
        if(firesig == true){
            //alert("get firing signal");
            drawmagicfire(firei,firej,firedir);
        }
        $("#loginarea").hide();
    }  
    
}

function doLogin()
{
    username = document.getElementById('uname').value;
    if(usersname.indexOf(username) != -1){
        alert(username + " is already exist, pleasy try another");
    }
    else{
        var startb = document.getElementById("start");
        startb.disabled = false;
    
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

function dostart(){
    var startb = document.getElementById("start");
    startb.disabled = true;
      
    $('.conbu').removeAttr("disabled");
    $('#quit').removeAttr("disabled");
         
    var command = new Object();
    command.action = "start";
    command.data = "";
    
    var stringversion = JSON.stringify(command);
    socket.send(stringversion);
}

function doquit(){
    $('.conbu').attr('disabled',"true");
    $('#quit').attr('disabled',"true");
    $('#start').removeAttr("disabled");
    
    var data = new Object();
    data.pi = pi;
    data.pj = pj;
    
    var command = new Object();
    command.action = "quit";
    command.data = data;
    
    var stringversion = JSON.stringify(command);
    socket.send(stringversion);
}

function up(){
    var command = new Object();
    var stringversion;
    var data = new Object();
    data.dir = "up";
    if(facing == "up"){       
        if(pi - 1 >= 0){//alert(azematrix[pi - 1][pj]);
            if(mazematrix[pi - 1][pj] != 1){
                command.action = "move";
                command.data = data;
                stringversion = JSON.stringify(command);
                socket.send(stringversion);
            }
        }
    }
    else{
        facing = "up";
        command.action = "changedir";
        command.data = data;
        stringversion = JSON.stringify(command);
        socket.send(stringversion);
    }
}

function down(){
    var command = new Object();
    var stringversion;
    var data = new Object();
    data.dir = "down";
    if(facing == "down"){
        if(pi + 1 <= 49){//alert(mazematrix[pi + 1][pj]);
            if(mazematrix[pi + 1][pj] != 1){
                command.action = "move";
                command.data = data;
                stringversion = JSON.stringify(command);
                socket.send(stringversion);
            }
        }
    }
    else{
        facing = "down";
        command.action = "changedir";
        command.data = data;
        stringversion = JSON.stringify(command);
        socket.send(stringversion);
    }
}

function left(){
    var command = new Object();
    var stringversion;
    var data = new Object();
    data.dir = "left";
    if(facing == "left"){
        if(pj - 1 >= 0){//alert(mazematrix[pi][pj - 1]);
            if(mazematrix[pi][pj - 1] != 1){
                command.action = "move";
                command.data = data;
                stringversion = JSON.stringify(command);
                socket.send(stringversion);
            }
        }
    }
    else{
        facing = "left";
        command.action = "changedir";
        command.data = data;
        stringversion = JSON.stringify(command);
        socket.send(stringversion);
    }
}

function right(){
    var command = new Object();
    var stringversion;
    var data = new Object();
    data.dir = "right";
    if(facing == "right"){
        if(pj + 1 <= 49){//alert(mazematrix[pi][pj + 1]);
            if(mazematrix[pi][pj + 1] != 1){
                command.action = "move";
                command.data = data;
                stringversion = JSON.stringify(command);
                socket.send(stringversion);
            }
        }
    }
    else{
        facing = "right";
        command.action = "changedir";
        command.data = data;
        stringversion = JSON.stringify(command);
        socket.send(stringversion);
    }
}

function shoot(){
    var command = new Object();
    
    command.action = "fire";
    command.data = "";//In my view this can be send as empty, because facing is already store in the server side
    stringversion = JSON.stringify(command);
    socket.send(stringversion);
}

function LoadMaze(mdatas)
{   
    var maze = [];
    
    for(var i = 0;i < mdatas.length;i++)
    {
        maze[i] = mdatas[i].split("");
    }
        
    context.fillStyle="#0000ff";
    for(var i = 0;i < maze.length;i++)//load walls
    {
        for(var j = 0;j < maze[i].length;j++)
        {
            if(maze[i][j] == 1){
                context.fillRect(startx,starty,15,15);
            }
            startx += 15;
        }
        startx = 10;
        starty += 15;
    }  
    
    startx = 10;
    starty = 10;
    context.fillStyle="#00008B";
    for(var i = 0;i < maze.length;i++){//load road
        for(var j = 0;j < maze[i].length;j++){
            if(maze[i][j] == 0){
               context.fillRect(startx,starty,15,15);
            }
            startx += 15;
        }
        startx = 10;
        starty += 15;
    }   
    startx = 10;
    starty = 10;
    return maze;
}

function LoadPeople(i,j,facing,col){       
            var px = startx + 15 * j;
            var py = starty + 15 * i;
            
            
            context.fillStyle = col;

            switch(facing){
                case 'left':{
                    context.fillRect(px,py,15,15);
                    context.drawImage(peopleleft,px,py,15,15);}
                    break;
                case 'right':{
                    context.fillRect(px,py,15,15);
                    context.drawImage(peopleright,px,py,15,15);}
                    break;
                case 'up':{
                    context.fillRect(px,py,15,15);
                    context.drawImage(peopleup,px,py,15,15);}
                    break;
                case 'down':{
                    context.fillRect(px,py,15,15);
                    context.drawImage(peopledown,px,py,15,15);}
                    break;
            }       
    }
    
    function drawmagicfire(firei,firej,firedir){
        var fx = startx + 15 * firej;
        var fy = starty + 15 * firei;
        
        if(firedir == "up"){
            fy -= 15;
            for(var i = 0;i < 3;i ++){
                if(firei - i - 1 >= 0){
                    context.drawImage(fireball[i],fx,fy,10,10);
                    fy -= 15;
                }
            }
        }
        else if(firedir == "down"){
            fy += 15;
            for(var i = 0;i < 3;i ++){
                if(firei + i + 1 < 50){
                    context.drawImage(fireball[i],fx,fy,10,10);
                    fy += 15;
                }
            }
        }
        else if(firedir == "left"){
            fx -= 15;
            for(var i = 0;i < 3;i ++){
                if(firej - i - 1 >=0){
                    context.drawImage(fireball[i],fx,fy,10,10);
                    fx -= 15;
                }
            }
        }
        else if(firedir == "right"){
            fx += 15;
            for(var i = 0;i < 3;i ++){
                if(firej + i + 1 < 50){
                    context.drawImage(fireball[i],fx,fy,10,10);
                    fx += 15;
                }
            }
        }
    }
    
    