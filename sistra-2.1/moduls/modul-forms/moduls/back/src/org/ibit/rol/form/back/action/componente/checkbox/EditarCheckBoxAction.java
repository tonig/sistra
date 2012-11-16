package org.ibit.rol.form.back.action.componente.checkbox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ibit.rol.form.back.action.BaseAction;
import org.ibit.rol.form.back.form.ComponenteForm;
import org.ibit.rol.form.back.util.Util;
import org.ibit.rol.form.model.Componente;
import org.ibit.rol.form.model.Pantalla;
import org.ibit.rol.form.persistence.delegate.ComponenteDelegate;
import org.ibit.rol.form.persistence.delegate.DelegateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para editar un componente checkbox.
 *
 * @struts.action
 *  name="checkboxForm"
 *  scope="session"
 *  validate="true"
 *  input=".checkbox.editar"
 *  path="/back/checkbox/editar"
 *
 * @struts.action-forward
 *  name="reload" path=".checkbox.editar"
 *
 * @struts.action-forward
 *  name="cancel" path=".pantalla.editar"
 *
 * @struts.action-forward
 *  name="error" path=".idOperacion.error"
 *
 * @struts.action-forward
 *  name="success" path=".pantalla.editar"
 */
public class EditarCheckBoxAction extends BaseAction{
    protected static Log log = LogFactory.getLog(EditarCheckBoxAction.class);

    public ActionForward execute(ActionMapping       mapping,
                                 ActionForm          form,
                                 HttpServletRequest  request,
                                 HttpServletResponse response) throws Exception {

        log.debug("Entramos en EditarCheckBox");
        ComponenteDelegate componenteDelegate = DelegateUtil.getComponenteDelegate();
        ComponenteForm componenteForm = (ComponenteForm) form;
        Componente componente = (Componente) componenteForm.getValues();
		if(Util.getOperacionPermitida(request)){  
        if (isCancelled(request)) {
           log.debug("isCancelled");
           Long idPantalla = componenteForm.getIdPantalla();
           Pantalla pantalla = guardarPantalla(mapping, request, idPantalla);
           return mapping.findForward("cancel");
        }

        // Elimina traducciones que no son validas
        componenteForm.validaTraduccion(mapping, request);

        if (isAlta(request) || isModificacion(request)) {
            log.debug("isAlta || isModificacio");
            componenteDelegate.gravarComponentePantalla(componente, componenteForm.getIdPantalla());
            componenteForm.setId(componente.getId());

            log.debug("Creat/Actualitzat " + componente.getId());

            request.setAttribute("reloadMenu", "true");
            guardarPantalla(mapping,request,componenteForm.getIdPantalla());
            return mapping.findForward("success");

        }

        // Cambio de idioma
        componenteForm.reloadLang();
        return mapping.findForward("reload");
        }else{
        	log.debug("Error el id de operaci�n modificado es diferente al id de operaci�n de la sesi�n.");
        	return mapping.findForward("error");
        }
    }
}