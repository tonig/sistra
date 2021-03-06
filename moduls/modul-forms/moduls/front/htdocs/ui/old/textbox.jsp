<%@ page language="java"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="org.ibit.rol.form.model.Validacion"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="nested" uri="http://jakarta.apache.org/struts/tags-nested"%>
<html:xhtml/>
<nested:root>
    <nested:define id="campo" type="org.ibit.rol.form.model.TextBox"/>
    <nested:define id="nombre" property="nombreLogico" type="java.lang.String"/>
    <% boolean autocalculo = StringUtils.isNotEmpty(StringUtils.strip(campo.getExpresionAutocalculo()));%>
    <% boolean disabled = StringUtils.isNotEmpty(StringUtils.strip(campo.getExpresionDependencia())); %>
    <% boolean bloqueado = campo.isBloqueado();%>
    <nested:write property="traduccion.nombre" filter="false"/><nested:notEqual property="traduccion.nombre" value="&nbsp;">:</nested:notEqual>
    <% if (campo.getFilas() > 1) { %>
    <br /><html:textarea
        property="<%=nombre%>"
        readonly="<%=(autocalculo) || (bloqueado)%>"
        disabled="<%=disabled%>"
        onchange='<%=(!autocalculo && !bloqueado) ? "onFieldChange(this.form, this.name)" : ""%>'
        rows="<%=String.valueOf(campo.getFilas())%>"
        cols="<%=String.valueOf(campo.getColumnas())%>"
        styleClass='<%=(autocalculo || bloqueado ? "frmro" : "frm")%>'
        onfocus='<%="setAyuda(" + campo.getOrden() + ")"%>'
        tabindex="<%=Integer.toString((autocalculo) ? 0 : campo.getOrden()+1)%>"
    />
    <% } else { %>
    <% Validacion vmaxlength = campo.findValidacion("maxlength"); %>
    <html:text
        property="<%=nombre%>"
        readonly="<%=(autocalculo) || (bloqueado)%>"
        disabled="<%=(disabled)%>"
        onchange='<%=(!autocalculo && !bloqueado) ? "onFieldChange(this.form, this.name)" : ""%>'
        size="<%=String.valueOf(campo.getColumnas())%>"
        maxlength="<%=(vmaxlength != null ? vmaxlength.getValores()[0] : "")%>"
        styleClass='<%=(autocalculo || bloqueado? "frmro" : "frm")%>'
        onfocus='<%="setAyuda(" + campo.getOrden() + ")"%>'
        tabindex="<%=Integer.toString((autocalculo) ? 0 : campo.getOrden()+1)%>"
    />
    <% } %>
</nested:root>