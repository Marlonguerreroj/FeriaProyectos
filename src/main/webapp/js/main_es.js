(function(){var d="Traductor de Google",e=this;function f(a,w){a=a.split(".");var b=e;a[0]in b||!b.execScript||b.execScript("var "+a[0]);for(var c;a.length&&(c=a.shift());)a.length||void 0===w?b[c]&&b[c]!==Object.prototype[c]?b=b[c]:b=b[c]={}:b[c]=w};var g={0:"Traducir",1:"Cancelar",2:"Cerrar",3:function(a){return"Google ha traducido esta p\u00e1gina autom\u00e1ticamente al "+(a+".")},4:function(a){return"Traducido al: "+a},5:"Error: el servidor no ha podido completar la solicitud. Vuelve a intentarlo m\u00e1s tarde.",6:"M\u00e1s informaci\u00f3n",7:function(a){return"Con la tecnolog\u00eda de "+a},8:d,9:"Traducci\u00f3n en curso",10:function(a){return"\u00bfQuieres traducir esta p\u00e1gina al "+(a+"TARGET_LANGUAGE con el Traductor de Google?")},
11:function(a){return"Ver esta p\u00e1gina en: "+a},12:"Mostrar texto original",13:"El contenido de este archivo local se enviar\u00e1 a Google para traducirlo con una conexi\u00f3n segura.",14:"El contenido de esta p\u00e1gina segura se enviar\u00e1 a Google para traducirlo con una conexi\u00f3n segura.",15:"El contenido de esta p\u00e1gina de intranet se enviar\u00e1 a Google para traducirlo con una conexi\u00f3n segura.",16:"Seleccionar idioma",17:function(a){return"Desactivar traducci\u00f3n del "+
a},18:function(a){return"Desactivar para: "+a},19:"Siempre oculto",20:"Texto original:",21:"Sugiere una traducci\u00f3n mejor",22:"Enviar",23:"Traducir todo",24:"Restaurar todo",25:"Cancelar todo",26:"Traducir secciones a mi idioma",27:function(a){return"Traducir todo al "+a},28:"Mostrar idiomas originales",29:"Opciones",30:"Desactivar la traducci\u00f3n en este sitio",31:null,32:"Mostrar traducciones alternativas",33:"Haz clic en las palabras anteriores para obtener traducciones alternativas.",34:"Utilizar",
35:"Pulsa May\u00fas y arrastra las palabras para cambiar el orden.",36:"Haz clic para obtener traducciones alternativas.",37:"Mant\u00e9n pulsada la tecla May\u00fas y, a continuaci\u00f3n, haz clic en las palabras y arr\u00e1stralas para cambiar el orden.",38:"Gracias por proponer una traducci\u00f3n al Traductor de Google.",39:"Administrar la traducci\u00f3n de este sitio",40:"Haz clic en una palabra para obtener traducciones alternativas o doble clic para editar las traducciones directamente.",
41:"Texto original",42:d,43:"Traducir",44:"Se ha enviado tu correcci\u00f3n.",45:"Error: no se admite el idioma de la p\u00e1gina web.",46:"Widget de idiomas del Traductor"};var h=window.google&&google.translate&&google.translate._const;
if(h){var k;a:{for(var l=[],m=[""],n=0;n<m.length;++n){var p=m[n].split(","),q=p[0];if(q){var r=Number(p[1]);if(!(!r||.1<r||0>r)){var t=Number(p[2]),u=new Date,v=1E4*u.getFullYear()+100*(u.getMonth()+1)+u.getDate();!t||t<v||l.push({version:q,ratio:r,a:t})}}}var x=0,y=window.location.href.match(/google\.translate\.element\.random=([\d\.]+)/),z=Number(y&&y[1])||Math.random();for(n=0;n<l.length;++n){var A=l[n];x+=A.ratio;if(1<=x)break;if(z<x){k=A.version;break a}}k="TE_20170814_01"}var B="/element/%s/e/js/element/element_main.js".replace("%s",
k);if("0"==k){var C=" element %s e js element element_main.js".split(" ");C[C.length-1]="main_es.js";B=C.join("/").replace("%s",k)}if(h._cjlc)h._cjlc(h._pas+h._pah+B);else{var D=h._pas+h._pah+B,E=document.createElement("script");E.type="text/javascript";E.charset="UTF-8";E.src=D;var F=document.getElementsByTagName("head")[0];F||(F=document.body.parentNode.appendChild(document.createElement("head")));F.appendChild(E)}f("google.translate.m",g);f("google.translate.v",k)};}).call(window)
