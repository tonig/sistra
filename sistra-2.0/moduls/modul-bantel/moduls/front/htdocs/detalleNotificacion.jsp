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
		document.location='<html:rewrite page="/recuperarExpediente.do?identificadorExp='+identificadorExp+'&unidadAdm='+unidadAdm+'&claveExp='+claveExp+'" />';		
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
					<dt><bean:message key="detalle.notificacion.fechaEmision"/>:</dt>
					<dd><bean:write name="notificacion" property="fecha" format="dd/MM/yyyy '-' HH:mm"/></dd>
					
					<dt><bean:message key="detalle.notificacion.acuseRecibo"/>:</dt>
					<dd>
						<logic:equal  name="notificacion" property="requiereAcuse" value="true">
							Si
						</logic:equal> 
						<logic:equal  name="notificacion" property="requiereAcuse" value="false">
							No
						</logic:equal>
					</dd>
					
					<logic:equal  name="notificacion" property="requiereAcuse" value="true">
						<logic:notEmpty name="notificacion" property="detalleAcuseRecibo.fechaFinPlazo">
							<dt><bean:message key="detalle.notificacion.finPlazo"/>:</dt>						
							<dd><bean:write name="notificacion" property="detalleAcuseRecibo.fechaFinPlazo" format="dd/MM/yyyy"/></dd>
						</logic:notEmpty>
					</logic:equal> 
					
					<dt><bean:message key="detalle.notificacion.estado"/>:</dt>
					<logic:equal name="notificacion" property="detalleAcuseRecibo.estado" value="PENDIENTE">
						<dd><bean:message key="detalle.notificacion.estado.pendiente"/></dd>
					</logic:equal>
					<logic:equal name="notificacion" property="detalleAcuseRecibo.estado" value="ENTREGADA">
						<dd><bean:message key="detalle.notificacion.estado.entregada"/></dd>
					</logic:equal>
					<logic:equal name="notificacion" property="detalleAcuseRecibo.estado" value="RECHAZADA">
						<dd><bean:message key="detalle.notificacion.estado.rechazada"/></dd>
					</logic:equal>
					
					<logic:equal name="notificacion" property="detalleAcuseRecibo.estado" value="ENTREGADA">
						<dt><bean:message key="detalle.notificacion.fechaApertura"/>:</dt>
						<dd><bean:write name="notificacion" property="detalleAcuseRecibo.fechaAcuseRecibo" format="dd/MM/yyyy '-' HH:mm"/><logic:equal name="notificacion" property="requiereAcuse" value="true"> </logic:equal></dd>
					</logic:equal>
					
					<dt><bean:message key="detalle.notificacion.asunto"/>:</dt>
					<dd><bean:write name="notificacion" property="tituloOficio"/></dd>
					
					<dt><bean:message key="detalle.notificacion.descripcion"/>:</dt>
					<dd><bean:write name="notificacion" property="textoOficio"/></dd>
					
					<logic:notEmpty name="notificacion" property="detalleAcuseRecibo.avisos">		
						<dt><bean:message key="detalle.notificacion.avisos" />:</dt>
						<dd>
							<ul class="docs">
								<logic:iterate id="aviso" name="notificacion" property="detalleAcuseRecibo.avisos" type="es.caib.zonaper.modelInterfaz.DetalleAviso">
								<bean:define id="enviado" type="java.lang.String"><bean:write name="aviso" property="enviado" /></bean:define>
								<li>
									<bean:write name="aviso" property="tipo" /> - 
									<bean:write name="aviso" property="destinatario" /> - 
									<logic:equal  name="enviado" value="true">
									  <bean:message key="detalle.notificacion.avisoEnviado" />  
									</logic:equal>
									<logic:equal  name="enviado" value="false">
									  <bean:message key="detalle.notificacion.avisoNoEnviado" />  
									</logic:equal>
									<logic:equal  name="aviso"  property="confirmadoEnvio" value="CONFIRMADO_ENVIADO">
									  [  <bean:message key="detalle.notificacion.avisoConfirmado.OK" /> ]  
									</logic:equal>	
									<logic:equal  name="aviso"  property="confirmadoEnvio" value="CONFIRMADO_NO_ENVIADO">
									  [  <bean:message key="detalle.notificacion.avisoConfirmado.KO" /> ]  
									</logic:equal>								
								</li>
								</logic:iterate>
							</ul>
						</dd>				
					</logic:notEmpty>
												
					<logic:notEmpty name="notificacion" property="documentos">		
						<dt><bean:message key="detalle.notificacion.documentoanexo" />:</dt>
						<dd>
							<ul class="docs">
								<logic:iterate id="documento" name="notificacion" property="documentos" type="es.caib.zonaper.modelInterfaz.DocumentoExpedientePAD">
								<li>
									<bean:define id="codigoFirma" type="java.lang.String">
										<bean:write name="documento" property="codigoRDS" />
									</bean:define>
								
									<logic:notEmpty name="<%=\"URL-\" + codigoFirma %>" scope="request">
										<a href="<bean:write name="<%=\"URL-\" + codigoFirma %>" scope="request"/>" target="_blank">
											<bean:write name="documento" property="titulo" />
										</a>														
									</logic:notEmpty>
									
									<logic:empty name="<%=\"URL-\" + codigoFirma %>" scope="request">
										<a href='<%=url%>?codigo=<%=documento.getCodigoRDS() %>&clave=<%=documento.getClaveRDS() %>&idioma=<%=expediente.getIdioma() %>'> 
											<bean:write name="documento" property="titulo" />
										</a>
									</logic:empty>
									
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
				<a href="#" onclick="javascript:volver('<%=expediente.getIdentificadorExpediente()%>','<%=expediente.getUnidadAdministrativa()%>','<%=expediente.getClaveExpediente()%>')">
					<bean:message key="detalle.aviso.tornar" />				
				</a>					
			</div>
			<!-- /tornar enrere -->
			
		</div>
		<!-- /continguts -->
	