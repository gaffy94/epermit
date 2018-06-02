$(document).ready(function () {
$('#role').on('change',function(e){
    var val = $('#role').val();
    if(val == "INPUTTER"){
        $('#centercontainer').removeClass('hide');
        $('#centercontainer option').each(function(){
                $(this).removeAttr('selected');
        });
        $('#center').removeAttr('readonly');
        $('#centercontainer').attr("required","required");
    }
    else{
        $('#centercontainer').addClass('hide');
        $('#center').removeAttr('readonly');
        $('#centercontainer option').each(function(){
            $(this).removeAttr('selected');
            var txt = $(this).attr('value');
            if(txt === "101"){
                $(this).removeAttr('selected');
                $(this).attr('selected','selected');
                $('#center').attr('readonly','readonly');
            }
        });
    }

});
var roleId = $('#role').attr('tid') ;
    if(roleId != null && roleId.length > 0 ){

        $('#role option').each(function() {
            var txt = $(this).attr('value');
            if (txt == roleId)
                $(this).attr('selected','selected');
        });
    }



});