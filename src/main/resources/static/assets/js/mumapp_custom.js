/*
/!*GET: $(document).ready(
    function() {
        console.log("holi holita vecinito");
        console.log(userId);
        debugger;

        var userCities;
        var userStyles;
        var userPopRate;

        $.ajax({
            type: "GET",
            url: '/api/'+userId+'/city',
        })
            .done(function (data) {
            if (console && console.log) {
                console.log(" Sample of data: ", data);
                userCities=data;
                debugger;
            }
        });

        $.ajax({
            type: "GET",
            url: '/api/'+userId+'/music',
        })
            .done(function (data) {
                if (console && console.log) {
                    console.log(" Sample of data: ", data);
                    userStyles=data;
                    debugger;
                }
            });

        $.ajax({
            type: "GET",
            url: '/api/'+userId+'/popularity',
        })
            .done(function (data) {
                if (console && console.log) {
                    console.log(" Sample of data: ", data);
                    userPopRate=data;
                    debugger;
                }
            });

});*!/


'use strict';

//
// Bars chart
//

var BarsChart = (function () {

    //
    // Variables
    //

    var $chart = $('#chart-bars');


    //
    // Methods
    //

    // Init chart
    function initChart($chart) {

        // Create chart
        var ordersChart = new Chart($chart, {

            type: 'bar',
            data: {
                labels: ['pepito', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                datasets: [{
                    label: 'popularity rate',
                    data: [25, 20, 30, 22, 17, 29]
                }]
            }
        });

        // Save to jQuery object
        $chart.data('chart', ordersChart);
    }


    // Init chart
    if ($chart.length) {
        initChart($chart);
    }

})();
*/




