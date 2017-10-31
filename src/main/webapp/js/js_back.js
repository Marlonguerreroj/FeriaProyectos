function validarContrasenas() {
    var password = document.getElementById("contrasena")
            , confirm_password = document.getElementById("contrasenaN");

    function validatePassword() {
        if (password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Las contrase\u00f1as no coinciden");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
}

function registrarEstudiante() {
    validarContrasenas();
    $("#form_inscripcion").bind("submit", function () {
        $.blockUI({message: '<h1><img src="busy.gif" /> Espere un momento...</h1>'});
        $.ajax({
            type: "POST",
            url: "Controlador",
            data: $("#form_inscripcion").serialize(),
            success: function (data) {
                $.unblockUI();
                if (data === "true") {
                    $("#form_inscripcion").trigger("reset");
                    msjSuccess("Registro Exitoso!");
                } else if (data === "false") {
                    msjFailed("Ya se encuentra registrado!");
                }
            },
            error: function (data) {
                $.unblockUI();
            }
        });

        return false;
    });
}

function iniciar_sesion() {
    $("#form_inicio_sesion").bind("submit", function () {
        $.blockUI({message: '<h1><img src="busy.gif" /> Espere un momento...</h1>'});
        $.ajax({
            type: "POST",
            url: "Controlador",
            data: $("#form_inicio_sesion").serialize(),
            success: function (data) {
                $.unblockUI();
                if (data === "true") {
                    $("#form_inicio_sesion").trigger("reset");
                    location.reload();
                } else if (data === "false") {
                    $("#contrasena").val("");
                    msjFailed("Datos incorrectos!");
                }
            },
            error: function (data) {
                $.unblockUI();
            }
        });

        return false;
    });
}

function registrarEvaluador() {
    validarContrasenas();
    $("#form_inscripcion_evaluadores").bind("submit", function () {
        var form = $("#form_inscripcion_evaluadores")[0];
        var formData = new FormData(form);
        var name = $("#file").val().toUpperCase();
        if (name.endsWith(".JPG") || name.endsWith(".PNG") || name.endsWith(".JPEG")) {
            $.blockUI({message: '<h1><img src="busy.gif" /> Espere un momento...</h1>'});
            $.ajax({
                type: "POST",
                url: "Controlador",
                data: formData,
                encoding: "UTF-8",
                enctype: 'multipart/form-data',
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    $.unblockUI();
                    if (data === "true") {
                        $("#form_inscripcion_evaluadores").trigger("reset");
                        msjSuccess("Registro Exitoso!");
                    } else if (data === "false") {
                        msjFailed("Ya se encuentra registrado!");
                    }
                },
                error: function (data) {
                    $.unblockUI();

                }
            });
        } else {
            msjFailed("Solo se permiten archivos de imagen");
        }
        return false;
    });
}

function consultar_persona() {

    $("#codigo").focusout(function () {
        var codigo = $("#codigo").val();
        $.ajax({
            type: "POST",
            url: "Controlador",
            data: {codigo: codigo, consultar_persona: "true"},
            success: function (data) {
                $.unblockUI();
                if (data !== 'null') {
                    var obj = jQuery.parseJSON(data);
                    $("#nombres").val(obj.nombres);
                    $("#msjFailed").empty();
                }else{
                    $("#nombres").val("");
                    $("#msjFailed").empty();
                    $("#msjFailed").prepend("El usuario no se encuentra registrado");
                }
                
            },
            error: function (data) {
                $.unblockUI();
            }
        });
    });
}

function registrar_proyecto() {
    $("#form_inscripcion_proyectos").bind("submit", function () {
        var form = $("#form_inscripcion_proyectos")[0];
        var name = $("#file").val().toUpperCase();
        var ab = $("#file").val().replace('C:\\fakepath\\','');
        $("#fileName").val(ab);
        var formData = new FormData(form);
        if (name.endsWith(".DOC") || name.endsWith(".DOCX") || name.endsWith(".PDF")) {
            $.blockUI({message: '<h1><img src="busy.gif" /> Espere un momento...</h1>'});
            $.ajax({
                type: "POST",
                url: "Proyecto",
                data: formData,
                encoding: "UTF-8",
                enctype: 'multipart/form-data',
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    $.unblockUI();
                    if (data === "true") {
                        $("#form_inscripcion_proyectos").trigger("reset");
                        msjSuccess("Registro Exitoso!");
                    } else if (data === "false") {
                        msjFailed("Se produjo un error, Intentalo más tarde!");
                    }
                },
                error: function (data) {
                    $.unblockUI();

                }
            });
        } else {
            msjFailed("Solo se permiten archivos Word y Pdf");
        }

        return false;
    });
}

function consultar_proyectos_inscritos() {
    $.blockUI({message: '<h1><img src="busy.gif" /> Espere un momento...</h1>'});


    $.getJSON("Proyecto", {consultar_proyectos_inscritos: "true"})
            .done(function (json) {
                $.unblockUI();
                var tr;
                if (json.length > 0) {
                    for (var i = 0; i < json.length; i++) {
                        tr = $('<tr/>');
                        tr.append("<td>" + json[i].titulo + "</td>");
                        tr.append("<td>" + json[i].descripcion + "</td>");
                        tr.append("<td>" + json[i].fecha + "</td>");
                        tr.append("<td>" + json[i].docenteGuia.nombres + "</td>");
                        tr.append("<td>" + json[i].lineaTrabajo + "</td>");
                        tr.append("<td>" + json[i].integrantes + "</td>");
                        var codigo = '"'+json[i].codigo+'"';
                        tr.append("<td>" + "<a style='cursor: pointer;'  onclick='agregarIntegranteJS("+codigo+")'> <span class='fa fa-plus-circle ic'></span></a>" + "</td>");
                        $('#table').append(tr);
                    }
                }else{
                    $("#msjAlert").empty();
                    $("#msjAlert").prepend("No se encuentra inscrito a  un proyecto");
                    $("#table").hide(true);
                }

            })
            .fail(function (jqxhr, textStatus, error) {
                $.unblockUI();
                var err = textStatus + ", " + error;
                console.log("Request Failed: " + err);
            });
}

function agregarIntegranteJS (codigo){
    $("#codigoP").val(codigo);
    $("#codigo").val("");
    $("#nombres").val("");
    $('#myModal').modal();
}

function vincularEnvioPeticiones(){
    
    $("#agregar").bind("click", function () {
    
        var cod_destino = $("#codigo").val();
        var cod_proyecto = $("#codigoP").val();
        $.ajax({
            type: "POST",
            url: "Proyecto",
            data: {cod_destino: cod_destino, cod_proyecto: cod_proyecto,envio_peticiones: "true"},
            success: function (data) {
                $.unblockUI();
                alert(data);
                
            }
        });
    });
}