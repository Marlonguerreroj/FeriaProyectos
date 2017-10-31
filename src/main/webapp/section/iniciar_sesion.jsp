<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Programa</a></li><li class="active"><a href="#">Iniciar sesión</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-8 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Iniciar Sesión</h1>
    </div>
    <form id="form_inicio_sesion" >
        <div class="row">
            <div class=" col-md-8  col-sm-8 col-xs-12">
                <label for="codEstudiante">Código</label>        
                <input name="codEstudiante" id="codEstudiante" type="number" class="ufps-input" required>
            </div>
        </div>
        <div class="row">
            <div class=" col-md-8  col-sm-8 col-xs-12">
                <label for="contrasena">Contraseña</label>
                <input name="contrasena" id="contrasena"  pattern=".{6,}"   required title="6 caracteres mínimo" type="password" class="ufps-input" required>
            </div>
        </div>
        <div style="padding-top: 15px" class="col-md-12 col-sm-12 col-xs-12">
            <p>
                <input value="true" name="logIn" id="logIn" hidden >
                <button class="btn btn-pinterest" type="submit" style="cursor: pointer">Iniciar Sesión</button>&nbsp; &nbsp; 
                <a class="btn btn-pinterest" style="cursor: pointer" onclick="limpiarFormulario('#form_inicio_sesion')">Limpiar Campos</a>
            </p>
        </div>
    </form>
</div>