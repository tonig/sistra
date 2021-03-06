<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<tiles:importAttribute name="independientes" scope="page" />
<bean:parameter id="expand" name="expand" value="none" />
<html:html locale="true" xhtml="true">
<head>
   <title>MOBTRATELBACK</title>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
   <link rel="stylesheet" href='<html:rewrite page="/css/styleA.css"/>' type="text/css" />
</head>
<body class="menu">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
    <tr><td class="titulo"><bean:message key="main.title" /><!--html:img page="/img/rol.gif" border="4" style="border-color: #dec5c1" /--></td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td class="user"><%=request.getRemoteUser()%></td></tr>
    <tr><td>
        <logic:iterate id="independiente" name="independientes">
            <ul><tiles:insert beanName="independiente" flush="false" /></ul>
        </logic:iterate>
    </td></tr>
    <tr><td>&nbsp;</td></tr>   
</table>
<div style="position: absolute; bottom: 0; left: 0; text-align:center; width:100%;"><small><i>SISTRA V<%=es.caib.mobtratel.back.util.Util.getVersion()%></i></small></div>
</body>
</html:html>