<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Proyectos</a></li><li class="active"><a href="#">Inscripción</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-12 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Consultar Proyectos Inscritos</h1>
    </div>
    <div><p id="msjAlert" style="color: #aa1916"></p></div>
    <div class="col-md-12 table-responsive">
        <table id="table" class="table">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Fecha</th>
                    <th>Docente</th>
                    <th>Linea de Trabajo</th>
                    <th>Integrantes</th>
                    <th></th>
                </tr>
            </thead>
        </table>
    </div>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Agregar un nuevo integrante</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class=" col-md-4  col-sm-5 col-xs-12">
                        <label for="codigo">Código</label>
                        <input name="codigoP" id="codigoP"  type="number">
                        <input name="codigo" id="codigo" type="number" class="ufps-input" required>
                    </div>
                     <div class=" col-md-6  col-sm-5 col-xs-12">
                        <label for="nombres">Nombre</label>
                        <input name="nombres" id="nombres" readOnly type="text" class="ufps-input">
                    </div>
                    <div class=" col-md-2  col-sm-2 col-xs-12">
                        <label>&nbsp;</label>
                        <button id="agregar" class="btn btn-pinterest" type="submit" style="cursor: pointer; margin-top: 27px;">Agregar</button>
                    </div>
                </div>
                <div class="row">
                    <p id="msjFailed" class="text-center" style="color: #aa1916"></p>
                </div>
            </div>
        </div>
    </div>
</div>