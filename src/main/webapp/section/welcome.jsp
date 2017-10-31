<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Programa </a></li><li class="active"><a href="#">Evaluadores</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-12 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Evaluadores</h1>
    </div>
    <c:if test = "${fn:length(evaluadores) le 0}">
        <div><p style="color: #aa1916">No hay evaluadores registrados</p></div>
    </c:if>
    <c:forEach items="${evaluadores}" var="eval">
        <div class="col-md-2 col-sm-4 col-xs-6">
            <a style="cursor: pointer" onclick="abrirModal('${eval.tipo.descripcion}','${eval.foto}', '${eval.nombres}', '${eval.apellidos}', '${eval.correo}', '${eval.postgrado}', '${eval.dedicacion}', '${eval.asignaturas}')" class="thumbnail">
                <img style="width: 100%; height: auto; border-radius: 15px;" src="${eval.foto}" >
            </a>
            <h6 class="text-center">${eval.nombres} ${eval.apellidos}<br> ${eval.tipo.descripcion}</h6>
        </div>
    </c:forEach>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 id="tipo_usuario" class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-3">
                        <img id="image" style="width: 100%; height: auto; border-radius: 15px;" src="" >
                    </div> 
                    <div class="col-md-3">
                        <h5>Nombres y Apellidos</h5>
                    </div>
                    <div class="col-md-6">
                        <h5 id="nombresApellidos"></h5>
                    </div>
                    <div class="col-md-3">
                        <h5>Correo Electrónico</h5>
                    </div>
                    <div class="col-md-6">
                        <h5><a id="correo"></a></h5>
                    </div>
                    <div class="col-md-3">
                        <h5>Estudios de postgrado (Universidad y Titulo)</h5>
                    </div>
                    <div class="col-md-6">
                        <h5 class="text-justify" id="estudio"></h5>
                    </div>

                    <div class=" col-md-3">
                        <h5>Dedicación</h5>
                    </div>
                    <div class="col-md-6">
                        <h5 id="dedicacion"></h5>
                    </div>
                    <div class="col-md-3">
                        <h5>Asignaturas que actualmente ofrece</h5>
                    </div>
                    <div class="col-md-6">
                        <h5 class="text-justify" id="asignaturas"></h5>
                    </div>

                </div>
            </div>

        </div>

    </div>
</div>