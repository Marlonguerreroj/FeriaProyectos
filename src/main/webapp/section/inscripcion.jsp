<ul class="ufps-current-page">
    <li class=""><a href="javascript:;">Programa</a></li><li class="active"><a href="#">Inscripción</a></li></ul><div style="clear:both;"></div>
<div id="informacionContent" class="col-md-8 mb-margin-bottom-30 shadow-wrapper">
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-bottom:20px; border-bottom: 3px solid #aa1916; padding: 0;">
        <h1 class="pull-left" style="font-size:36px;">Inscripción de Estudiantes</h1>
    </div>
    <form id="form_inscripcion">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="codEstudiante">Código</label>        
                <input name="codEstudiante" id="codEstudiante" type="number" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="nombres">Nombres</label>        
                <input name="nombres" id="nombres" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="apellidos">Apellidos</label>
                <input name="apellidos" id="apellidos" type="text" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="correo">Correo</label>
                <input name="correo" id="correo" type="email"  class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="contrasena">Contraseña</label>
                <input name="contrasena" id="contrasena"  pattern=".{6,}"   required title="6 caracteres mínimo" type="password" class="ufps-input" required>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <label for="contrasenaN">Repita la Contraseña</label>
                <input name="contrasenaN" id="contrasenaN" type="password" class="ufps-input" required>
            </div>


            <div style="padding-top: 15px" class="col-md-12 col-sm-12 col-xs-12 text-center">
                <p>
                    <input value="true" name="send" id="send" hidden >
                    <button class="btn btn-pinterest" type="submit" style="cursor: pointer">Inscribirse</button>&nbsp; &nbsp; 
                    <a class="btn btn-pinterest" style="cursor: pointer" onclick="limpiarFormulario('#form_inscripcion')">Limpiar Campos</a>
                </p>
            </div>
        </div>
    </form>
</div>
<div class="col-md-4">
    <div class="gdl-custom-sidebar">
        <h3 class="gdl-custom-sidebar-title-m">Galerías
            <div class="ufps-tooltip" style="float:right;"><span style="float:right;"><a style="cursor: pointer" onclick="redirect('Galeria')"><img src="rsc/img/gallery.png"></a></span><span class="ufps-tooltip-content-left" style="font-size:14px; font-weight:normal; margin-right:5px;">Ir a galería</span></div>
        </h3>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image1.JPG" alt="" class="img-responsive">
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image2.JPG" alt="" class="img-responsive">
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image3.JPG" alt="" class="img-responsive">
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image4.JPG" alt="" class="img-responsive">
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image5.JPG" alt="" class="img-responsive">
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6 col-md-margin-bottom-30" style="padding-left: 5px; margin-bottom: 10px;">
            <img src="rsc/PrimeraFeria/image6.JPG" alt="" class="img-responsive"> 
        </div>
    </div>
</div>