function ajax7(){
    var onetime = true;
    $('#eachinv').submit(function(){
        if(onetime == true){ 
        $.post('createInventory', $('#eachinv').serialize(), function(data){    
            
                var item = document.getElementById("chooseitem").value,
                cost = document.getElementById("cost").value,
                available = document.getElementById("avail").value,
                table = document.getElementById("listallin"),
                row = table.insertRow(),
                cell1 = row.insertCell(0),
                cell2 = row.insertCell(1),
                cell3 = row.insertCell(2),
                cell4 = row.insertCell(3);
                
                cell1.innerHTML = "<button onclick = 'confirmremove(" + data +")' type='button' class='btn btn-warning ' data-toggle='modal' data-target='#confirmreit' >remove</button>"
                cell2.innerHTML = item;
                cell3.innerHTML = cost;
                cell4.innerHTML = available;
                alert("add successfully");
                onetime = false;
                return;
    
        }).fail(function() {  
            onetime = false;
            alert( "Posting failed." );
             
        });
        return false; 
        }
    });
}


