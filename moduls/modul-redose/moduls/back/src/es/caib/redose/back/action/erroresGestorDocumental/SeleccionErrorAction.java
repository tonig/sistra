package es.caib.redose.back.action.erroresGestorDocumental;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.redose.back.action.BaseAction;
import es.caib.redose.model.LogGestorDocumentalError;
import es.caib.redose.persistence.delegate.DelegateUtil;
import es.caib.redose.persistence.delegate.LogGestorDocumentalErroresDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para consultar un error del historico.
 *
 * @struts.action
 *  path="/back/erroresGestorDocumental/seleccion"
 *
 * @struts.action-forward
 *  name="success" path=".erroresGestorDocumental.editar"
 *
 * @struts.action-forward
 *  name="fail" path=".erroresGestorDocumental.lista"
 */
public class SeleccionErrorAction extends BaseAction{
    protected static Log log = LogFactory.getLog(SeleccionErrorAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        log.info("Entramos en SeleccionErrorAction");
        try{
	        String idString = request.getParameter("codigo");
	        if (idString == null || idString.length() == 0) {
	            log.warn("El par�metre codigo �s null!!");
	            return mapping.findForward("fail");
	        }
	
	        log.info("Seleccionar el error " + idString);
	
	        Long id = new Long(idString);
	        guardarErrorGestorDocumental(mapping, request, id);
	        
	        return mapping.findForward("success");
        }catch(Exception ex){
        	return mapping.findForward("fail");
        }
    }
}
