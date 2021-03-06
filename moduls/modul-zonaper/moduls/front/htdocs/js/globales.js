// JavaScript Document

/* Acc?s directe a les conselleries per mitj? del men? superior */
function accesDirecte() {
	valorUrl = document.getElementById('llista').options[document.getElementById('llista').selectedIndex].value;
	if(valorUrl.indexOf('.html') != -1) {
		document.location = valorUrl;
	}
}

/* mostra les fasanes i els pl?nols de situaci? dels centres de les conselleries */
function mostrarCentre(obj) {
	spans = obj.parentNode.parentNode.getElementsByTagName('span');
	if(spans[0].style.display == 'block') {
		for(i=0;i<spans.length;i++) spans[i].style.display = 'none';
		obj.innerHTML = 'Mostrar fa?ana i pl?nol de situaci?';
	} else {
		for(i=0;i<spans.length;i++) spans[i].style.display = 'block';
		obj.innerHTML = 'Ocultar fa?ana i pl?nol de situaci?';
	}
}

/* tramitaci? digital - seleccionar un ?tem d'una tabla */
function selecItemTabla(obj) {
	clase = obj.className;
	obj.className = 'perDamunt';
	obj.onmouseout = function() { if(clase == 'nou') obj.className = 'nou'; else obj.className = ''; };
}

// esborrar ?tem d'una tabla
function esborrarItem() {
	inputs = document.getElementsByTagName('input');
	inputsNum = 0;
	for(i=0;i<inputs.length;i++) if(inputs[i].checked == true && inputs[i].parentNode.nodeName != 'TH') inputsNum++;
	if(inputsNum == 0) alert('Cal que selleccioni un ?tem per esborrar-lo.');
	else if(inputsNum == 1) correcte = confirm('Est? segur de voler esborrar aquest ?tem?');
	else correcte = confirm('Est? segur de voler esborrar aquests ?tems?');
}

// selecciona tots els registres d'una tabla utilitzant un INPUT
function selecTots(obj) {
	if(obj.checked == true) selec = 1;
	else selec = 0;
	inputs = obj.parentNode.parentNode.parentNode.getElementsByTagName('input');
	for (var i = 0; i < inputs.length; i++) {
		if(selec == 1)  inputs[i].checked = true;
		else inputs[i].checked = false;
	}
	if(selec == 1) obj.checked = true;
	else obj.checked = false;
}

/* Cercador d'ajudes per conselleria o per materia */
function cercarAjudes(obj) {
	if(obj == 'conselleria') valorUrl = document.getElementById('ajudesConselleriaS').options[document.getElementById('ajudesConselleriaS').selectedIndex].value;
	else valorUrl = document.getElementById('ajudesMateriaS').options[document.getElementById('ajudesMateriaS').selectedIndex].value;
	if(valorUrl.indexOf('.html') != -1) {
		document.location = valorUrl;
	}
}


/* Els meus expedients. Mostrar docs. */
function exVerDocs(obj) {
	llista = obj.parentNode.parentNode.getElementsByTagName('ul')[0];
	if(llista.style.display == 'block') llista.style.display = 'none';
	else llista.style.display = 'block'
}



function b64UrlSafeToB64(b64UrlSafe){
	var b64 = b64UrlSafe.replace(/-/g, "+");
	b64 = b64.replace(/_/g, "/");
	return b64;
}

function b64ToB64UrlSafe(b64){
	var b64UrlSafe = b64.replace(/\+/g,"-");
	b64UrlSafe = b64UrlSafe.replace(/\//g,"_");
	b64UrlSafe = b64UrlSafe.replace(/(\r\n|[\r\n])/g,"");
	return b64UrlSafe;
}