<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ page import="es.caib.zonaper.modelInterfaz.ConstantesZPE"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<bean:define id="sesion" name="<%=es.caib.zonaper.front.Constants.DATOS_SESION_KEY%>" type="es.caib.zonaper.model.DatosSesion" />
<bean:define id="firstPage" value="0" />
		<!-- informacio -->		
		<div id="info">

			<!-- titol -->
			<h1>
				<bean:message key="actualizarDatosPersonales.titulo"/>
			</h1>
			<!-- /titol -->
			
			<p><bean:message key="actualizarDatosPersonales.instrucciones"/></p>
		
			<!--  errores -->
			<html:errors />			
			
			<!--  formulario -->
			<html:form action="/protected/actualizarDatosPersonales" styleId="formConfirmacion">
				
				<p>	
						<logic:equal name="actualizarDatosPersonalesForm" property="tipoPersona" value="NIF">
							<span class="etiqueta"><bean:message key="actualizarDatosPersonales.nif"/></span>
						</logic:equal>
						<logic:equal name="actualizarDatosPersonalesForm" property="tipoPersona" value="CIF">
							<span class="etiqueta"><bean:message key="actualizarDatosPersonales.cif"/></span>
						</logic:equal>
						<bean:write name="actualizarDatosPersonalesForm" property="nif"/>
				</p>
				<p>
					<label for="nombre">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.nombre"/></span>
						<html:text property="nombre" styleId="nombre" maxlength="50" size="20"/>						
					</label>
				</p>
				<logic:equal name="actualizarDatosPersonalesForm" property="tipoPersona" value="NIF">
				<p>
					<label for="apellido1">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.apellido1"/></span>
						<html:text property="apellido1" styleId="apellido1" maxlength="50" size="20"/>
					</label>
				</p>
				
				<p>
					<label for="apellido2">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.apellido2"/></span>
						<html:text property="apellido2" styleId="apellido2" maxlength="50" size="20"/>
					</label>
				</p>
				</logic:equal>
				<p>
					<label for="direccion">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.direccion"/></span>
						<html:text property="direccion" styleId="direccion" maxlength="200" size="50"/>
					</label>
				</p>
				
				<p>
					<label for="codigoPostal">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.codigoPostal"/></span>
						<html:text property="codigoPostal" styleId="codigoPostal" maxlength="5" size="5"/>
					</label>
				</p>
				<p>
					<label for="provincia">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.provincia"/></span>
						<html:select property="provincia" styleId="provincia" onchange="javascript:llenarMunicipios();">
							<logic:iterate id="provincia" name="provincias">	
								<html:option value="<%=((es.caib.zonaper.model.ValorDominio)provincia).getCodigo()%>" ><bean:write name="provincia" property="descripcion"/></html:option>
							</logic:iterate>
						</html:select>
					</label>
				</p>
				<p>
					<label for="municipio">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.municipio"/></span>
						<html:select property="municipio" styleId="municipio">
							<logic:present name="municipios">
								<logic:iterate id="municipio" name="municipios">	
									<html:option value="<%=((es.caib.zonaper.model.ValorDominio)municipio).getCodigo().toString()%>"><bean:write name="municipio" property="descripcion"/></html:option>
								</logic:iterate>
							</logic:present>
						</html:select>
					</label>
				</p>
				
				<p>
					<label for="telefonoFijo">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.telefonoFijo"/></span>
						<html:text property="telefonoFijo" styleId="telefonoFijo" maxlength="10" size="10"/>					
					</label>
				</p>
				
				<p>
					<label for="telefonoMovil">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.telefonoMovil"/></span>						
						<html:text property="telefonoMovil" styleId="telefonoMovil" maxlength="10" size="10"/>
					</label>
				</p>
				
				<p>
					<label for="email">
						<span class="etiqueta"><bean:message key="actualizarDatosPersonales.email"/></span>
						<html:text property="email" styleId="email" maxlength="50" size="50"/>
					</label>
				</p>
				
				
				<logic:equal name="es.caib.zonaper.front.DATOS_SESION" property="perfilAcceso" scope="session" value="<%=ConstantesZPE.DELEGACION_PERFIL_ACCESO_CIUDADANO%>">	
				<div class="botonera">
					<button type="submit"><bean:message key="actualizarDatosPersonales.guardar"/></button>
				</div>
				</logic:equal>
				
				<logic:equal name="es.caib.zonaper.front.DATOS_SESION" property="perfilAcceso" scope="session" value="<%=ConstantesZPE.DELEGACION_PERFIL_ACCESO_DELEGADO%>">		
					<p class="alerta">
						<bean:message key="actualizarDatosPersonales.noGuardarDelegado" />
					</p>
				</logic:equal>				
					
			</html:form>
			
			<br/>
			
			<!-- 
			<div id="notaLegalPie"/>
				<p>
				<bean:message key="actualizarDatosPersonales.lopd"/> 
				</p>
			</div>				    
			 -->	
		</div>
		
		<script type="text/javascript">
			function llenarMunicipios(){
				codProv = $("#provincia").val();						
				$.ajaxSetup({
				         scriptCharset: "utf-8" ,
				         contentType: "application/json; charset=utf-8"});
				$.getJSON("listarMunicipiosJSON.do", { provincia: codProv }, function(json){
  							fillMunicipios(json);
 				});
			}
			
			function fillMunicipios(locs){
				$("#municipio").removeOption(/./);
				$("#municipio").removeOption(""); 
				$("#municipio").addOption(locs, false); 				
			}
		</script>