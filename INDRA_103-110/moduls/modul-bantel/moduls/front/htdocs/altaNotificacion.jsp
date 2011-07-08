<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ page import="org.apache.struts.Globals" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<script type="text/javascript" src="js/jquery.selectboxes.pack.js"></script>
<script type="text/javascript" src="js/ajuda.js"></script>
<script type="text/javascript" src="js/funcions.js"></script>
<script type="text/javascript" src="js/mensaje.js"></script>	

<!--  Scripts para firma (depende implementacion) -->
	<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/deployJava.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/time.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/instalador.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/firma.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/utils.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/constantes.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/firma/aFirma/js/configClienteaFirmaSistra.js"></script>
	<script type="text/javascript">		
		base = "<%=request.getAttribute("urlSistraAFirma")%><%=request.getContextPath()%>/firma/aFirma";
		baseDownloadURL = "<%=request.getAttribute("urlSistraAFirma")%><%=request.getContextPath()%>/firma/aFirma";
	</script>
	</logic:equal>
		
	<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">	
			<script type="text/javascript" src="<%=request.getContextPath()%>/firma/caib/js/firma.js"></script>
	</logic:equal>
	
<!--  FIRMA DIGITAL -->
<script type="text/javascript">
<!--
	<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">									
	
		var contentType = '<%= es.caib.util.FirmaUtil.obtenerContentTypeCAIB(es.caib.util.FirmaUtil.CAIB_DOCUMENT_NOTIFICACIO_CONTENT_TYPE) %>';
		var mensajeEnviando = '<bean:message key="anexarDocumentos.mensajeAnexar"/>';
		
		function firmarCAIB(form){			
			var firma = '';	
			var i = 0;
			var applet;
			var pin;
			applet = whichApplet();
			pin = form.PIN.value;
			applet.setPassword( pin );
			firma = applet.firmarFicheroB64( $('#documentoB64').val(), contentType );	
			if (firma == null || firma == ''){
				alert(applet.getLastError());
				return false;
			}
			$('#firma').val(firma);
			return true;
		}
	</logic:equal>	
	
	<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
	
		function prepararEntornoFirma(){
			cargarAppletFirma(sistra_ClienteaFirma_buildVersion);
		}
				
		function firmarAFirma(form){
	      var firma = '';
	      var i = 0;
		  if (clienteFirma == undefined) { 
	          alert("No se ha podido instalar el entorno de firma");
	          return false;
	       	}
	       	clienteFirma.initialize();
			clienteFirma.setShowErrors(false);
			clienteFirma.setSignatureAlgorithm(sistra_ClienteaFirma_SignatureAlgorithm);
			clienteFirma.setSignatureMode(sistra_ClienteaFirma_SignatureMode);
			clienteFirma.setSignatureFormat(sistra_ClienteaFirma_SignatureFormat);
			if($('#documentoB64').val() == null || $('#documentoB64').val() == ''){
				return false;
			}
			// Pasamos de b64 urlSafe a b64
			var b64 = b64UrlSafeToB64($('#documentoB64').val());
			
			clienteFirma.setData(b64);
			clienteFirma.sign();
			
			if(clienteFirma.isError()){
				error = 'Error: '+clienteFirma.getErrorMessage();
				alert(error);
				return false;
			}else{	
			     firma = clienteFirma.getSignatureBase64Encoded();
			     firma = b64ToB64UrlSafe(firma);
			}
			document.getElementById("firma").value=firma;
			return true;
		}
	</logic:equal>
	
	function anexarDocumento(form){
		Mensaje.mostrar({tipo: "mensaje", modo: "ejecutando", fundido: "si", titulo: "Firmando documento..."});
	
		<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
			if (!firmarAFirma(form)){
				Mensaje.cancelar();	 
				return;
			}
		</logic:equal>
		<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">	
			if (!firmarCAIB(form)){ 
				Mensaje.cancelar();	
				return;
			}
		</logic:equal>
				
		// Enviar formulario
		var url_json = '<html:rewrite page="/firmarDocumentoAnexo.do"/>';
		var data = "atributo=documentosAltaNotificacion&nombre="+$('#nombreFirmar').val()+"&codigoRDS="+$('#codigoRDSFirmar').val()+"&claveRDS="+$('#claveRDSFirmar').val()+"&firma="+$('#firma').val();		
		// $.ajaxSetup({scriptCharset: "utf-8", contentType: "application/json; charset=utf-8"});
		$.postJSON(url_json, data, function(datos) {
              	//$('#documentos').html(datos.taula);
              	
                idInfo = "#infoFirmado-" +	$('#codigoRDSFirmar').val();
              	
				$('#documentoB64').val('');
				$('#firma').val('');
				$('#nombreFirmar').val('');
				$('#codigoRDSFirmar').val('');
				$('#claveRDSFirmar').val('');
				
				if (datos.error==""){								
					$(idInfo).html(htmlInfoFirmado);
				}else{
					alert(datos.error);
				}
				
				$('#firmarDocumentosApplet').hide('slow');
				$('#anexar').hide('slow');
				
		        Mensaje.cancelar();	
        	});
        	

	}
	
	<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
					 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
		prepararEntornoFirma();
	</logic:equal>
	
	function botonCancelarFirmar() {
		$('#firmarDocumentosApplet').hide('slow');
	}
	
//-->
</script>

<script type="text/javascript">
var htmlInfoFirmado = "- <strong><bean:message key="detalleTramite.datosTramite.envio.firmado"/></strong>";


var municipioLoaded="";

function llenarMunicipios(){
	codProv = $("#codigoProvincia").val();	
	var url_json = '<html:rewrite page="/listarMunicipios.do"/>';
	var data ='provincia='+codProv;
	$.postJSON(url_json, data, 
		function(datos){
			$("#codigoMunicipio").removeOption(/./);
			$("#codigoMunicipio").removeOption(""); 
			$("#codigoMunicipio").addOption(datos, false); 	
			if (municipioLoaded != "") {
				$("#codigoMunicipio").val(municipioLoaded);
				municipioLoaded="";
			}
	});
}	

function llenarProvincias(){
	var url_json = '<html:rewrite page="/listarProvincias.do"/>';
	$.postJSON(
		url_json, '',
		function(datos){
			$("#codigoProvincia").removeOption(/./);
			$("#codigoProvincia").removeOption(""); 
			$("#codigoProvincia").addOption(datos, false); 	
		}
	);
}		

function vaciarProvincias(){
	$("#codigoProvincia").removeOption(/./);
	$("#codigoProvincia").removeOption(""); 
}


function recargaProvincias(){
	if(document.detalleNotificacionForm.codigoPais.value=="ESP"){
		llenarProvincias();
	}else{
		vaciarProvincias();
	}
}

function altaDocument(form){
	
	Mensaje.mostrar({tipo: "mensaje", modo: "ejecutando", fundido: "si", titulo: "Enviando datos..."});
	
	var archivo = $('input[type=file]').val();
	var permitida = false;
	if(archivo != null && archivo != ''){
		var extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase();
		if(extension != null && extension != ''){
			var extensiones_permitidas = new Array(".docx", ".doc", ".odt"); 
			for (var i = 0; i < extensiones_permitidas.length; i++) {
				if (extensiones_permitidas[i] == extension) {
					permitida = true;
					break;	
				}
			} 			
		}
	}

	if(permitida){
		form.flagValidacion.value ="documento";
		form.idiomaExp.value =document.detalleNotificacionForm.idiomaExp.value;
		form.descripcionExpediente.value =document.detalleNotificacionForm.descripcionExpediente.value;
		form.rutaFitxer.value =form.documentoAnexoOficio.value;
		form.submit();
	}else{				
		alert("<bean:message key="error.aviso.extensiones.fichero"/>");
		Mensaje.cancelar();
	}	
	return permitida;
}

function alta(){
	if(confirm ( "<bean:message key='notificacion.alta.confirmacion' />" )){
		Mensaje.mostrar({tipo: "mensaje", modo: "ejecutando", fundido: "si", titulo: "Enviando datos..."});
		
		var indexP = document.detalleNotificacionForm.codigoPais.selectedIndex;
		if(indexP>0)
			document.detalleNotificacionForm.nombrePais.value = document.detalleNotificacionForm.codigoPais.options[indexP].text;
	
		var indexProv = document.detalleNotificacionForm.codigoProvincia.selectedIndex;
		if(indexProv>0)
			document.detalleNotificacionForm.nombreProvincia.value = document.detalleNotificacionForm.codigoProvincia.options[indexProv].text;
	
		var indexProv = document.detalleNotificacionForm.codigoMunicipio.selectedIndex;
		if(indexProv>0)
			document.detalleNotificacionForm.nombreMunicipio.value = document.detalleNotificacionForm.codigoMunicipio.options[indexProv].text;
	
		document.detalleNotificacionForm.rutaFitxer.value = document.uploadNotificacionForm.documentoAnexoOficio.value;
		document.detalleNotificacionForm.action='<html:rewrite page="/realizarAltaNotificacion.do"/>';
		document.detalleNotificacionForm.submit();
		return true;
	}else{
		return false;
	}
}

function mostrarFirmar(nombre,codigoRDS,claveRDS){
	var url_json = '<html:rewrite page="/irFirmarDocumento.do"/>';
	var data ='atributo=documentosAltaNotificacion&nombre='+nombre+'&codigoRDS='+codigoRDS+'&claveRDS='+claveRDS;
	$.postJSON(
		url_json,data,
		function(datos){
			var nombreF = '<p class="titol"> <bean:message key="aviso.firmar"/> </p>'; 
			$('#documentoB64').val(datos.base64);
			$('#firmarDocumentosApplet').show('slow');
			$('#anexar').hide('slow');
			$('#firma').val('');
			$('#nombreFirmar').val(nombre);
			$('#codigoRDSFirmar').val(codigoRDS);
			$('#claveRDSFirmar').val(claveRDS);
		}
	);
}

function volver(identificadorExp,unidadAdm,claveExp){
	document.detalleNotificacionForm.action='<html:rewrite page="/recuperarExpediente.do?identificadorExp='+identificadorExp+'&unidadAdm='+unidadAdm+'&claveExp='+claveExp+'" />';
	document.detalleNotificacionForm.submit();
}

function mostrarAnexarDocumentos(){
	$('#anexar').show('slow');
	$('#firmarDocumentosApplet').hide('slow');
	$("#botonMostrarAnexar").attr("disabled","disabled");
}

function esconderAnexarDocumentos(){
	document.uploadNotificacionForm.documentoAnexoOficio.value = null;
	document.uploadNotificacionForm.tituloAnexoOficio.value = '';
	$('#anexar').hide('slow');
	$('#firmarDocumentosApplet').hide('slow');
	$("#botonMostrarAnexar").removeAttr("disabled");
}

$(document).ready(function(){
		$('#firmarDocumentosApplet').hide();
		$('#anexar').hide();
		$.postJSON = function(url, data, callback) {
        	return jQuery.ajax({
		        'type': 'POST',
		        'url': url,
		        'data': data,
		        'dataType': 'json',
		        'success': callback
		    });
		};
		afegirParametre();
	}
);


//funcion para el iframe, una vez hecho el submit del formulario donde se encuentra el documento
//llamamos a esta funci�n para modificar el div de los documentos que tenemos.
function fileUploaded(){
	var url_json = '<html:rewrite page="/irBuscarDocumentos.do"/>';
	var data ='atributo=documentosAltaNotificacion';
	$.postJSON(
		url_json,data,
		function(datos){
			if (datos.error==""){								
				$('#documentos').html(datos.divDocuments);
			}else{
				alert(datos.error);
			}
			Mensaje.cancelar();
			esconderAnexarDocumentos();
		}
	);
}
//funcion para el iframe, una vez hecho el submit del formulario donde se encuentra el documento
//llamamos a esta funci�n si ha fallado la carga del documento y muestra un alert con el error
function errorFileUploaded(error){
	alert(error);
	Mensaje.cancelar();
}

function borrarParametre(codi){
	var url_json = '<html:rewrite page="/borrarParametro.do"/>';
	var data ='codi='+codi;
	$.postJSON(url_json, data, 
		function(datos){
			repintarParametros(datos);
	}
);
}

function afegirParametre(){
	var codi = $('#codigoParametroTramiteSubsanacion').val();	
	var valor = $('#valorParametroTramiteSubsanacion').val();	
	var url_json = '<html:rewrite page="/altaParametro.do"/>';
	var data ='codi='+codi+'&valor='+valor;
	$.postJSON(url_json, data, 
		function(datos){
			repintarParametros(datos);
		}
	);
	$('#codigoParametroTramiteSubsanacion').val('');
	$('#valorParametroTramiteSubsanacion').val('');
	 
}
function repintarParametros(datos){
	var divParametros = "<ul id='parametro'>";
	$.each(datos, function(i,objeto){  
			divParametros = divParametros+"<li><p><label><bean:message key='tramite.subsanacion.parametros.codi'/></label>";
			divParametros = divParametros+"<input type=\"text\" name=\""+objeto.codi+"\" value=\""+objeto.codi+"\" readonly=\"true\">";
			divParametros = divParametros+"<label class=\"enLinia\"><bean:message key='tramite.subsanacion.parametros.valor'/></label>";
			divParametros = divParametros+"<input type=\"text\" name=\""+objeto.codi+objeto.valor+"\" value=\""+objeto.valor+"\" readonly=\"true\">";
			divParametros = divParametros+"<a class=\"esborrar\" onclick=\"borrarParametre('"+objeto.codi+"');\">borrar</a>";
			divParametros = divParametros+"</p></li>";
		}
	); 
	divParametros = divParametros+"</ul> <br/>";
	$('#parametros').html(divParametros);
}
</script>
<script type="text/javascript">
     <!--
     function mostrarArbolUnidades(url) {
        obrir(url, "Arbol", 540, 400);
     }
     // -->
</script>
<bean:define id="urlConfirmacion" type="java.lang.String">
	<html:rewrite href="/zonaperback/init.do" paramId="lang" paramName="<%= Globals.LOCALE_KEY  %>" paramProperty="language" paramScope="session"/>
</bean:define>
<bean:define id="urlArbol">
    <html:rewrite page="/arbolUnidades.do"/>
</bean:define>
<bean:define id="urlAbrirDocumento"  type="java.lang.String" >
	<html:rewrite page="/abrirDocumento.do"/>
</bean:define>
<bean:define id="autenticado"  type="java.lang.String" >
	<bean:write name="autenticado"/>
</bean:define>

		<!-- ajuda boto -->
		<button id="ajudaBoto" type="button" title="Activar ajuda"><img src="imgs/botons/ajuda.gif" alt="" /> <bean:message key="confirmacion.ayuda"/></button>
		<!-- /ajuda boto -->
		<div id="opcions">
				&nbsp;
		</div>
		<!-- titol -->
		<!--<h1>Gesti�n de expedientes</h1>-->
		<!-- /titol -->
		
		<!-- ajuda -->
		<div id="ajuda">
			<h2><bean:message key="ajuda.titulo"/></h2>
			<br/>
			<bean:message key="ajuda.CampoObligarorio"/>
				<bean:message key="ajuda.notificacio.oficina"/>
				<bean:message key="ajuda.notificacio.organo"/>
				<bean:message key="ajuda.notificacio.nif"/>
				<bean:message key="ajuda.notificacio.nombre"/>
				<bean:message key="ajuda.notificacio.idioma"/>
				<bean:message key="ajuda.notificacio.acuseRecibo"/>
				<bean:message key="ajuda.notificacio.titulo"/>
				<bean:message key="ajuda.notificacio.texto"/>
				<bean:message key="ajuda.notificacio.tituloRem"/>
				<bean:message key="ajuda.notificacio.textoRem"/>
			<bean:message key="ajuda.finCampoObligarorio"/>
			
				<bean:message key="ajuda.notificacio.pais"/>
				<bean:message key="ajuda.notificacio.provincia"/>
				<bean:message key="ajuda.notificacio.municipio"/>
		</div>
		<!-- /ajuda -->
		
		<html:errors/>
		
		<!-- continguts -->
		<div class="continguts">
			<%--<h1><bean:write  name="detalleNotificacionForm" property="descripcionExpediente"/></h1>--%>
		
			<p class="titol"><bean:message key="notificacion.alta"/></p>
			<div class="remarcar">
				<html:form action="realizarAltaNotificacion" enctype="multipart/form-data" styleClass="remarcar opcions">
				<html:hidden property="descripcionExpediente"/>
				<html:hidden property="flagValidacion" value="altaNotificacion"/>
				<html:hidden property="rutaFitxer"/>				
				<html:hidden property="usuarioSey" />
				<html:hidden property="idiomaExp" />
				
				<p class="titol major">
					<bean:message key="notificacion.datos.oficina"/>
				</p>
				
				<p>
					<label for="oficinaRegistro"><bean:message key="notificacion.oficina"/></label>
					<html:select property="oficinaRegistro" styleClass="pc40" >
			   			<logic:present name="listaoficinasregistro">
							<logic:iterate id="oficina" name="listaoficinasregistro">	
								<html:option value="<%=((es.caib.bantel.front.util.ValorOrganismo)oficina).getCodigo().toString()%>"><bean:write name="oficina" property="descripcion"/></html:option>
							</logic:iterate>
						</logic:present>
			    	</html:select>
				</p>
				
				<p>
					<label for="organo_destino"><bean:message key="notificacion.organo"/></label>
					<html:select property="organoDestino" styleClass="pc40">
			   			<logic:present name="listaorganosdestino">
							<logic:iterate id="organo" name="listaorganosdestino">	
								<html:option value="<%=((es.caib.bantel.front.util.ValorOrganismo)organo).getCodigo().toString()%>"><bean:write name="organo" property="descripcion"/></html:option>
							</logic:iterate>
						</logic:present>
			    	</html:select>
				</p>
				
				<p class="titol major">
					<bean:message key="notificacion.datos.destinatario"/>
				</p>
				
				<p>
					<label for="nif"><bean:message key="expediente.nif"/></label>
					<html:text property="nif" readonly="<%=Boolean.parseBoolean(autenticado)%>"/>					
				</p>
				
				<p>
					<label for="apellidos"><bean:message key="notificacion.nombre.apellisos"/></label>
					<html:text property="apellidos" styleClass="pc40" readonly="<%=Boolean.parseBoolean(autenticado)%>" />
				</p>
				
				<p>
					<label for="codigoPais"><bean:message key="notificacion.pais"/></label>
					<html:select property="codigoPais" onchange="recargaProvincias();" styleClass="pc20">
						<logic:iterate id="pais" name="paises">	
							<html:option value="<%=((es.caib.bantel.front.json.Pais)pais).getCodigo()%>" ><bean:write name="pais" property="descripcion"/></html:option>
						</logic:iterate>
					</html:select>
					<html:hidden property="nombrePais" styleId="nombrePais"/>
				</p>
				
				<p>
					<label for="codigoProvincia"><bean:message key="notificacion.provincia"/></label>
					<html:select property="codigoProvincia" styleId="codigoProvincia" onchange="javascript:llenarMunicipios();" styleClass="pc20">
						<logic:iterate id="provincia" name="provincias">	
							<html:option value="<%=((es.caib.bantel.front.json.Provincia)provincia).getCodigo()%>" ><bean:write name="provincia" property="descripcion"/></html:option>
						</logic:iterate>
					</html:select>
					<html:hidden property="nombreProvincia" styleId="nombreProvincia"/>
				</p>
				
				<p>
					<label for="codigoMunicipio"><bean:message key="notificacion.municipio"/></label>
					<html:select property="codigoMunicipio" styleId="codigoMunicipio" styleClass="pc20">
						<logic:present name="municipios">
							<logic:iterate id="municipio" name="municipios">	
								<html:option value="<%=((es.caib.bantel.front.json.Localidad)municipio).getCodigo().toString()%>"><bean:write name="municipio" property="descripcion"/></html:option>
							</logic:iterate>
						</logic:present>
					</html:select>
					<html:hidden property="nombreMunicipio" styleId="nombreMunicipio"/>
				</p>
				
				<p class="titol major">
					<bean:message key="notificacion.datos.notificacion"/>
				</p>
				
				<p>
					<label for="idioma"><bean:message key="expediente.idioma"/></label>
					<html:select  property="idioma">
						<html:option value="es"><bean:message key="expediente.castellano"/></html:option>
						<html:option value="ca"><bean:message key="expediente.catalan"/></html:option>
						<html:option value="en"><bean:message key="expediente.ingles"/></html:option>
					  </html:select>
				</p>
				
				<p>
					<label for=tiposAsunto><bean:message key="notificacion.tipoAsunto"/></label>
					<html:select property="tipoAsunto">
			   			<logic:present name="tiposAsunto">
							<logic:iterate id="tipoAs" name="tiposAsunto">	
								<html:option value="<%=((es.caib.bantel.front.util.ValorOrganismo)tipoAs).getCodigo().toString()%>"><bean:write name="tipoAs" property="descripcion"/></html:option>
							</logic:iterate>
						</logic:present>
			    	</html:select>
				</p>
				
				<p>
					<label for="acuse"><bean:message key="notificacion.acuse"/></label>
					<html:select  property="acuse">
						<html:option value="S"><bean:message key="expediente.si"/></html:option>
						<html:option value="N"><bean:message key="expediente.no"/></html:option>
					  </html:select>
				</p>
				
				<p class="titol">
					<bean:message key="notificacion.datos.aviso"/>
				</p>
				
				<p>
					<label for="tituloAviso"><bean:message key="aviso.titulo"/></label>
					<html:textarea rows="5" cols="49" property="tituloAviso" styleClass="pc40" />
				</p>
				
				<p>
					<label for="textoAviso"><bean:message key="aviso.texto"/></label>
					<html:textarea rows="5" cols="49" property="textoAviso" styleClass="pc40" />
				</p>
				
				<p>
					<label for="textoSmsAviso"><bean:message key="aviso.textoSMS"/></label>
					<html:textarea rows="5" cols="49" property="textoSmsAviso" styleClass="pc40" />
				</p>
		     
				<p class="titol">
					<bean:message key="notificacion.datos.oficio.remision"/>
				</p>
				
				<p>
					<label for="tituloOficio"><bean:message key="aviso.titulo"/></label>
					<html:text property="tituloOficio" styleClass="pc40" />
				</p>
				
				<p>
					<label for="textoOficio"><bean:message key="aviso.texto"/></label>
					<html:textarea rows="5" cols="49" property="textoOficio" styleClass="pc40" />
				</p>
					<p class="titol">
						<bean:message key="notificacion.datos.tramite.subsanacion"/>
					</p>
					
					<p>
						<label for="descripcionTramiteSubsanacion"><bean:message key="tramite.subsanacion.descripcion"/></label>
						<html:text property="descripcionTramiteSubsanacion" styleClass="pc40" />
					</p>
					
					<p>
						<label for="identificadorTramiteSubsanacion"><bean:message key="tramite.subsanacion.identificador"/></label>
						<html:text property="identificadorTramiteSubsanacion" styleClass="pc40" />
					</p>
					<p>
						<label for="versionTramiteSubsanacion"><bean:message key="tramite.subsanacion.version"/></label>
						<html:text property="versionTramiteSubsanacion" styleClass="pc40" />
					</p>
				
					<p class="label">
						<bean:message key="tramite.subsanacion.parametros"/>
					</p>

					<div id="parametros"></div>
					<ul id="parametro">
						<li>
							<p>
								<label><bean:message key="tramite.subsanacion.parametros.codi"/></label>
								<html:text property="codigoParametroTramiteSubsanacion" styleId="codigoParametroTramiteSubsanacion"/>
								<label class="enLinia"><bean:message key="tramite.subsanacion.parametros.valor"/></label>
								<html:text property="valorParametroTramiteSubsanacion" styleId="valorParametroTramiteSubsanacion"/>
								<a id="afegirEnllas" onclick="afegirParametre();" class="enllas"><bean:message key="tramite.subsanacion.parametros.afegir"/></a>
							</p>
						</li>
					</ul>
					</html:form>
				<!-- escritorio_docs  -->
				<div id="escritorio_docs">
					<p class="titol">
						<bean:message key="aviso.documentoanexo"/>
					</p>
					<p class="boton">
						<input id="botonMostrarAnexar" type="button" value="<bean:message key='aviso.anexar.documento'/>" onclick="mostrarAnexarDocumentos();"/>
					</p>
					
					<div id="contenido_docs">
						
						<!--documentos--> 
						<div id="documentos">
						
							<logic:empty name="documentosAltaNotificacion" scope="session">
									<p class="noHay"><bean:message key="no.hay.documentos"/></p>
							</logic:empty>
								
							<logic:notEmpty name="documentosAltaNotificacion" scope="session">
								<ul>
									<logic:iterate id="document" name="documentosAltaNotificacion" type="es.caib.bantel.front.util.DocumentoFirmar" scope="session">
										<li>
											<bean:define id="documento" name="document" property="titulo" type="java.lang.String" />
											<bean:define id="tituloB64" name="document" property="tituloB64" type="java.lang.String" />
											<bean:define id="codigoRDS" name="document" property="codigoRDS" type="java.lang.Long" />
											<bean:define id="claveRDS" name="document" property="claveRDS" type="java.lang.String" />
												
											<a href='<%=urlAbrirDocumento%>?codigo=<%=codigoRDS %>&clave=<%=claveRDS %>' > 
												 <bean:write name="document" property="titulo" />
											</a>
											<logic:equal name="document" property="vistoPDF" value="true">
												<div id="infoFirmado-<%=codigoRDS %>"  style="display:inline;">
													<logic:equal name="document" property="firmar" value="false">															
														- <a class="firmar" onclick="mostrarFirmar('<%=tituloB64 %>','<%=codigoRDS %>','<%=claveRDS %>')">Firmar</a>
													</logic:equal>
													<logic:equal name="document" property="firmar" value="true">
														- <strong><bean:message key="detalleTramite.datosTramite.envio.firmado"/></strong>
													</logic:equal>
												</div>
											</logic:equal>
										</li>
									</logic:iterate>
								</ul>
							</logic:notEmpty>
						</div>
						 <!--/documentos -->
						
						 <!--anexar -->
						<div id="anexar">
								<html:form method="post" action="altaDocumentoNotificacion" enctype="multipart/form-data" target="iframeDocumento" styleClass="remarcar opcions">																			
								<html:hidden property="descripcionExpediente"/>
								<html:hidden property="flagValidacion" value="alta"/>
								<html:hidden property="rutaFitxer"/>								
								<html:hidden property="idiomaExp" />
							<p>
								<bean:message key="aviso.explicativo.fichero"/>
							</p>
							<p>
								<bean:message key="aviso.extensiones.fichero"/>
							</p>
							<p>
								<label><bean:message key="aviso.titulo"/></label>
								<html:text property="tituloAnexoOficio"/>
								<label class="enLinia"><bean:message key="aviso.fichero"/></label>
								<html:file property="documentoAnexoOficio" />

									<input id="botonAlta" class="botonAlta" type='button' value='<bean:message key="aviso.alta.documento"/>' onclick="if(altaDocument(this.form)){return true;}else{return false;}"/>
								, o <a id="botonCancelar" onclick="esconderAnexarDocumentos();">Cancelar</a>
							</p>
								</html:form>
						</div>
						 <!--/anexar -->
						
						 <!--firmar--> 
						<div id="firmarDocumentosApplet">
								<form name="formFirma">	
							<input type='hidden' id='documentoB64' name='documentoB64' value='' />
							<input type='hidden' id='firma' name='firma' value=''/>
							<input type='hidden' id='nombreFirmar' name='nombreFirmar' value=''/>
							<input type='hidden' id='codigoRDSFirmar' name='codigoRDSFirmar' value=''/>
							<input type='hidden' id='claveRDSFirmar' name='claveRDSFirmar' value=''/>		
							<div id="divNombreFirmar">
							</div>
							<!--anexar documentos -->
							<div id="anexarDocs">
								<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
								 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
									<p class="apartado">
										<bean:message key="firmarDocumento.aFirma.anexo.instrucciones"/>
									</p>
								</logic:equal>
								<logic:equal name="<%=es.caib.bantel.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
								value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">	
								<!--Instrucciones firma -->
									<p>		
										<bean:message key="firmarDocumento.instrucciones"/>	<bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo" />
									</p>
									<p>
										<label><bean:message key="firmarDocumento.certificadosDisponibles"/> </label>					
										<jsp:include page="/firma/caib/applet.jsp" flush="false"/>
										&nbsp;
										<input type="button" value="<bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo.boton" />" title="<bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo.boton" />" onclick="cargarCertificado();" style="vertical-align: top; margin-top: 4px;"/>
									</p>
									 <!--  PIN  --> 							
									<p>
										<label><bean:message key="firmarDocumento.PINCertificado" />: </label>
										<input type="password" name="PIN" id="PIN" class="txt"/>										
									</p>
								</logic:equal>
							</div>	
							<p>
								<label>&nbsp;</label>
								<input type="button" value="<bean:message key='aviso.firmar'/>" onclick="anexarDocumento(this.form);"/>, o <a onclick="botonCancelarFirmar();">Cancelar</a>
							</p>
								</form>
						</div>
						<!-- /firmar  --> 
					
					</div>
				
				</div>
				<!-- /escritorio_docs  --> 
				<p class="botonera">
					<html:submit onclick="if(alta()){return true;}else{return false;}"><bean:message key="notificacion.alta"/></html:submit>
					<input type="button" onclick="volver('<bean:write name="<%=es.caib.bantel.front.Constants.EXPEDIENTE_ACTUAL_IDENTIFICADOR_KEY%>" />','<bean:write name="<%=es.caib.bantel.front.Constants.EXPEDIENTE_ACTUAL_UNIDADADMIN_KEY%>"/>','<bean:write name="<%=es.caib.bantel.front.Constants.EXPEDIENTE_ACTUAL_CLAVE_KEY%>"/>')" value="<bean:message key="notificacion.cancelar"/>"/>
				</p>
			</div>
		</div>
		<!-- /continguts -->
		<div id="fondo"></div>
		<iframe id="iframeDocumento" name="iframeDocumento"></iframe>