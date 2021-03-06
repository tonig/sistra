<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>

<html:html locale="true" xhtml="true">
<head>
   <title><bean:message key="valorposible.titulo"/></title>
   <meta http-equiv="Content-type" content='text/html; charset="ISO-8859-1"' />
   <link rel="stylesheet" href='<html:rewrite page="/css/styleA.css"/>' type="text/css" />
</head>

<body class="ventana">

<bean:define id="idComponente" name="idComponente" />
<bean:size id="numOptions" name="valoresOptions" />

<!-- Muestra el arbol de navegación en la parte superior de la pantalla-->
<logic:present name="formulario">
    <p class="path">
    <i><bean:message key="formulario.path" /></i>: <b><bean:write name="formulario" /></b>
    <logic:present name="pantalla">
        &gt;&gt; <i><bean:message key="pantalla.path" /></i>: <b><bean:write name="pantalla" /></b>
        <logic:present name="componente">
            &gt;&gt; <i><bean:message key="componente.path" /></i>: <b><bean:write name="componente" /></b>
            <logic:present name="valor">
                &gt;&gt; <i><bean:message key="valorposible.path" /></i>: <b><bean:write name="valor" /></b>
            </logic:present>
        </logic:present>
    </logic:present>
    </p>
</logic:present>

<br />
<table class="marc">
    <tr><td class="titulo"><bean:message key="valorposible.orden" /></td></tr>
    <tr><td class="subtitulo"><bean:message key="valorposible.orden.subtitulo" /></td></tr>
</table>
<br />
<logic:equal name="numOptions" value="0">
    <table class="marc">
      <tr><td class="alert"><bean:message key="valorposible.selec.vacio" /></td></tr>
    </table>
</logic:equal>
<logic:notEqual name="numOptions" value="0">
    <% Long codAnterior = null; %>
    <table class="marc">
        <logic:iterate  id="valor" name="valoresOptions" indexId="idValor">
            <bean:define id="codValor" name="valor" property="id" type="java.lang.Long" />
            <html:form action="/admin/valorposible/cambiaorden" >
            <input type="hidden" name="idComponente" value='<bean:write name="idComponente" />' />
            <tr>
                <td align="center">
                    <%=idValor.intValue() + 1%>
                </td>
                <td class="output" >
                    <bean:write name="valor" property="traduccion.etiqueta" />
                    <logic:equal name="valor" property="defecto" value="true">
                        (<bean:message key="valorposible.defecto" />)
                    </logic:equal>
                </td>
                <logic:notEqual name="idValor" value="0">
                    <html:hidden property="codigo1" value="<%=codValor.toString()%>" />
                    <html:hidden property="codigo2" value="<%=codAnterior.toString()%>" />
                    <td align="center">
                        <html:submit styleClass="button">
                            <bean:message key="boton.subir" />
                        </html:submit>
                    </td>
                </logic:notEqual>
                <logic:equal name="idValor" value="0">
                    <td>&nbsp;<br />&nbsp;</td>
                </logic:equal>
            </tr>
           </html:form>
           <%
               if (idValor != numOptions) {
                   codAnterior = codValor;
               }
           %>
        </logic:iterate>
    </table>
</logic:notEqual>
<br />
<table class="nomarc">
    <html:form action="/admin/valorposible/orden" >
    <input type="hidden" name="idComponente" value='<bean:write name="idComponente" />' />
     <tr><td align="right">
        <html:cancel styleClass="button" ><bean:message key="boton.acept" /></html:cancel>
     </td></tr>
    </html:form>
</table>
</body>
</html:html>