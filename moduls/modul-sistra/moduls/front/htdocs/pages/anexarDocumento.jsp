<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/moduls/errorEnJsp.jsp"%>
<%@ page import="org.apache.struts.Globals"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<bean:define id="anexo" name="anexo" type="es.caib.sistra.model.DocumentoFront"/>
<html:xhtml/>
<bean:define id="listaFirmantes" name="listaFirmantes" type="java.lang.String"/>
<bean:define id="urlBorrarAnexo">
        <html:rewrite page="/protected/borrarAnexo.do" paramId="ID_INSTANCIA" paramName="ID_INSTANCIA"/>
</bean:define>
<script type="text/javascript">
<!--
	var mensajeUploadeando = '<bean:message key="anexarDocumentos.mensajeUpload"/>';
	var mensajeEnviando = '<bean:message key="anexarDocumentos.mensajeAnexar"/>';
	var mensajePreparando = '<bean:message key="anexar.documento.preparar"/>';
	<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="S">		
			<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
						 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">									
			
				<bean:define id="contentTypeFirma" name="anexo" type="java.lang.String" property="contentType" />
				
				var contentType = '<%= contentTypeFirma %>';
			
				function firmarCAIB(form){			
					var applet = whichApplet();
					var firma = '';	
					var pin = document.formFirma.PIN.value;
			
					applet.setPassword( pin );
					
					var contenidoFichero = $('#documentoFirmar').val();
					if ( contenidoFichero == '' )
					{
						ocultarCapaInfo();
						alert( "<bean:message key="firmarDocumento.introducirFichero"/>" );
						return false;
					}					

					// Si el tama�o pasa de 3Mb, hacemos split del fichero
					var splitSize = (3 * 1024 * 1024);
					var fileSize = $('#documentoFirmar').val().length;
					var splits = Math.floor(fileSize / splitSize);
					if (fileSize % splitSize > 0) {
						splits = splits + 1;
					}		
					
					
					if (splits == 1) {						
						firma = applet.firmarFicheroB64( $('#documentoFirmar').val(), contentType );											
					} else {
						applet.splitFicheroB64(fileSize);
						for (i = 1; i <= splits; i++) {
							var inicio = (i - 1) * splitSize;
							if (i < splits) {		
								applet.addSplitFicheroB64($('#documentoFirmar').val().substring(inicio, (inicio + splitSize)));
							} else {								
								applet.addSplitFicheroB64($('#documentoFirmar').val().substring(inicio));
							}
						}						
						firma = applet.firmarFicheroB64Split(contentType );							
					}	   
					
						
					if (firma == null || firma == ''){
						ocultarCapaInfo();
						alert(applet.getLastError());
						return false;
					}
					form.firma.value = firma;	
					return true;
				}
			</logic:equal>
			
			<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
						 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
					
				function prepararEntornoFirma(){
					MiniApplet.cargarMiniApplet(base);
				}
				
				function saveSignatureCallback(signatureB64) {
					if (signatureB64 == "AA==") {
						alert("<bean:message key="firma.miniapplet.appletinactivo" />");
						ocultarCapaInfo();
						showApplet(true);
						return;
					}
					
					firma = b64ToB64UrlSafe(signatureB64);
					
					formAfirma.firma.value = firma;
					
					ocultarCapaInfo();
					accediendoEnviando(mensajeEnviando);
					// Enviar formulario
					formAfirma.submit();
				}
				
				function showLogCallback(errorType, errorMessage) {
					error = 'Error: '+errorMessage;
					alert(error);
					console.log("Type: " + errorType + "\nMessage: " + errorMessage);
					ocultarCapaInfo();
					showApplet(true);
					return;
				}
			
				var formAfirma;
				function firmarAFirma(form){
					if (MiniApplet == undefined) { 
					          alert("No se ha podido instalar el entorno de firma");
					          return false;
					}
					formAfirma = form;
					var contenidoFichero = $('#documentoFirmar').val();
					if ( contenidoFichero == '' )
					{
						ocultarCapaInfo();
						alert( "<bean:message key="firmarDocumento.introducirFichero"/>" );
						return false;
					}
					
					// Pasamos de b64 urlSafe a b64
					var b64 = b64UrlSafeToB64($('#documentoFirmar').val());
			
					MiniApplet.sign(
								b64,
								sistra_ClienteaFirma_SignatureAlgorithm,
								sistra_ClienteaFirma_SignatureFormat,
								"",
								saveSignatureCallback,
								showLogCallback);
					
				}
				
				prepararEntornoFirma();
			</logic:equal>
	</logic:equal>	


	function showApplet(mostrar) {
		<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="S">
		<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
			 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">			 	
			 /*	 NO OCULTAMOS PQ EN FFOX SE CUAJA
			 if (mostrar) {
					$("#formFima").show();
				} else {
					$("#formFima").hide();
				}
			*/	
		</logic:equal>
	</logic:equal>
	}
	
	function uploadAnexo(form) {

		showApplet(false);	

		<logic:equal name="anexo" property="anexoGenerico" value="true">	
			form.descPersonalizada.value = document.anexarDocumentoForm.descPersonalizada.value;
			if 	(form.descPersonalizada.value == ''){
				ocultarCapaInfo();
				showApplet(true);
				alert( "<bean:message key="anexarDocumento.generico.descPersonalizada.nulo" />" );
				return;
			}			
		</logic:equal>


		// Verificamos que haya seleccionado fichero
		if 	(form.datos.value == ''){
			ocultarCapaInfo();
			showApplet(true);
			alert( "<bean:message key="anexarDocumentos.anexar.noFichero" />" );
			return;
		}		
		
		// Enviar formulario
		accediendoEnviando(mensajeUploadeando);
		form.submit();
			
	}
	
	function anexarDocumento(form)
	{
	
		<logic:equal name="anexo" property="anexoGenerico" value="true">			
			if 	(form.descPersonalizada.value==''){
				ocultarCapaInfo();
				showApplet(true);
				alert( "<bean:message key="anexarDocumento.generico.descPersonalizada.nulo" />" );
				return;
			}
		</logic:equal>	
	

		<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="S">		

			// Firmamos
			<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
						 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
				firmarAFirma(form);
				return;
				
			</logic:equal>
			<logic:equal name="implementacionFirma" value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">												
				if (!firmarCAIB(form)) {
					ocultarCapaInfo();
					showApplet(true);
					return;
				}					
			</logic:equal>					
		</logic:equal>	
				
		ocultarCapaInfo();
		accediendoEnviando(mensajeEnviando);

		// Enviar formulario
		form.submit();
	}
	
	function fileUploaded(idInstancia, identificador, instancia){
		var url_json = '<html:rewrite page="/protected/downloadAnexo.do"/>';

		
		<logic:notEqual name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="N">
		// Documento a firmar: tras upload, descargamos de nuevo el documento para firmarlo
		accediendoEnviando(mensajePreparando);
		var data = { ID_INSTANCIA: idInstancia, identificador: identificador, instancia: instancia };
		$.postJSON(
			url_json,
			data,
			function(datos){
				if (datos.error==""){								
					$('#documentoFirmar').val(datos.documento);
					anexarDocumento(document.anexarDocumentoForm);
				}else{
					var mensajeErrorUpload = '<bean:message key="anexar.documento.null"/>';
					alert(mensajeErrorUpload);
					ocultarCapaInfo();
				}
			}
		);
		</logic:notEqual>

		<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="N">
		// Documento sin firmar: tras upload, proseguimos con el anexado
		anexarDocumento(document.anexarDocumentoForm);
		</logic:equal>
	}
	
	function errorFileUploaded(error){
		alert(error);
		ocultarCapaInfo();		
	}

	function mostrarPin() {		
		$('#PinDiv').show();
	}
	
	$(document).ready(function(){
		$.postJSON = function(url, data, callback) {
        	return jQuery.ajax({
		        'type': 'POST',
		        'url': url,
		        'data': data,
		        'dataType': 'json',
		        'success': callback
		    });
		};
		        
		}
	);
//-->
</script>

				<h2><bean:message key="anexarDocumentos.anexarDocumento"/> <bean:write name="anexo" property="descripcion" /></h2>
				
				<!--  Informacion documento -->
				<div>
					<bean:write name="anexo" property="informacion" filter="false" />					
				</div>
				<!--  <div class="ultimo"></div>  -->
				
				<!-- descargar plantilla  -->
				<logic:notEmpty name="anexo" property="anexoPlantilla">	
					<h2 class="descargarPlantilla">- <bean:message key="anexarDocumentos.descargarPlantilla"/></h2>
					<p class="apartado"><bean:message key="anexarDocumentos.descargarPlantilla.instrucciones" /></p>
					<div id="listadoPlantillas">
						<div class="iconos">
						<!-- 
						<logic:equal name="anexo" property="obligatorio" value='S'><img src="imgs/tramitacion/iconos/doc_obligatorio.gif" alt="Documento obligatorio" title="Documento obligatorio" /></logic:equal><logic:equal name="anexo" property="obligatorio" value='N'><img src="imgs/tramitacion/iconos/doc_opcional.gif" alt="Documento opcional" title="Documento opcional" /></logic:equal><logic:equal name="anexo" property="anexoCompulsar" value="true"><img src="imgs/tramitacion/iconos/doc_compulsado.gif" alt="Documento compulsado" title="Documento compulsado"/></logic:equal> 
						-->
						<img src="imgs/tramitacion/iconos/plantilla.gif" alt="<bean:message key="anexarDocumentos.descargarPlantilla.plantillaDocumento"/>" title="Plantilla del documento" /></div>
						<div class="enlaceDescargar">
							<a id="doc1" href="<%= anexo.getAnexoPlantilla() %>" target="_blank"><bean:message key="anexarDocumentos.descargarPlantilla.instrucciones.descargarPlantilla"/></a>
						</div>
					</div>
					<!-- <div class="ultimo"></div>  -->
				</logic:notEmpty>

	
				<!-- firma documento -->
				<logic:equal name="anexo" property="firmar" value="true">
					<h2 class="firmarAnexo">- <bean:message key="firmarDocumento.firmar"/></h2>
					
					<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="S">
					<!-- anexar documentos -->
					<div id="anexarDocs">														
						<!--  Instrucciones firma -->
						<p class="apartado">								
								<logic:notEmpty name="anexo" property="firmante">
									<bean:message key="firmarDocumento.instrucciones.firmarOtro" arg0="<%=anexo.getFirmante()%>"/>
								</logic:notEmpty>
								<logic:empty name="anexo" property="firmante">
									<bean:message key="firmarDocumento.instrucciones"/>
								</logic:empty>									
						</p>						
						<!--  Instrucciones firma y Applet firma (depende de implementacion firma) -->
						<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
									 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_AFIRMA%>">
							<p class="apartado">
								<bean:message key="firmarDocumento.aFirma.anexo.instrucciones"/>
							</p>
						</logic:equal>
						<logic:equal name="<%=es.caib.sistra.front.Constants.IMPLEMENTACION_FIRMA_KEY%>"
									 value="<%=es.caib.sistra.plugins.firma.PluginFirmaIntf.PROVEEDOR_CAIB%>">									
							<p class="apartado"><bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo" /></p>
							<p class="apartado"><input type="button" value="<bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo.boton" />" title="<bean:message key="firmarDocumento.certificado.instrucciones.iniciarDispositivo.boton" />" onclick="cargarCertificado();" /></p>
							<p class="apartado">
								<bean:message key="firmarDocumento.certificadosDisponibles"/>
							</p>
							<div id="formFirmaDiv">
							<form name="formFirma" id="formFima">		
								<p class="apartado"> 									
									<jsp:include page="/firma/caib/applet.jsp" flush="false"/>	
								</p>												
								<!--  PIN  -->
								<p class="notaPie">	
									<bean:message key="firmarDocumento.requierePINCertificado.inicio"/>	<a href="javascript:mostrarPin()"><bean:message key="firmarDocumento.requierePINCertificado.fin"/></a>								
								</p>
								<div id="PinDiv">					
								<p class="apartado">
									<bean:message key="firmarDocumento.PINCertificado" /><input type="password" name="PIN" id="PIN" class="txt"/>										
								</p>
								</div>							
							</form>	
							</div>
						</logic:equal>
					</div>	
					</logic:equal>
					
					<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="D">
						<div id="anexarDocs">														
							<!--  Instrucciones firma -->
							<p class="apartado">
								<bean:message key="firmarDocumento.instrucciones.firmarOtros" arg0="<%=listaFirmantes%>" />								
								<br/>
								<bean:message key="firmarDocumento.instrucciones.firmaDelegada" />	
							</p>							
						</div>
					</logic:equal>
					
				</logic:equal>
				
				
				<!-- anexar documentos -->
				<h2 class="adjuntarAnexo">- <bean:message key="anexarDocumentos.anexar"/></h2>
				<!-- anexar documentos -->
				<div id="anexarDocs">								
					<!--  Anexar documento telematicamente -->
					<logic:equal name="anexo" property="anexoPresentarTelematicamente" value="true">
						<iframe id="iframeUpload" name="iframeUpload"></iframe>
						<html:form method="post" action="/protected/anexarDocumento" enctype="multipart/form-data">																			
							<logic:equal name="anexo" property="anexoGenerico" value="true">
								<p class="apartado">
									<bean:message key="anexarDocumentos.anexar.instrucciones.parrafoGenericos"/>
									<br/>								
									<html:text property="descPersonalizada" size="70" maxlength="200"/>
								</p>
							</logic:equal>						
							<p class="apartado">	
								<!--  Instrucciones anexo -->
								<bean:message key="anexarDocumentos.anexar.instrucciones.parrafo1"/>
								<br/>
								<input type='hidden' id='documentoFirmar' name='documentoFirmar' value='' />
								<html:hidden name="irAAnexarForm" property="ID_INSTANCIA"/>
								<html:hidden name="irAAnexarForm" property="instancia" />	
								<html:hidden name="irAAnexarForm" property="identificador" />
								<html:hidden property="firma" />
								<html:hidden property="extensiones" value="<%=anexo.getAnexoExtensiones()%>" />
								<html:hidden property="tamanyoMaximo"  value="<%=Integer.toString(anexo.getAnexoTamanyo())%>" />																					
								<logic:equal name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="D">	
									<input type="hidden" id="firmaDelegada" name="firmaDelegada" value="S" />
								</logic:equal>	
								<logic:notEqual name="<%=es.caib.sistra.front.Constants.MOSTRAR_FIRMA_DIGITAL%>" value="D">	
									<input type="hidden" id="firmaDelegada" name="firmaDelegada" value="N" />
								</logic:notEqual>	
							</p>
						</html:form>
						<html:form method="post" action="/protected/uploadAnexo" enctype="multipart/form-data" target="iframeUpload">																			
							<p class="apartado">
								<html:hidden name="irAAnexarForm" property="ID_INSTANCIA"/>
								<html:hidden name="irAAnexarForm" property="instancia" />	
								<html:hidden name="irAAnexarForm" property="identificador" />
								<html:hidden property="extensiones" value="<%=anexo.getAnexoExtensiones()%>" />
								<html:hidden property="tamanyoMaximo"  value="<%=Integer.toString(anexo.getAnexoTamanyo())%>" />
								<html:hidden property="descPersonalizada"/>																					
								<html:file property="datos" styleId="datos" size="70"/> 						
								<input name="anexarDocsBoton" id="anexarDocsBoton" type="button" value="<bean:message key="anexarDocumentos.anexar.boton"/>" onclick="uploadAnexo(this.form)"/>
							</p>
						</html:form>
						<!--  alerta tamanyos -->
						<p class="alerta">
							<bean:message key="anexarDocumentos.anexar.instrucciones.parrafo2.texto1"/> <strong><bean:write name="anexo" property="anexoExtensiones"/></strong> <bean:message key="anexarDocumentos.anexar.instrucciones.parrafo2.texto2"/> <strong><bean:write name="anexo" property="anexoTamanyo"/> Kb</strong>.
						</p>
							
						<logic:equal name="anexo" property="anexoCompulsar" value="true">				
							<p class="apartado"><bean:message key="anexarDocumentos.anexar.instrucciones.telematico.compulsar"/></p>									
						</logic:equal>
					</logic:equal>	
					
														
					<!--  Anexar documento presencialmente -->					
					<logic:equal name="anexo" property="anexoPresentarTelematicamente" value="false">												
						<logic:equal name="anexo" property="anexoFotocopia" value="true">				
							<logic:equal name="anexo" property="anexoCompulsar" value="true">				
								<p class="apartado"><bean:message key="anexarDocumentos.anexar.instrucciones.presencial.fotocopia.compulsar"/></p>																			
							</logic:equal>
							<logic:equal name="anexo" property="anexoCompulsar" value="false">				
								<p class="apartado"><bean:message key="anexarDocumentos.anexar.instrucciones.presencial.fotocopia"/></p>									
							</logic:equal>
						</logic:equal>
						<logic:equal name="anexo" property="anexoFotocopia" value="false">				
							<p class="apartado"><bean:message key="anexarDocumentos.anexar.instrucciones.presencial.original"/></p>																			
						</logic:equal>		
						<!--  Boton Presentar documento para documentos no telematico -->
						<!--  Solamente se mostrar� para documentos: 
									* obligatorios y gen�ricos
									* opcionales
						-->
						<% if (  (anexo.getObligatorio() == 'S' && anexo.isAnexoGenerico() ) ||
								 (anexo.getObligatorio() == 'N') ){ 
						%>																								
								<p class="apartado"><bean:message key="anexarDocumentos.anexar.instrucciones.presencial"/></p>
								<html:form action="/protected/anexarDocumento">
									<!--  Descripci�n personalizada si es gen�rico -->
									<logic:equal name="anexo" property="anexoGenerico" value="true">
										<p class="apartado">
											<bean:message key="anexarDocumentos.anexar.instrucciones.parrafoGenericos"/>
											<br/>								
											<html:text property="descPersonalizada" size="70" maxlength="200"/>
										</p>	
									</logic:equal>
									<p class="apartado">
										<html:hidden name="irAAnexarForm" property="ID_INSTANCIA"/>
										<html:hidden name="irAAnexarForm" property="instancia" />	
										<html:hidden name="irAAnexarForm" property="identificador" />							
										<input name="anexarDocsBoton" id="anexarDocsBoton" type="button" value="<bean:message key="anexarDocumentos.marcarPresentar"/>" onclick="javascript:anexarDocumento(this.form);"/>
									</p>
								</html:form>	
						<% } %>
						
					</logic:equal>
					
					<!--  Enlace volver  -->
					<p class="volver"><html:link action="/protected/irAPaso" paramId="ID_INSTANCIA" paramName="ID_INSTANCIA"><bean:message key="anexarDocumentos.anexar.instrucciones.volverListadoDocumentos"/></html:link></p>					
				</div>
				<div class="sep"></div>
				<!-- capa accediendo formularios -->
				<div id="capaInfoFondo"></div>
				<div id="capaInfoForms"></div>