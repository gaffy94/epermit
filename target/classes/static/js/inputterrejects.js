$(document).ready(function(){
    $('#buttonreject').click(function(e){
        e.preventDefault();
        var data  = $('.deletedata').val();
        $.ajax({
            type: "POST",
            url: "/inputter/processdeleteuser",
            data:{'user':data},
            success: function (resp) {
                alert("user deleted successfully");
                location.reload();
            },
            error: function (xhr, status, text) {
                // alert(text);

            }
        });


    });


    // $('#editdata').click(function(e){
    //     e.preventDefault();
    //     var data  = $('.deletedata').val();
    //     $.ajax({
    //         type: "POST",
    //         url: "/inputter/processeditrider",
    //          data:{'user':data},
    //         // success: function (resp) {
    //         //     alert("user deleted successfully");
    //         // },
    //         error: function (xhr, status, text) {
    //             // alert(text);
    //
    //         }
    //     });
    //
    //
    // });
});