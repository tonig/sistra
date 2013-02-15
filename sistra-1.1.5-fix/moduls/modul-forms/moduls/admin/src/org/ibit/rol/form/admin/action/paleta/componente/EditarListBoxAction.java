package org.ibit.rol.form.admin.action.paleta.componente;

import org.ibit.rol.form.persistence.delegate.ComponenteDelegate;
import org.ibit.rol.form.persistence.delegate.DelegateUtil;
import org.ibit.rol.form.model.Componente;
import org.ibit.rol.form.admin.form.ComponenteForm;
import org.ibit.rol.form.admin.action.BaseAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para editar un componente ListBox.
 *
 * @struts.action
 *  name="listboxForm"
 *  scope="session"
 *  validate="true"
 *  input=".listbox.editar"
 *  path="/admin/listbox/editar"
 *
 * @struts.action-forward
 *  name="reload" path=".listbox.editar"
 *
 * @struts.action-forward
 *  name="cancel" path=".paleta.editar"
 *
 * @struts.action-forward
 *  name="success" path=".paleta.editar"
 */
public class EditarListBoxAction extends BaseAction {

    protected static Log log = LogFactory.getLog(EditarListBoxAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        log.debug("Entramos en EditarListBox");

        ComponenteDelegate componenteDelegate = DelegateUtil.getComponenteDelegate();
        ComponenteForm componenteForm = (ComponenteForm) form;
        Componente componente = (Componente) componenteForm.getValues();

        if (isCancelled(request)) {
            log.debug("isCancelled");
            Long idPaleta = componenteForm.getIdPaleta();
            guardarPaleta(mapping, request, idPaleta);
            return mapping.findForward("cancel");
        }

        // Elimina traducciones que no son validas
        componenteForm.validaTraduccion(mapping, request);

        if (isAlta(request) || isModificacio(request)) {
            log.debug("isAlta || isModificacio");

            Long idPaleta = componenteForm.getIdPaleta();
            componenteDelegate.gravarComponentePaleta(componente, idPaleta);

            log.debug("Creat/Actualitzat " + componente.getId());

            guardarPaleta(mapping, request, idPaleta);

            return mapping.findForward("success");
        }

        // Cambio de idioma
        componenteForm.reloadLang();
        request.setAttribute("idComponente", componente.getId());

        return mapping.findForward("reload");
    }
}