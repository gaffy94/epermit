$(document).ready(function () {
    $('#screenshot-img').on('load',function(){
       $('#userimg').attr('value', $('#screenshot-img').attr('src'));
    });

    var gender = $('#rgender').attr('value');
    if(gender != null && gender.length > 0 ){

        $('.radio-inline').each(function() {
            var txt = $(this).attr('value');
            if (txt == gender)
                $(this).attr('checked','checked');
        });
    }
    var state = $('#state').attr('state');
    if(state != null && state.length > 0 ){

        $('#state option').each(function() {
            var txt = $(this).attr('value');
            if (txt == state)
                $(this).attr('selected','selected');
        });
    }

    var lga = $('#lga').attr('lga');
    if(lga != null && lga.length > 0 ){

        $('#lga option').each(function() {
            var txt = $(this).attr('value');
            if (txt == lga)
                $(this).attr('selected','selected');
        });
    }


    var vehtype = $('#vehtype').attr('vehtype');
    if(vehtype != null && vehtype.length > 0 ){

        $('#vehtype option').each(function() {
            var txt = $(this).attr('value');
            if (txt == vehtype)
                $(this).attr('selected','selected');
        });
    }

});

