
function redirect(url) {
    $("#divSection").empty();
    $("#divSection").load(url, function () {
        if (url === 'Inscripcion') {
            $("#nIntegrante").focusout(function () {
                if ($("#nIntegrante").val() > 5) {
                    $("#nIntegrante").val("5");
                }
                if ($("#nIntegrante").val() < 1) {
                    $("#nIntegrante").val("1");
                }
                if ($("#nIntegrante").val() > 1) {
                    
                }
            });
        }
    });
}


