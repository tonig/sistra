package es.caib.zonaper.front.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;
import org.apache.commons.lang.StringUtils;

import es.caib.zonaper.front.util.ZonapersFrontRequestHelper;
import es.caib.zonaper.persistence.delegate.DelegateUtil;

public class MenuAutenticadoController extends BaseController
{
	public void execute(ComponentContext tileContext,
			HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) throws Exception
	{
		
		String notExternas = StringUtils.defaultString(DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion().getProperty("notificaciones.enlaceExterno"), "");
		
		request.setAttribute("habilitarAlertas", Boolean.toString(ZonapersFrontRequestHelper.isHabilitarApartadoAlertas(request)));
		request.setAttribute("notificacionesExternas", notExternas);
		
	}
	
	

}
