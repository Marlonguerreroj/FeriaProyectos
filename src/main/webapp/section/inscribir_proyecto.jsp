<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Proyectos</a></li><li class="active"><a href="#">Inscripción</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-8 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Inscripción de Proyectos</h1>
    </div>
    <form id="form_inscripcion_proyectos" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6 col-sm-4 col-xs-6">
                <label for="titulo">Titulo</label>        
                <input name="titulo" id="titulo" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-4 col-xs-6">
                <label for="descripcion">Descripción</label>
                <textarea name="descripcion" id="descripcion" class="ufps-input"></textarea>
            </div>
            <div class="col-md-6 col-sm-4 col-xs-6">
                <label for="lTrabajo">Linea de Trabajo</label>        
                <input name="lTrabajo" id="lTrabajo" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-4 col-xs-6">
                <label for="docente">Docente</label>        
                <select id="docente" name="docente" class="ufps-input" required>
                    <option value="">Seleccione</option>
                    <c:forEach items="${docentes}" var="doc">
                        <option value="${doc.codigo}">${doc.nombres}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="file">Documento</label>
                <input href="#" name="file" accept=".doc,.docx,.pdf" id="file" type="file" value="Seleccionar documento" required />
                <input name="fileName" id="fileName" hidden>
            </div>

        </div>
        <div style="padding-top: 15px" class="col-md-12 col-sm-12 col-xs-12 text-center">
            <p>
                <input name="inscripcion_proyectos" id="inscripcion_proyectos" value="true" hidden="true">
                <button class="btn btn-pinterest" type="submit" style="cursor: pointer">Inscribir</button>&nbsp; &nbsp; 
                <a class="btn btn-pinterest" style="cursor: pointer" onclick="limpiarFormulario('#form_inscripcion_proyectos')">Limpiar Campos</a>
            </p>
        </div>
    </form>
</div>