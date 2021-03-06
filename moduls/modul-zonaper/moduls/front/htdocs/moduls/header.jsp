<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ page import="es.caib.zonaper.modelInterfaz.ConstantesZPE"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>

	<bean:define id="lang" value="<%=((java.util.Locale) session.getAttribute(org.apache.struts.Globals.LOCALE_KEY)).getLanguage()%>" type="java.lang.String"/>
	<bean:define id="urlPortal"  type="java.lang.String">
		<bean:write name="<%=es.caib.zonaper.front.Constants.ORGANISMO_INFO_KEY%>" property="urlPortal" />
	</bean:define>
	<bean:define id="tituloPortal"  type="java.lang.String">
		<bean:write name="<%=es.caib.zonaper.front.Constants.ORGANISMO_INFO_KEY%>" property='<%="tituloPortal("+ lang +")"%>'/>
	</bean:define>
	
<logic:equal name="<%=es.caib.zonaper.front.Constants.MOSTRAR_EN_IFRAME%>" value="false">

		<!-- logo illes balears -->
		<div id="cap">
		<html:link href="<%=urlPortal%>" paramId="lang" paramName="lang" accesskey="0" >
			<img id="logoCAIB" class="logo" src="<bean:write name="<%=es.caib.zonaper.front.Constants.ORGANISMO_INFO_KEY%>" property="urlLogo" />" alt="Logo <bean:write name="<%=es.caib.zonaper.front.Constants.ORGANISMO_INFO_KEY%>" property="nombre" />" />
		</html:link>
		</div>
</logic:equal>
		<!-- molla pa -->
		<tiles:insert name=".enlacesNavegacion"/>
		<!-- /molla pa -->
		
		<!-- titol aplicacio -->
		
		<!-- usuari -->
		<div id="dadesUsuari">
		<logic:present name="es.caib.zonaper.front.DATOS_SESION" scope="session">
			<logic:notEqual name="es.caib.zonaper.front.DATOS_SESION" property="nivelAutenticacion" scope="session" value="A">				
				<bean:define id="usuario">
					<bean:write name="es.caib.zonaper.front.DATOS_SESION" property="nombreUsuario" scope="session"/>
				</bean:define>
				<p id="titolAplicacio">
					<bean:write name="tituloPortal"/>, 
					
					<span>
						<logic:equal name="es.caib.zonaper.front.DATOS_SESION" property="perfilAcceso" scope="session" value="<%=ConstantesZPE.DELEGACION_PERFIL_ACCESO_DELEGADO%>">	
							<bean:define id="nombreEntidad">	
								<bean:write name="es.caib.zonaper.front.DATOS_SESION" property="entidadPAD.nombreCompleto"/>				
							</bean:define>
							<bean:message key="head.miPortal.autenticado" arg0="<%=nombreEntidad%>"/> - 
							<bean:message key="head.miPortal.accesoDelegado" arg0="<%=usuario%>"/>
						</logic:equal>			
						<logic:equal name="es.caib.zonaper.front.DATOS_SESION" property="perfilAcceso" scope="session" value="<%=ConstantesZPE.DELEGACION_PERFIL_ACCESO_CIUDADANO%>">	
							<bean:message key="head.miPortal.autenticado" arg0="<%=usuario%>"/>
						</logic:equal>					
					</span>
		
					
					
				</p>
				
			</logic:notEqual>
					
			<logic:equal name="es.caib.zonaper.front.DATOS_SESION" property="nivelAutenticacion" scope="session" value="A">								
				<p id="titolAplicacio"><bean:write name="tituloPortal"/>: <span><bean:message key="head.miPortal.anonimo"/></span></p>
			</logic:equal>
			
		</logic:present>
		</div>
