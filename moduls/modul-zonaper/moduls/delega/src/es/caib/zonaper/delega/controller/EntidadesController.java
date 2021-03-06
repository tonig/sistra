package es.caib.zonaper.delega.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;

import es.caib.zonaper.delega.util.Dominios;
import es.caib.zonaper.persistence.delegate.ConfiguracionDelegate;
import es.caib.zonaper.persistence.delegate.DelegateUtil;

public class EntidadesController extends BaseController {

	public void execute(ComponentContext tileContext,
			HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) throws Exception {

		String urlSistra = "";
		List provincias = new ArrayList();
		List municipios = new ArrayList();

		provincias = Dominios.listarProvincias();
		municipios = new ArrayList();
		if (request.getAttribute("provinciaEntidad") != null) {
			municipios = Dominios.listarLocalidadesProvincia((String) request
					.getAttribute("provinciaEntidad"));
		}

		ConfiguracionDelegate delegate = DelegateUtil
				.getConfiguracionDelegate();
		Properties propsConfig = delegate.obtenerConfiguracion();
		urlSistra = propsConfig.getProperty("sistra.url.back");

		request.setAttribute("provincias", provincias);
		request.setAttribute("municipios", municipios);
		request.setAttribute("urlSistraAFirma", urlSistra);
	}

}
