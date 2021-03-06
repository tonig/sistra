<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ page contentType="text/html; charset=ISO-8859-1" import="java.util.*, org.apache.struts.Globals" %>
<bean:define id="es" value="es" />
<bean:define id="ca" value="ca" />
<%
	String language = "ca";	

	// Comprobamos si intentamos acceder a un tr�mite y pedimos autenticaci�n requerida
	try
	{	
		// Accedemos a request destino
		String savedRequest = (String) request.getAttribute("savedrequest");
		
		// Si intenta acceder a un tr�mite buscamos modelo y versi�n
//		String in = request.getContextPath() + "/init.do";						
		String in = request.getContextPath() + "/init.do";
		if (!savedRequest.startsWith(in)) throw new Exception("Punto de entrada no v�lido");
		
		if ( savedRequest.indexOf( "?" ) > 0 )
		{
			in = in + "?";
			String params = savedRequest.substring(in.length());
			savedRequest = params;
			
			StringTokenizer st = new StringTokenizer(savedRequest,"&");
			String element;
			while (st.hasMoreElements())
			{	
				element = (String) st.nextElement();
				System.out.println( "elemento " + element);
				if (element.startsWith("language="))
				{
					language = element.substring(("language=").length());
				}
				else if (element.startsWith("lang="))
				{
					language = element.substring(("lang=").length());
				}
			}
		}
			
			session.setAttribute(Globals.LOCALE_KEY, new Locale(language));
//			System.out.println( "CLM Language: [" + language + "]" + new Locale(language) );
	
	}catch(Exception ex)
	{
		ex.printStackTrace();
		out.println("ERROR AUTENTICACION: " + ex.toString());
		return;
	}
%>
<bean:define id="languageBean" value="<%= language %>" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head>
   <title><bean:message key="login.titulo"/></title>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />   
   <link href="estilos/cuadromando.css" rel="stylesheet" type="text/css" />
</head>
<body class="ventana">
<div id="capsal">	
	<!--<img src="images/logo_caib.gif" alt="Govern de les Illes Balears" />-->
	<h1><bean:message key="header.titulo" /></h1>
</div>
	<br />
	<center>
	    <form method="post" action="j_security_check">
	        <table class="marc">
	        <tr>
	            <td class="label"><bean:message key="login.user" /></td>
	            <td class="input"><input type="text" name="j_username" maxlength="256" tabindex="1" value="" class="text" /></td>
	        </tr>
	        <tr>
	            <td class="label"><bean:message key="login.pwd" /></td>
	            <td class="input"><input type="password" name="j_password" maxlength="256" tabindex="2" value="" class="text" /></td>
	        </tr>
	        </table>
	        <br />
	        <table class="nomarc">
	        <tr>
	            <td align="center">
	                <input type="submit" name="submit" value="Entrar" class="button" />
	                <input type="reset" value="Reiniciar" class="button" />
	            </td>
	        </tr>
	        </table>
	    </form>       
	</center>

</body>
</html>
