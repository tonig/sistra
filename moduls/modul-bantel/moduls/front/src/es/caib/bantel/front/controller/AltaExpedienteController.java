package es.caib.bantel.front.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.tiles.ComponentContext;

import es.caib.bantel.front.Constants;
import es.caib.bantel.front.form.DetalleExpedienteForm;
import es.caib.bantel.model.GestorBandeja;
import es.caib.bantel.persistence.delegate.DelegateUtil;

public class AltaExpedienteController extends BaseController
{
		
	public void execute(ComponentContext tileContext,
			HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) throws Exception
	{
		
		DetalleExpedienteForm notificacionForm = (DetalleExpedienteForm) request.getAttribute("detalleExpedienteForm");
		if (StringUtils.isNotEmpty(notificacionForm.getNumeroEntrada())) {
			request.setAttribute("existeEntrada","S");
		}
		
		/*
		// Combo unidades administrativas
		List unidades=Dominios.listarUnidadesAdministrativas();
		request.setAttribute("unidades",unidades);
		*/
		
		// Combo procedimientos gestor
		GestorBandeja gestor = DelegateUtil.getGestorBandejaDelegate().obtenerGestorBandeja(this.getPrincipal(request).getName());
		request.setAttribute("procedimientosGestor", gestor.getProcedimientosGestionados());
		
		// Indica si son obligatorios los avisos en la creacion del expediente
		request.setAttribute("obligatorioAvisos", request.getSession().getServletContext().getAttribute(Constants.GESTIONEXPEDIENTES_OBLIGATORIOAVISOS));
		
	}

}