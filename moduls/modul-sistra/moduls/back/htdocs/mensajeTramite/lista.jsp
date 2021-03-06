<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<html:html locale="true" xhtml="true">
<tiles:useAttribute name="idTramiteVersion"/>
<head>
   <title><bean:message key="mensajeTramite.titulo"/></title>
   <meta http-equiv="Content-type" content='text/html; charset="ISO-8859-1"' />
   <link rel="stylesheet" href='<html:rewrite page="/css/styleA.css"/>' type="text/css" />
   <script src="<html:rewrite page='/moduls/staticJs.jsp'/>" type="text/javascript"></script>
   <script src="<html:rewrite page='/moduls/funcions.js'/>" type="text/javascript"></script>
   <script type="text/javascript">
   <!--
        <logic:present name="reloadMenu">
            parent.Menu.location.reload(true);
        </logic:present>
   //-->
   </script>
</head>

<body class="ventana">
<table class="marc">
    <tr><td class="titulo">
        <bean:message key="mensajeTramite.selec" />
    </td></tr>
    <tr><td class="subtitulo"><bean:message key="mensajeTramite.selec.subtitulo" /></td></tr>
</table>

<br />

<logic:empty name="mensajeTramiteOptions">
    <table class="marc">
      <tr><td class="alert"><bean:message key="mensajeTramite.selec.vacio" /></td></tr>
    </table>
</logic:empty>

<logic:notEmpty name="mensajeTramiteOptions">
    <table class="marc">
        <logic:iterate id="mensajeTramiteTmp" name="mensajeTramiteOptions">
        	<bean:define id="mensajeTramite" name="mensajeTramiteTmp" property="value" type="es.caib.sistra.model.MensajeTramite"/>
            <tr>
                <td class="outputd" width="70%">
                    <bean:write name="mensajeTramite" property="codigo" />
                    <bean:define id="modTramiteNivel" name="mensajeTramite" property="codigo" type="java.lang.Long"/>
                    (<bean:write name="mensajeTramite" property="identificador" />)
                </td>
                <td align="right">
                    <bean:define id="urlEditar"><html:rewrite page="/back/mensajeTramite/seleccion.do" paramId="codigo" paramName="mensajeTramite" paramProperty="codigo"/></bean:define>
                    <button class="button" type="button" onclick="forward('<%=urlEditar%>')"><bean:message key="boton.selec" /></button>

					<bean:define id="descripcion" name="mensajeTramite" property="identificador" type="java.lang.String"/>
                    <bean:define id="mensajeBaja"><bean:message arg0='<%=modTramiteNivel.toString()%>' arg1='<%=StringUtils.escape(descripcion.toString())%>' key='mensajeTramite.baja' /></bean:define>
                    <bean:define id="urlBaja"><html:rewrite page='<%= "/back/mensajeTramite/baja.do?idTramiteVersion=" + idTramiteVersion  %>' paramId="codigo" paramName="mensajeTramite" paramProperty="codigo"/></bean:define>
                    <button class="button" type="button" onclick="confirmAndForward('<%= StringUtils.escape( mensajeBaja ) %>', '<%=urlBaja%>')"><bean:message key="boton.baixa" /></button>
                </td>
            </tr>
        </logic:iterate>
    </table>
</logic:notEmpty>

<br />

    <table class="nomarc">
      <tr>
        <td align="left">        
		    <bean:define id="urlNuevo">
		        <html:rewrite page="/back/mensajeTramite/alta.do" paramId="idTramiteVersion" paramName="idTramiteVersion"/>
		    </bean:define>
            <button class="buttond" type="button" onclick="forward('<%= urlNuevo %>')">
                <bean:message key="boton.nuevo" />
            </button>
        </td>
        <!-- 
        <td align="right">
	        <bean:define id="urlBack">
		        <html:rewrite page="/back/tramiteVersion/seleccion.do" paramId="codigo" paramName="idTramiteVersion"/>
		    </bean:define>
            <button class="buttond" type="button" onclick="forward('<%= urlBack %>')">
                <bean:message key="boton.cancel" />
            </button>    
        </td>
         -->
      </tr>
    </table>

</body>
</html:html>