<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ page import="org.apache.struts.Globals" %>
<%@ page import="es.caib.util.StringUtil"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<script type="text/javascript" src="js/jquery.selectboxes.pack.js"></script>
<script type="text/javascript">
	function volver(identificadorExp,unidadAdm,claveExp){
		document.forms["0"].action='<html:rewrite page="/recuperarExpediente.do?identificadorExp='+identificadorExp+'&unidadAdm='+unidadAdm+'&claveExp='+claveExp+'" />';
		document.forms["0"].submit();
	}
</script>
<bean:define id="notificacion" name="elemento" type="es.caib.zonaper.modelInterfaz.NotificacionExpedientePAD" />
<bean:define id="expediente" name="expediente" type="es.caib.zonaper.modelInterfaz.ExpedientePAD" />
<bean:define id="url"  type="java.lang.String" >
<html:rewrite page="/abrirDocumento.do"/>
</bean:define>

		<!-- continguts -->
		<div class="continguts">
			<p class="titol"><bean:message key="detalle.notificacion.detalle" /></p>
			<div class="avis">
			
				<dl>
					<dt><bean:message key="detalle.aviso.fechaEmision"/>:</dt>
					<dd><bean:write name="notificacion" property="fecha" format="dd/MM/yyyy '-' HH:mm"/></dd>
					<dt><bean:message key="detalle.notificacion.fechaApertura"/>:</dt>
					<dd><bean:write name="notificacion" property="fechaFirmaAcuse" format="dd/MM/yyyy '-' HH:mm"/><logic:equal name="notificacion" property="requiereAcuse" value="true"> *</logic:equal></dd>
					<dt><bean:message key="detalle.aviso.asunto"/>:</dt>
					<dd><bean:write name="notificacion" property="tituloOficio"/></dd>
					<dt><bean:message key="expediente.descripcion"/>:</dt>
					<dd><bean:write name="notificacion" property="textoOficio"/></dd>	
					<logic:notEmpty name="notificacion" property="documentos">		
						<dt><bean:message key="aviso.documentoanexo" />:</dt>
						<dd>
							<ul class="docs">
								<logic:iterate id="documento" name="notificacion" property="documentos" type="es.caib.zonaper.modelInterfaz.DocumentoExpedientePAD">
								<li>
									<a href='<%=url%>?codigo=<%=documento.getCodigoRDS() %>&clave=<%=documento.getClaveRDS() %>&idioma=<%=expediente.getIdioma() %>'> <bean:write name="documento" property="titulo" /></a>
									<bean:define id="codigoFirma" type="java.lang.String">
										<bean:write name="documento" property="codigoRDS" /><bean:write name="documento" property="claveRDS" />
									</bean:define>
									<logic:notEmpty name="<%=codigoFirma %>" scope="request">
										<bean:message key="comprobarDocumento.firmadoPor"/>
										<logic:iterate name="<%=codigoFirma %>" id="firma" scope="request">							
											&nbsp;<bean:write name="firma" property="nombreApellidos"/>  										
										</logic:iterate>			
									</logic:notEmpty>	
								</li>
								</logic:iterate>
							</ul>
						</dd>				
					</logic:notEmpty>
				</dl>
			
			</div>
			

			<!-- tornar enrere -->
			<div id="enrere">
				<html:form style="background-color:white" action="recuperarExpediente" >
				<a href="#" onclick="javascript:volver('<%=expediente.getIdentificadorExpediente()%>','<%=expediente.getUnidadAdministrativa()%>','<%=expediente.getClaveExpediente()%>')">
					<bean:message key="detalle.aviso.tornar" />				
				</a>	
				</html:form>
			</div>
			<!-- /tornar enrere -->
			
		</div>
		<!-- /continguts -->
	