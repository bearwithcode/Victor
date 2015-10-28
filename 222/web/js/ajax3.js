function ajax3(){
    var onetime = true;
    if(onetime == true){
        $('#creroles').submit(function(){

            $.post('CreateManager', $('#creroles').serialize(), function(data){

                alert("successfull create roles in this enterprise");

            }).fail(function() {         
                alert( "Posting failed." );

            });
            return false; 
        });
    }
}


