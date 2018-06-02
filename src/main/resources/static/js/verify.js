$(document).ready(function(){
    var isexists = $('#details').attr('isexist');
    console.log(isexists);
    if(isexists === 'true'){
        $('#details').removeClass('hide');
    }
});