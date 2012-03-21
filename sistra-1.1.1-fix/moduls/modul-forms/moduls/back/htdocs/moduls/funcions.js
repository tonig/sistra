
// Obrir un pop up
function obrir(url, name, x, y) {
   window.open(url, name, 'scrollbars=yes, resizable=yes, width=' + x + ',height=' + y);
}

// Obrir un pop up per el calendari
function obrirFixa(url) {
   window.open(url, 'Calendari', 'scrollbars=no, resizable=no, width=235 ,height=175');
}

function obrirTest(url) {
   window.open( url, '', 'toolbar, menubar, scrollbars, resizable');
}

// Auxiliar para formularios
function myIndex(o) {
   var f = o.form;
   
   for (i = 0; i < f.elements.length ; i++) {
      if (f.elements[i] == o) return i;
   }
}

// Confirma una baja mediante un di�logo
function confirmaBaja(texto) {
    var result = confirm(texto)

    if (result == true) {
        return true;
    } else {
        return false;
    }
}

function forward(url) {
    document.location.href = url;
}

function confirmAndForward(text, url) {
    if (confirm(text)) {
        forward(url);
    }
}

function alertaBloqueo(text) {
    alert(text);
}