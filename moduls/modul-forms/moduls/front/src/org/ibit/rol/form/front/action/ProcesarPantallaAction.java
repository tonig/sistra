package org.ibit.rol.form.front.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.*;
import org.ibit.rol.form.front.registro.RegistroManager;
import org.ibit.rol.form.front.util.InstanciaZipCodec;
import org.ibit.rol.form.model.InstanciaBean;
import org.ibit.rol.form.persistence.delegate.InstanciaDelegate;
import org.ibit.rol.form.persistence.delegate.InstanciaTelematicaDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @struts.action
 *  name="pantallaForm"
 *  path="/procesar"
 *  scope="request"
 *  validate="true"
 *  input=".verPantalla"
 *
 * @struts.action
 *  name="pantallaForm"
 *  path="/auth/procesar"
 *  scope="request"
 *  validate="true"
 *  input=".verPantalla"
 *
 * @struts.action
 *  name="pantallaForm"
 *  path="/secure/procesar"
 *  scope="request"
 *  validate="true"
 *  input=".verPantalla"
 *
 * @struts.action
 *  name="pantallaForm"
 *  path="/auth/secure/procesar"
 *  scope="request"
 *  validate="true"
 *  input=".verPantalla"
 *  
 */
public class ProcesarPantallaAction extends BaseAction {

    protected static Log log = LogFactory.getLog(ProcesarPantallaAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
    	Map m = request.getParameterMap();
    	
        InstanciaDelegate delegate = RegistroManager.recuperarInstancia(request);
        if (delegate == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(null, new ActionError("errors.session"));
            saveErrors(request, errors);
            return mapping.findForward("fail");
        }
        boolean telematic = (delegate instanceof InstanciaTelematicaDelegate);
        
        PantallaForm pantallaForm = (PantallaForm) form;
        Map datosFormOrigen = pantallaForm.getMap();
        
        // Creamos copia para que no se modifique el map
        Map datosForm = new HashMap();
        datosForm.putAll(datosFormOrigen);
        delegate.introducirDatosPantalla(datosForm);

        if (isCancelled(request)) {
            if (request.getParameter("SAVE") != null) { // Es guardar
            	
            	// Guardamos datos actuales del formulario para continuar en otro momento
            	try {
                    String redirectUrl = ((InstanciaTelematicaDelegate) delegate).tramitarFormulario(true);
                    response.reset();
                    response.sendRedirect(redirectUrl);
                    response.flushBuffer();
                    return null;
                } finally {
                    RegistroManager.desregistrarInstancia(request);
                }

            } else if (request.getParameter("DISCARD") != null) {

                if (telematic) {
                    try {
                        InstanciaTelematicaDelegate tDelegate = (InstanciaTelematicaDelegate) delegate;
                        String redirectUrl = tDelegate.cancelarFormulario();
                        response.reset();
                        response.sendRedirect(redirectUrl);
                        // INDRA: PROBLEMA CON FIREFOX??
                        // response.flushBuffer();
                        return null;
                    } finally {
                        RegistroManager.desregistrarInstancia(request);
                    }
                }

                RegistroManager.desregistrarInstancia(request);
                return mapping.findForward("main");

            } else { // Es tornar enrera

                String pantallaAnterior = request.getParameter("PANTALLA_ANTERIOR");
                if (pantallaAnterior == null || pantallaAnterior.length() == 0) {
                    delegate.retrocederPantalla();
                } else {
                    delegate.retrocederPantalla(pantallaAnterior);
                }
            }
        } else {
        	// Avanza pantalla
            delegate.avanzarPantalla();
        }

        //return mapping.findForward("success");
        response.sendRedirect(prepareRedirectInstanciaURL(request, response, request.getAttribute("securePath") + "/ver.do"));
        // INDRA: PROBLEMA CON FIREFOX??
        // response.flushBuffer();
        return null;
    }

}
