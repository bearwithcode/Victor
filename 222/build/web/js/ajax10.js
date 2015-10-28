function ajax10(){
    var onetime = true;
    $('#newair').submit(function(){
        if(onetime == true){
        $.post('newAir', $('#newair').serialize(), function(data){
            var planelist = document.getElementById("planelist"),
                name = document.getElementById("airname").value,
                city = document.getElementById("aircity").value,
                country = document.getElementById("aircou").value,
                itia = document.getElementById("airITIA").value,       
                airLat = document.getElementById("airLat").value,
                airLon = document.getElementById("airLon").value,
                altitude = document.getElementById("altitude").value,
                timezone = document.getElementById("timezone").value,
                dst = document.getElementById("dst").value,
                row = planelist.insertRow(),
                cell1 = row.insertCell(0),
                cell2 = row.insertCell(1),
                cell3 = row.insertCell(2),
                cell4 = row.insertCell(3),
                cell5 = row.insertCell(4),
                cell6 = row.insertCell(5),
                cell7 = row.insertCell(6),
                cell8 = row.insertCell(7),
                cell9 = row.insertCell(8),
                cell10 = row.insertCell(9),
                cell11 = row.insertCell(10);
                
                var twodata = data.split(":");
                
                cell1.innerHTML = "<button onclick = 'confirmremoveair(\"" + twodata[1] +"\")' type='button' class='btn btn-warning ' data-toggle='modal' data-target='#deleteAR' >remove</button>";
                cell2.innerHTML = twodata[2];
                cell3.innerHTML = name;
                cell4.innerHTML = city;
                cell5.innerHTML = country,
                cell6.innerHTML = itia;
                cell7.innerHTML = airLat;
                cell8.innerHTML = airLon;
                cell9.innerHTML = altitude;
                cell10.innerHTML = timezone;
                cell11.innerHTML = dst;
            
            onetime = false;
            alert("successfull create airplane");
            return;
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false;
        }
    });
}


