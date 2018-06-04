$(document).ready(function () {
    var table = $('#datatable-buttons').DataTable();
    $('#datatable-buttons tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
        console.log("clicked");
    });
    $('#button').click(function () {
        //alert( table.rows('.selected').data()[1][0] +' row(s) selected' );
        var len = table.rows('.selected').data().length;
        var requestData = [];
        for (var i = 0; i < len; i++) {
            requestData[i] = table.rows('.selected').data()[i][0];
        }
        if (requestData.length < 1) {
            alert("Please make a selection!!");
            return false;
        }
        var data = "";
        var j = 0;
        while (j < requestData.length) {
            data = data + requestData[j];
            j++;
            if (j < requestData.length) {
                data = data + ',';
            }
        }
        $.ajax({
            type: "POST",
            url: "/generator/generatecard",
            data: {'user': data},
            success: function (resp) {
                var num = requestData.length;
                alert(num + ' rider(s) card generated successfully');
                location.reload();
            },
            error: function (xhr, status, text) {
                // alert(text);
            }
        });
    });
});
