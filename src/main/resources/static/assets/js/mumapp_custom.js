GET: $(document).ready(
    function() {

        // GET REQUEST
        $("#getALlBooks").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "",
                success : function(result) {
                    if (result.status === "success") {
                        console.log("Success: ", result);
                        debugger;
                    } else {
                        console.log("Fail: ", result);
                        debugger;
                    }
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                }
            });
        }
    })



