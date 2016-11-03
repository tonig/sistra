<%@ page language="java" contentType="text/html; charset=ISO-8859-15" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>

<!--  logo  -->
<logic:equal name="<%=es.caib.zonaper.filter.front.Constants.MOSTRAR_EN_IFRAME%>" value="false">
<div id="cap">
	<a href="<bean:write name="<%=es.caib.zonaper.filter.front.Constants.ORGANISMO_INFO_KEY%>" property="urlPortal" />">
		<img src="<bean:write name="<%=es.caib.zonaper.filter.front.Constants.ORGANISMO_INFO_KEY%>" property="urlLogo" />" alt="Logo <bean:write name="<%=es.caib.zonaper.filter.front.Constants.ORGANISMO_INFO_KEY%>" property="nombre" />" />
	</a>
</div>
</logic:equal>
<!--  logo  -->

<!-- titol -->
<p id="titolAplicacio"><bean:message key="actualizarDatosPAD.titulo"/></p>
<!-- titol -->