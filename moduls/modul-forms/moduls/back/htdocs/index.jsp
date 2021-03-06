<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%--
P�gina principal.
    Crea dos frames: 
        /menu.jsp
        /back/formulario/lista.do
--%>
<html:html locale="true" xhtml="true">
<head>
   <title>FORMBACK</title>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
</head>
<%--
Frameborder no se puede poner en frameset, de momento est� por un bug del mozilla
    http://bugzilla.mozilla.org/show_bug.cgi?id=3655#c27
--%>
<frameset cols="200,*" border="0">
  <html:frame frameName="Menu" action="/menu" frameborder="0"  scrolling="auto" noresize="true" /> 
  <% if (request.getParameter("modelo") == null) { %>
  <html:frame frameName="Ventana" action="/back/formulario/lista" frameborder="0" scrolling="auto" noresize="true" />
  <%}else{ %>
  <bean:define id="urlAbrirForm">
    <html:rewrite page="/back/formulario/abrirFormulario.do"/>
  </bean:define>
  
  
  <html:frame frameName="Ventana" href="<%=urlAbrirForm + \"?modelo=\" + request.getParameter(\"modelo\") + \"&version=\" + request.getParameter(\"version\") %>" frameborder="0" scrolling="auto" noresize="true" />
  <%}%>
</frameset>
</html:html>