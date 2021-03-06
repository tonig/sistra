<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>

<script type="text/javascript">
<!--
function limpiarFiltro()
    {
    	var form = document.getElementById("formFiltro");
    	var filtro = document.getElementById("filtro");
    	filtro.value = "";
        form.submit();
	}
-->
</script>

<bean:define id="sesion" name="<%=es.caib.zonaper.front.Constants.DATOS_SESION_KEY%>" type="es.caib.zonaper.model.DatosSesion" />
<bean:define id="firstPage" value="0" />
		<!-- informacio -->
		<h1><bean:message key="estadoExpedientes.titulo" /></h1>
		<div id="info">
			<p><bean:message key="estadoExpedientes.encabezado.parrafo1.texto" /></p>
			
			<logic:empty name="page" property="list">
				<logic:empty name="filtro">
					<p class="alerta">
						<bean:message key="estadoExpedientes.noExisten" />
					</p>
				</logic:empty>
				<logic:notEmpty name="filtro">
					<p>
						<html:form styleId="formFiltro" action="/protected/filtrarExpedientes">
							<html:text property="filtro" styleId="filtro"/> 
							<html:submit><bean:message key="estadoExpedientes.filtro.buscar" /></html:submit> 
							<a id="verTodo" href="#" onclick="javascript:limpiarFiltro();"><bean:message key="estadoExpedientes.filtro.eliminar" /></a>
						</html:form>
					</p>
					<p class="alerta">
						<bean:message key="estadoExpedientes.filtro.noExisten" />
					</p>					
				</logic:notEmpty>
			</logic:empty>
			
			<logic:notEmpty name="page" property="list" >
				<p><bean:message key="estadoExpedientes.encabezado.parrafo2.texto" /></p>
				<p>
					<html:form styleId="formFiltro" action="/protected/filtrarExpedientes">
						<html:text property="filtro"  styleId="filtro"/> 
						<html:submit><bean:message key="estadoExpedientes.filtro.buscar" /></html:submit>
						<logic:notEmpty name="filtro">
						<a id="verTodo" href="#" onclick="javascript:limpiarFiltro();"><bean:message key="estadoExpedientes.filtro.eliminar" /></a>
						</logic:notEmpty>
					</html:form>
				</p>
				<table class="llistatElements">
				<thead>
						<tr>
							<th><bean:message key="estadoExpedientes.tabla.tramite" /></th>
							<th><bean:message key="estadoExpedientes.tabla.idioma" /></th>
							<th><bean:message key="estadoExpedientes.tabla.estado" /></th>
							<th><bean:message key="estadoExpedientes.tabla.fechaActualizacion" /></th>
							<th><bean:message key="estadoExpedientes.tabla.fechaInicio" /></th>
						<!-- 
							<th><bean:message key="estadoExpedientes.tabla.codigoExpediente" /></th>
						 -->
						</tr>
				</thead>
				
				
				<logic:iterate id="tramiteCompletado" name="page" property="list" type="es.caib.zonaper.model.Expediente">	
			
					<bean:define id="urlMostrarEstadoExpediente" type="java.lang.String">
						<html:rewrite page="/protected/mostrarDetalleExpediente.do" paramId="id" paramName="tramiteCompletado" paramProperty="codigo"/>				
					</bean:define>
					 
					<tr 
						<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_SOLICITUD_ENVIADA_PENDIENTE_DOCUMENTACION_PRESENCIAL%>">
						class="novetat"
						</logic:equal> 
						<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_AVISO_PENDIENTE%>">
						class="novetat"
						</logic:equal> 
						<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_NOTIFICACION_PENDIENTE%>">
						class="novetat"
						</logic:equal>
						<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_NOTIFICACION_RECHAZADA%>">
						class="novetat"
						</logic:equal>
					>
					
						<!--  Descripcion -->
						<td>  
							<html:link href="<%=urlMostrarEstadoExpediente%>">
								<bean:write name="tramiteCompletado" property="descripcion" />
							</html:link>
						</td>
						
						<!--  Idioma -->
						<td>  
							<logic:notEmpty name="tramiteCompletado" property="idioma">
								<bean:message key="<%=\"estadoExpedientes.idioma.\" + tramiteCompletado.getIdioma()%>"/>
							</logic:notEmpty>
						</td>
						
						<!--  Estado -->
						<td class="estat">
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_SOLICITUD_ENVIADA%>">
								<bean:message key="estadoExpedientes.estado.solicitudEnviada"/>	
							</logic:equal>
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_SOLICITUD_ENVIADA_PENDIENTE_DOCUMENTACION_PRESENCIAL%>">
								<bean:message key="estadoExpedientes.estado.solicitudEnviadaPendienteDocumentacionPresencial"/>	
							</logic:equal>
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_AVISO_PENDIENTE%>">
								<bean:message key="estadoExpedientes.estado.avisoPendiente"/>
							</logic:equal>
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_AVISO_RECIBIDO%>">
								<bean:message key="estadoExpedientes.estado.avisoRecibido"/>
							</logic:equal>
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_NOTIFICACION_PENDIENTE%>">
								<bean:message key="estadoExpedientes.estado.notificacionPendiente"/>
							</logic:equal>
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_NOTIFICACION_RECIBIDA%>">
								<bean:message key="estadoExpedientes.estado.notificacionRecibida"/>
							</logic:equal>				
							<logic:equal name="tramiteCompletado" property="estado" value="<%=es.caib.zonaper.modelInterfaz.ConstantesZPE.ESTADO_NOTIFICACION_RECHAZADA%>">
								<bean:message key="estadoExpedientes.estado.notificacionRechazada"/>
							</logic:equal>
						</td>
									
						<!--  Fecha modificacion -->	
						<td><bean:write name="tramiteCompletado" property="fechaFin" format="dd/MM/yyyy HH:mm"/></td>
						
						<!--  Fecha inicio -->
						<td><bean:write name="tramiteCompletado" property="fechaInicio" format="dd/MM/yyyy HH:mm"/></td>
												
					</tr>
				</logic:iterate>
				</table>
				
				<!-- Pie entrega doc presencial -->
				<logic:equal name="pieDocPresencial" value="S">
					<div id="pieDocPresencial">				
						<bean:message key="estadoExpedientes.pie.solicitudEnviadaPendienteDocumentacionPresencial" />				
					</div>							
				</logic:equal>
				
				<!--  Barra navegacion -->
				<div id="barraNav">
					<logic:equal name="page" property="previousPage" value="true">			
						&lt;&lt; 
						<html:link action="/protected/estadoExpedientes" paramId="pagina" paramName="firstPage">
							<bean:message key="estadoExpedientes.paginacion.inicio" />
						</html:link> 
						&lt; 
						<html:link action="/protected/estadoExpedientes" paramId="pagina" paramName="page" paramProperty="previousPageNumber">
							<bean:message key="estadoExpedientes.paginacion.anterior" />
						</html:link>
					</logic:equal> 
					
					<logic:equal name="page" property="previousPage" value="false">			
						&lt;&lt; 				
							<bean:message key="estadoExpedientes.paginacion.inicio" />
						&lt; 
							<bean:message key="estadoExpedientes.paginacion.anterior" />
					</logic:equal> 
					
					- Del <bean:write name="page" property="firstResultNumber" /> al <bean:write name="page" property="lastResultNumber" />, de <bean:write name="page" property="totalResults" /> - 
					
					<logic:equal name="page" property="nextPage" value="true">			 
						<html:link action="/protected/estadoExpedientes" paramId="pagina" paramName="page" paramProperty="nextPageNumber">
							<bean:message key="estadoExpedientes.paginacion.siguiente" />
						</html:link> 
						&gt; 
						<html:link action="/protected/estadoExpedientes" paramId="pagina" paramName="page" paramProperty="lastPageNumber">
							<bean:message key="estadoExpedientes.paginacion.final" />
						</html:link> 
						&gt;&gt;
					</logic:equal>
					
					<logic:equal name="page" property="nextPage" value="false">			 				
							<bean:message key="estadoExpedientes.paginacion.siguiente" />
						&gt; 
							<bean:message key="estadoExpedientes.paginacion.final" />
						&gt;&gt;
					</logic:equal>
				</div>
			</logic:notEmpty>
			
		</div>