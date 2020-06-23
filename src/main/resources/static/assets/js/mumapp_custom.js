GET: $(document).ready(
    function() {
        console.log("holi");
        debugger;
        var userCities;
        var userStyles;

        $.ajax({
            type: "GET",
            url: "/api/{id}/city",
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
            url: "/api/{id}/music",
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
            url: "/api/popularity/{musicId}/{cityId}",
        })
            .done(function (data) {
                if (console && console.log) {
                    console.log(" Sample of data: ", data);
                    userStyles=data;
                    debugger;
                }
            });





    });



