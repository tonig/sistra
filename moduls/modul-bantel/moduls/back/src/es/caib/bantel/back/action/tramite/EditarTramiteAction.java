package es.caib.bantel.back.action.tramite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.bantel.back.action.BaseAction;
import es.caib.bantel.back.form.TramiteForm;
import es.caib.bantel.model.Procedimiento;
import es.caib.bantel.persistence.delegate.DelegateUtil;
import es.caib.bantel.persistence.delegate.ProcedimientoDelegate;
import es.caib.util.CifradoUtil;

/**
 * Action para editar un Tramite.
 *
 * @struts.action
 *  name="tramiteForm"
 *  scope="session"
 *  validate="true"
 *  input=".tramite.editar"
 *  path="/back/tramite/editar"
 *
 * @struts.action-forward
 *  name="reload" path=".tramite.editar"
 *
 * @struts.action-forward
 *  name="success" path=".tramite.editar"
 *
 * @struts.action-forward
 *  name="cancel" path=".tramite.lista"
 *  
 */
public class EditarTramiteAction extends BaseAction{

    protected static Log log = LogFactory.getLog(EditarTramiteAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

    	request.setAttribute( "idReadOnly", new Boolean( true ) );
    	
        log.debug("Entramos en EditarTramite");

        ProcedimientoDelegate tramiteDelegate = DelegateUtil.getTramiteDelegate();
        TramiteForm tramiteForm = (TramiteForm) form;
        Procedimiento tramite = (Procedimiento) tramiteForm.getValues();

        if (isCancelled(request)) {
            log.debug("isCancelled");
            return mapping.findForward("cancel");
        }

        if (request.getParameter("borrarTramite") != null) 
        {
            return mapping.findForward("reload");
        }         
        
        
        if (isAlta(request) || isModificacion(request)) {
            log.debug("isAlta || isModificacio");                      
            
            String claveCifrado = (String) DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion().get("clave.cifrado");
            tramite.setUsr(CifradoUtil.cifrar(claveCifrado,tramiteForm.getUserPlain()));
            tramite.setPwd(CifradoUtil.cifrar(claveCifrado,tramiteForm.getPassPlain()));
            
            tramiteDelegate.grabarProcedimiento( tramite );
            //request.setAttribute("reloadMenu", "true");
            log.debug("Creat/Actualitzat " + tramite.getIdentificador());

            guardarTramite(mapping, request, tramite.getIdentificador());

            return mapping.findForward("success");

        }

        return mapping.findForward("reload");
    }       

}
