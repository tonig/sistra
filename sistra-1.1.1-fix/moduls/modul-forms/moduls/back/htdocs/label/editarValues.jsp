<%@ page language="java" %>
<%@ page import="org.ibit.rol.form.back.util.Util"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<html:xhtml/>
<% int ti = 1; %>
<html:hidden property="idPantalla" />
<input type="hidden" name="idOperacion" value="<%=Util.getIdOperacion(request)%>"/>	
<tr>
    <td class="labelo"><bean:message key="componente.nombreLogico"/></td>
    <td class="input"><html:text styleClass="text" tabindex="<%=Integer.toString(ti++)%>" property="values.nombreLogico" maxlength="128" /></td>
</tr>
<tr>
    <td class="labela" colspan="2"><bean:message key="ayuda.nombrelogico"/></td>
</tr>
<tr>
    <td class="label"><bean:message key="componente.posicion"/></td>
    <td class="input">
    <html:select tabindex="<%=Integer.toString(ti++)%>" property="values.posicion">
        <html:option value="0"><bean:message key="componente.posicion.0" /></html:option>
        <html:option value="1"><bean:message key="componente.posicion.1" /></html:option>
    </html:select>
</tr>
<tr>
    <td class="labela" colspan="2"><bean:message key="ayuda.posicion"/></td>
</tr>
<tr>
    <td class="label"><bean:message key="label.estilo"/></td>
    <td class="input"><html:text styleClass="text" tabindex="<%=Integer.toString(ti++)%>" property="values.estilo" maxlength="128" /></td>
</tr>
<tr>
    <td class="labela" colspan="2"><bean:message key="ayuda.estilo"/></td>
</tr>
