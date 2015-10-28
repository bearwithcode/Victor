function adminusecase(option){
    switch(option){
        case 0:
            $('#sec1,#sec2').hide();
            $('#home,#sec0').show();
            $('#m1').removeClass('list-group-item-info');
            break;
        case 1:
            $('#home,#sec0,#sec2').hide();
            $('#sec1').show();
            $('#m1').addClass('list-group-item-info');
            $('#m2').removeClass('list-group-item-info');
            break;
        case 2:
            $('#home,#sec0,#sec1').hide();
            $('#sec2').show();
            $('#m2').addClass('list-group-item-info');
            $('#m1').removeClass('list-group-item-info');
            break;
            break;
    }
}


function getschlistforret(){
    $.get('wetherreport'
       , function(response) {
            $("#listscheduleforRet").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function bmusecase(option){
    switch(option){
        case 0:
            $('#sec1').hide();
            $('#home,#sec0').show();
            $('#m1').removeClass('list-group-item-info');
            break;
        case 1:
            $('#home,#sec0').hide();
            $('#sec1').show();
            $('#m1').addClass('list-group-item-info');
            getschlistforret();
            break;
    }
}

function flmusecase(option){
    switch(option){
        case 0:
            $('#sec1,#sec2,#sec3,#sec4,#sec5,#sec6').hide();
            $('#home,#sec0').show();
            $('#m1,#m2,#m3,#m4,#m5,#m6').removeClass('list-group-item-info');
            break;
        case 1:
            $('#home,#sec0,#sec2,#sec3,#sec4,#sec5,#sec6').hide();
            $('#sec1').show();
            $('#m2,#m3,#m4,#m5,#m6').removeClass('list-group-item-info');
            $('#m1').addClass('list-group-item-info');
            getplanelistforair();
            break;
        case 2:
            $('#home,#sec0,#sec1,#sec3,#sec4,#sec5,#sec6').hide();
            $('#sec2').show();
            $('#m1,#m3,#m4,#m5,#m6').removeClass('list-group-item-info');
            $('#m2').addClass('list-group-item-info');
            choosefromairport();
            break;
        case 3:
            $('#home,#sec0,#sec1,#sec2,#sec4,#sec5,#sec6').hide();
            $('#sec3').show();
            $('#m1,#m2,#m4,#m5,#m6').removeClass('list-group-item-info');
            $('#m3').addClass('list-group-item-info');
            airportlistforfleet();
            break;
        case 4:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec5,#sec6').hide();
            $('#sec4').show();
            $('#m1,#m2,#m3,#m5,#m6').removeClass('list-group-item-info');
            $('#m4').addClass('list-group-item-info');
            getfleetlist();
            break;
        case 5:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec4,#sec6').hide();
            $('#sec5').show();
            $('#m1,#m2,#m3,#m4,#m6').removeClass('list-group-item-info');
            $('#m5').addClass('list-group-item-info');
            break;
        case 6:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec4,#sec5').hide();
            $('#sec6').show();
            $('#m1,#m2,#m3,#m4,#m5').removeClass('list-group-item-info');
            $('#m6').addClass('list-group-item-info');
            listroute();
            break;
       
    }
}

function confirmdelete(dschid){
    document.getElementById("delschid").value = dschid;
}

function getseatid(sid){
    document.getElementById("seatid").value = sid;
}


function listroute(){
    $.get('delschedule'
       , function(response) {
            $("#scheduleforD").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function viewplane(fleetid){
    var onetime = true;
    if(onetime == true){
        $.get('newplane', {      
        fleetid : fleetid
       }, function(response) {
            $("#cuplanelist").html(response);
            onetime = false;
    }).fail(function(){
                alert( "Getting failed." );
            });
    }
}

function addthisplane(pid){
    document.getElementById("Chopid").value = pid;
}

function renderroute(rid){  
    var sourceA = document.getElementById(rid + "s").innerHTML;
    
    $.get('planelistforsch', {
        sourceA : sourceA
       }, function(response) {
            document.getElementById("Choroute").value = rid;
            $("#takeoffplane").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function getrouteforch(){
    $.get('newschedule',
                function(response){
                    $('#routelistofsch').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function renderfid(fid){
    document.getElementById("choosing3").value = fid
}

function getfleetlist(){
    $.get('newfleet',
                function(response){
                    $('#fleetlist').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function airportlistforfleet(){
    $.get('ChooseAirportForfleet',
                function(response){
                    $('#airportlistF').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function choosefromairport(){
    $.get('ChooseAirportForRoute',
                function(response){
                    $('#airportlistR').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function getiata(IATA){
    document.getElementById("choosing").value = IATA;
}

function getiataII(IATA){
    document.getElementById("choosing2").value = IATA;
}

function chooseairport(option){
    var sou = document.getElementById("source");
    var des = document.getElementById("destination");
    var iata = document.getElementById("choosing").value
    
    switch(option){
        case 1:
            sou.value = iata;
            break;
        case 2:
            des.value = iata;
            break;
    }
}

function confirmremoveair(iataford){
    document.getElementById("dairportiata").value = iataford;
}

function getplanelistforair(){
    $.get('newAir',
                function(response){
                    $('#planelist').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function smusecase(option){
    switch(option){
        case 0:
            $('#sec1,#sec2').hide();
            $('#home,#sec0').show();
            $('#m1,#m2').removeClass('list-group-item-info');
            break;
        case 1:
            $('#home,#sec0,#sec2').hide();
            $('#sec1').show();
            $('#m1').addClass('list-group-item-info');
            $('#m2').removeClass('list-group-item-info');
            getinventorylist1();
            break;
        case 2:
            $('#home,#sec0,#sec1').hide();
            $('#sec2').show();
            $('#m2').addClass('list-group-item-info');
            $('#m1').removeClass('list-group-item-info');    
            getinventorylist2();
            break;
        
    }
}

function getinventorylist1(){
    $.get('GetIvlist',
                function(response){
                    $('#listallin').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function getinventorylist2(){
    $.get('GetIvlistII',
                function(response){
                    $('#listallinII').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
}

function fmusecase(option){
    switch(option){
        case 0:
            $('#sec1,#sec2,#sec3').hide();
            $('#home,#sec0').show();
            $('#m1,#m2,#m3').removeClass('list-group-item-info');
            break;
        case 1:
            $('#home,#sec0,#sec2,#sec3').hide();
            $('#sec1').show();
            $('#m1').addClass('list-group-item-info');
            $('#m2,#m3').removeClass('list-group-item-info');
            break;
        case 2:
            $('#home,#sec0,#sec1,#sec3').hide();
            $('#sec2').show();
            $('#m2').addClass('list-group-item-info');
            $('#m1,#m3').removeClass('list-group-item-info');
            
            $.get('profileaga',
                function(response){
                    $('#sec2').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
            break;
        case 3:
            $('#home,#sec0,#sec1,#sec2').hide();
            $('#sec3').show();
            $('#m3').addClass('list-group-item-info');
            $('#m1,#m2').removeClass('list-group-item-info');
            
            $.get('profilecus',
                function(response){
                    $('#sec3').html(response);
                }
            ).fail(function(){
                alert( "Getting failed." );
            });
            break;
    }
}

function confirmremove(itemID){
    document.getElementById("ditem").value = itemID;
}

function changeItem(itemID){
    var costid = itemID + "c";
    var availid = itemID + "a";
    
    document.getElementById("chitem").value = itemID;
    document.getElementById("ccost").value = document.getElementById(costid).innerHTML;
    var selectval = document.getElementById(availid).innerHTML;
    $("#cavail option[value='" + selectval  + "']").attr("selected","selected");
}

function changeAprofile(AgID){
    var onetime = true;
    if(onetime == true){
        $.get('Aprofilecenter', {
            AgentID : AgID
           }, function(response) {
                $('#AprofilePanel').html(response);
        }).fail(function(){
            alert( "Getting failed." );
        });
        onetime = false;
    }
}

function changeCprofile(cuID){
    var onetime = true;
    if(onetime == true){
        $.get('Cusprofilecenter', {
            CusID : cuID
           }, function(response) {
                $('#CprofilePanel').html(response);
        }).fail(function(){
            alert( "Getting failed." );
        });
        onetime = false;
    }
}

function confirmdeltick(tkid){
    document.getElementById("dtkid").value = tkid;
}

function listbookingfordel(){
    var onetime = true;
    if(onetime == true){
        $.get('deletebooking', {
           }, function(response) {
                $('#listbookingd').html(response);
        }).fail(function(){
            alert( "Getting failed." );
        });
        onetime = false;
    }
}

function fillforticket(schid){
    document.getElementById("schid").value = schid;
    $.get('newticket', {
        schid: schid
       }, function(response) {
            $("#choosingseat").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function search(){
    var sd = document.getElementById("startdate").value;
    var ed = document.getElementById("enddate").value;
    
    $.get('searchschedule', {
        start : sd,
        end : ed
       }, function(response) {
            $("#listschduleforbooking").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function listseatforch(){
    $.get('changeseat', {       
       }, function(response) {
            $("#listbookingCS").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}



function changeseat(tkid){
    document.getElementById("ticketid").value = tkid;
    
    $.get('switchseat', {
        tkid : tkid
       }, function(response) {
            $("#changetoempty").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function getpaidlist(){
    $.get('Paybooking', {       
       }, function(response) {
            $("#listbookingP").html(response);
    }).fail(function(){
                alert( "Getting failed." );
            });
}

function cususecase(option){
    switch(option){
        case 0:
            $('#sec1,#sec2,#sec3,#sec4,#sec5,#sec6,#sec7').hide();
            $('#m1,#m2,#m3,#m4,#m5,#m6,#m7').removeClass('list-group-item-info');
            $('#home,#sec0').show();
            break;
        case 1:
            $('#home,#sec0,#sec2,#sec3,#sec4,#sec5,#sec6,#sec7').hide();
            $('#m1').addClass('list-group-item-info');
            $('#m2,#m3,#m4,#m5,#m6,#m7').removeClass('list-group-item-info');
            $('#sec1').show();
            listseatforch();
            break;
        case 2:
            $('#home,#sec0,#sec1,#sec3,#sec4,#sec5,#sec6,#sec7').hide();
            $('#m2').addClass('list-group-item-info');
            $('#m1,#m3,#m4,#m5,#m6,#m7').removeClass('list-group-item-info');
            $('#sec2').show();
            break;
        case 3:
            $('#home,#sec0,#sec1,#sec2,#sec4,#sec5,#sec6,#sec7').hide();
            $('#m3').addClass('list-group-item-info');
            $('#m1,#m2,#m4,#m5,#m6,#m7').removeClass('list-group-item-info');
            $('#sec3').show();
            getpaidlist();
            break;       
        case 5:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec4,#sec6,#sec7').hide();
            $('#m5').addClass('list-group-item-info');
            $('#m1,#m2,#m3,#m4,#m6,#m7').removeClass('list-group-item-info');
            $('#sec5').show();
            listbookingfordel();
            break;
        case 6:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec4,#sec5,#sec7').hide();
            $('#m6').addClass('list-group-item-info');
            $('#m1,#m2,#m3,#m4,#m5,#m7').removeClass('list-group-item-info');
            $('#sec6').show();
            break;
        case 7:
            $('#home,#sec0,#sec1,#sec2,#sec3,#sec4,#sec5,#sec6').hide();
            $('#m7').addClass('list-group-item-info');
            $('#m1,#m2,#m3,#m4,#m5,#m6').removeClass('list-group-item-info');
            $('#sec7').show();
            break;
    }
}

function checkform(){
     
    var p1 = document.getElementById('inputPassword').value;
    var p2 = document.getElementById('inputConfirmPassword').value;
        
        if(p1 != p2){
            document.getElementById('info').innerHTML = "<span class='label label-warning'><b>make sure two password are same<b></span>";
            return false;
        }
        else{
            return true;
        }
}

function checkcard(){
    var type = document.getElementById('cretype').value;
    var num = document.getElementById('ccn').value;
    var warning = document.getElementById('info');
    
    if(type == "jcb" && num.length != 16){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 16 digits<b></span>";
        return false;
    }
    else if(type == "americanexpress" && num.length != 15){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 15 digits<b></span>";
        return false;
    }
    else if(type == "bankcard" && num.length != 16){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 16 digits<b></span>";
        return false;
    }
    else if(type == "maestro" && num.length != 18){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 18 digits<b></span>";
        return false;
    }
    else if(type == "visa-electron" && num.length != 16){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 16 digits<b></span>";
        return false;
    }
    else if(type == "diners-club-carte-blanche" && num.length != 14){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 14 digits<b></span>";
        return false;
    }
    else if(type == "switch" && num.length != 19){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 19 digits<b></span>";
        return false;
    }
    else if(type == "solo" && num.length != 19){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 19 digits<b></span>";
        return false;
    }
    else if(type == "china-unionpay" && num.length != 16){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 16 digits<b></span>";
        return false;
    }
    else if(type == "laser" && num.length != 19){
        warning.innerHTML = "<span class='label label-warning'><b>there should be 19 digits<b></span>";
        return false;
    } 
    else 
        return true;
}
