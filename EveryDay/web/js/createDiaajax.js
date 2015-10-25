$(document).ready(function () {

    $('#newdiaryform').submit(function () {

        $.post('welcomediaryCon', $(this).serialize(), function (time) {
            if (time.indexOf("yesrec") != -1) {
                var gettime = time.split(":");
                var howmany = document.getElementById(gettime[1]);
                var count = parseInt(howmany.innerHTML) + 1;
                howmany.innerHTML = count;
            } else {
                $('#ds').append("<li class='list-group-item-info'><button class='btn-info' onclick='getdiary(\"" + time + "\")' class='btn-group'>" + time + "<span id = '" + time + "' class='badge'>1</span></button></li>");
            }
            //alert("successfully create new diary");

        }).fail(function () {
            alert("Posting failed.");

        });
        return false;
    });
});



