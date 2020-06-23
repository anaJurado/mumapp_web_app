GET: $(document).ready(
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

    });



