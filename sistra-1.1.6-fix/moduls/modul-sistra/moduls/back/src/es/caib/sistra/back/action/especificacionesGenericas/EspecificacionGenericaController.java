package es.caib.sistra.back.action.especificacionesGenericas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.Controller;

import es.caib.sistra.back.Constants;
import es.caib.sistra.model.ConstantesSTR;
import es.caib.sistra.model.Opcion;

/**
 * Establecemos lista de valores posibles en desplegables.
 */
public class EspecificacionGenericaController implements Controller{
    protected static Log log = LogFactory.getLog(EspecificacionGenericaController.class);

    public void perform(ComponentContext tileContext,
                        HttpServletRequest request, HttpServletResponse response,
                        ServletContext servletContext)
            throws ServletException, IOException {

        
    	List listaOpcionesNotif = new ArrayList(); 
    	listaOpcionesNotif.add(new Opcion(ConstantesSTR.NOTIFICACIONTELEMATICA_NOPERMITIDA, "especificacionesTramite.habilitarNotificacionTelematica.noPermitida"));
    	listaOpcionesNotif.add(new Opcion(ConstantesSTR.NOTIFICACIONTELEMATICA_PERMITIDA, "especificacionesTramite.habilitarNotificacionTelematica.permitida"));
    	listaOpcionesNotif.add(new Opcion(ConstantesSTR.NOTIFICACIONTELEMATICA_OBLIGATORIA, "especificacionesTramite.habilitarNotificacionTelematica.obligatoria"));
    	
    	request.setAttribute( "habilitarNotificacionOptions", listaOpcionesNotif);
    	
    	request.setAttribute( "habilitarAvisos", request.getSession().getServletContext().getAttribute(Constants.AVISOS_OBLIGATORIOS_NOTIFICACIONES));
    	
    }
}