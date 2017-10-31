
function redirect(url) {
    $("#divSection").empty();
    $("#divSection").load(url, function () {
        if (url === 'Inscripcion') {
            registrarEstudiante();
        } else if (url === 'Inicio_Sesion') {
            iniciar_sesion();
        } else if (url === 'IncripcionEvaluador') {
            registrarEvaluador();
            activar_desactivar();
        } else if (url === 'InscripcionProyectos') {
            registrar_proyecto();
        } else if (url === 'ConsultarProyectosInscritos') {
            consultar_proyectos_inscritos();
            consultar_persona();
            vincularEnvioPeticiones();
        }
    });
}
function limpiarFormulario(formulario) {
    $(formulario).trigger("reset");
}

function msjSuccess(title) {
    swal({
        title: title,
        type: "success",
        timer: 1000
    }).then(
            function () {},
            // handling the promise rejection
                    function (dismiss) {
                        if (dismiss === 'timer') {
                            console.log('I was closed by the timer');
                        }
                    }
            );
        }

function msjFailed(title) {
    swal({
        title: title,
        type: "error",
        timer: 1000
    }).then(
            function () {},
            // handling the promise rejection
                    function (dismiss) {
                        if (dismiss === 'timer') {
                            console.log('I was closed by the timer');
                        }
                    }
            );

        }

function activar_desactivar() {
    $("#cargo").on('change', function () {
        if (this.value === '3') {
            $("#dedicacion").prop('disabled', true);
            $("#asignaturas").prop('disabled', true);
        } else if (this.value === '2') {
            $("#dedicacion").prop('disabled', false);
            $("#asignaturas").prop('disabled', false);
        }
    });

}

function abrirModal(tipoUsuario,imagen, nombres, apellidos, correo, postgrado, dedicacion, asignaturas) {
    $("#image").attr("src", imagen);
    $("#tipo_usuario").empty();
    $("#tipo_usuario").prepend(tipoUsuario + ' del Programa Ingenier\u00EDa de Sistemas');
    $("#correo").attr("href", "mailto:" + correo);
    $("#correo").empty();
    $("#correo").prepend(correo);
    $("#estudio").empty();
    $("#estudio").prepend(postgrado);
    $("#dedicacion").empty();
    $("#dedicacion").prepend(dedicacion);
    $("#asignaturas").empty();
    $("#asignaturas").prepend(asignaturas);
    $("#nombresApellidos").empty();
    $("#nombresApellidos").prepend(nombres + ' ' + apellidos);
    $('#myModal').modal();
}

