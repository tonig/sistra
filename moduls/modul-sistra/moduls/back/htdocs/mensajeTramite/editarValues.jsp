<%@ page language="java" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<html:xhtml/>
<script type="text/javascript">
     <!--
     function viewAyudaExpresion() {
        var url = '<html:rewrite page="/mensajeTramite/ayudaPantalla.jsp" />';
        obrir(url, "Edicion", 540, 400);
     }
     // -->
</script>
<html:hidden property="idTramiteVersion" />
<tr>
	<td class="separador" colspan="2"><bean:message key="mensajeTramite.datosMensajeTramite"/></td>
</tr>
<tr>
    <td class="labelo"><bean:message key="mensajeTramite.identificador"/></td>
    <td class="input"><html:text styleClass="text" tabindex="1" property="values.identificador" maxlength="25" /></td>
</tr>


