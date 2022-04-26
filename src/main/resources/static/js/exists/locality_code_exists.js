$(document).ready(function() {
    $("#localityCode").on("input", function(e) {
        $.ajax({
            type: 'post',
            contentType: "application/json",
            url: "/exists/locality/?localityCode=" + $('#localityCode').val(),
            datatype: "json",
            success: function(msg) {
                if (msg) {
                    $('#localityMsg').html("Locality already exists").css("color", "red")
                } else {
                    $('#localityMsg').html("Locality is available").css("color", "green")
                }
            }
        })
    })
})
