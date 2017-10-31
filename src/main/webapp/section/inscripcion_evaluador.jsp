<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Proyectos</a></li><li class="active"><a href="#">Inscripción</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-12 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Inscripción de Evaluador</h1>
    </div>
    <form id="form_inscripcion_evaluadores" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="codEstudiante">Código</label>        
                <input name="codEstudiante" id="codEstudiante" type="number" class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="nombres">Nombres</label>        
                <input name="nombres" id="nombres" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="apellidos">Apellidos</label>
                <input name="apellidos" id="apellidos" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="correo">Correo</label>
                <input name="correo" id="correo" type="email"  class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="cargo">Cargo</label>
                <select id="cargo" name="cargo" class="ufps-input" required>
                    <option value="">Seleccione</option>
                    <option value="2">Docente</option>
                    <option value="3">Egresado</option>
                </select>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="contrasena">Contraseña</label>
                <input name="contrasena" id="contrasena"  pattern=".{6,}"   required title="6 caracteres mínimo" type="password" class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="contrasenaN">Repita la Contraseña</label>
                <input name="contrasenaN" id="contrasenaN" type="password" class="ufps-input" required>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="dedicacion">Dedicación</label>
                <select id="dedicacion" name="dedicacion" class="ufps-input" required>
                    <option value="">Seleccione</option>
                    <option value="TC">TC</option>
                    <option value="CT">CT</option>
                    <option value="TCO">TCO</option>
                </select>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="estudios">Estudios de postgrado</label>
                <textarea name="estudios" id="estudios" class="ufps-input"></textarea>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="asignaturas">Asignaturas que actualmente ofrece</label>
                <textarea name="asignaturas" id="asignaturas" class="ufps-input"></textarea>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-6">
                <label for="file">Foto</label>
                <input href="#" name="file" accept="image/*" id="file" type="file" value="Seleccionar foto" required />
            </div>

        </div>
        <div style="padding-top: 15px" class="col-md-12 col-sm-12 col-xs-12 text-center">
            <p>
                <button class="btn btn-pinterest" type="submit" style="cursor: pointer">Inscribir</button>&nbsp; &nbsp; 
                <a class="btn btn-pinterest" style="cursor: pointer" onclick="limpiarFormulario('#form_inscripcion_evaluadores')">Limpiar Campos</a>
            </p>
        </div>
    </form>
</div>