$(document).ready(function(){

    init_morris_charts();
});
/* CHART - MORRIS  */

function init_morris_charts() {

    if( typeof (Morris) === 'undefined'){ return; }
    console.log('init_morris_charts');
    $.ajax({
        type: "GET",
        url: "/management/rvd",
        success: function (resp) {
            if ($('#graph_bar').length){
                Morris.Bar({
                    element: 'graph_bar',
                    data: JSON.parse(resp),
                    xkey: 'type',
                    ykeys: ['count'],
                    labels: ['Count'],
                    barRatio: 0.4,
                    barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
                    xLabelAngle: 35,
                    hideHover: 'auto',
                    resize: true
                });

            }
        },
        error: function (xhr, status, text) {
             alert("ERROR MESSAGE : "+JSON.stringify(xhr));

        }
    });


    $.ajax({
        type: "GET",
        url: "/management/gender",
        success: function (resp) {
            if ($('#graph_bar_group').length ){
                Morris.Donut({
                    element: 'graph_bar_group',
                    data: JSON.parse(resp),
                    colors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
                    formatter: function (y) {
                        return y + "%";
                    },
                    resize: true
                });


            }
        },
        error: function (xhr, status, text) {
            alert("ERROR MESSAGE : "+JSON.stringify(xhr));

        }
    });$.ajax({
        type: "GET",
        url: "/management/center",
        success: function (resp) {
            if ($('#graph_bar_group1').length ){
                Morris.Bar({
                    element: 'graph_bar_group1',
                    data: JSON.parse(resp),
                    xkey: 'center',
                    ykeys: ['count'],
                    labels: ['Count'],
                    barRatio: 0.4,
                    barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
                    xLabelAngle: 35,
                    hideHover: 'auto',
                    resize: true
                });

            }
        },
        error: function (xhr, status, text) {
            alert("ERROR MESSAGE : "+JSON.stringify(xhr));

        }
    });

    if ($('#graphx').length ){

        Morris.Bar({
            element: 'graphx',
            data: [
                {x: '2015 Q1', y: 2, z: 3, a: 4},
                {x: '2015 Q2', y: 3, z: 5, a: 6},
                {x: '2015 Q3', y: 4, z: 3, a: 2},
                {x: '2015 Q4', y: 2, z: 4, a: 5}
            ],
            xkey: 'x',
            ykeys: ['y', 'z', 'a'],
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            hideHover: 'auto',
            labels: ['Y', 'Z', 'A'],
            resize: true
        }).on('click', function (i, row) {
            console.log(i, row);
        });

    }

    if ($('#graph_area').length ){

        Morris.Area({
            element: 'graph_area',
            data: [
                {period: '2014 Q1', iphone: 2666, ipad: null, itouch: 2647},
                {period: '2014 Q2', iphone: 2778, ipad: 2294, itouch: 2441},
                {period: '2014 Q3', iphone: 4912, ipad: 1969, itouch: 2501},
                {period: '2014 Q4', iphone: 3767, ipad: 3597, itouch: 5689},
                {period: '2015 Q1', iphone: 6810, ipad: 1914, itouch: 2293},
                {period: '2015 Q2', iphone: 5670, ipad: 4293, itouch: 1881},
                {period: '2015 Q3', iphone: 4820, ipad: 3795, itouch: 1588},
                {period: '2015 Q4', iphone: 15073, ipad: 5967, itouch: 5175},
                {period: '2016 Q1', iphone: 10687, ipad: 4460, itouch: 2028},
                {period: '2016 Q2', iphone: 8432, ipad: 5713, itouch: 1791}
            ],
            xkey: 'period',
            ykeys: ['iphone', 'ipad', 'itouch'],
            lineColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            labels: ['iPhone', 'iPad', 'iPod Touch'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });

    }

    if ($('#graph_donut').length ){

        Morris.Donut({
            element: 'graph_donut',
            data: [
                {label: 'Jam', value: 25},
                {label: 'Frosted', value: 40},
                {label: 'Custard', value: 25},
                {label: 'Sugar', value: 10}
            ],
            colors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            formatter: function (y) {
                return y + "%";
            },
            resize: true
        });

    }

    if ($('#graph_line').length ){

        Morris.Line({
            element: 'graph_line',
            xkey: 'year',
            ykeys: ['value'],
            labels: ['Value'],
            hideHover: 'auto',
            lineColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            data: [
                {year: '2012', value: 20},
                {year: '2013', value: 10},
                {year: '2014', value: 5},
                {year: '2015', value: 5},
                {year: '2016', value: 20}
            ],
            resize: true
        });

        $MENU_TOGGLE.on('click', function() {
            $(window).resize();
        });

    }

};