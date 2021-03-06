package es.caib.bantel.back.action.gestorBandeja;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.bantel.back.action.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para consultar un GestorBandeja.
 *
 * @struts.action
 *  path="/back/gestorBandeja/seleccion"
 *
 * @struts.action-forward
 *  name="success" path=".gestorBandeja.editar"
 *
 * @struts.action-forward
 *  name="fail" path=".gestorBandeja.lista"
 */
public class SeleccionGestorBandejaAction extends BaseAction{
    protected static Log log = LogFactory.getLog(SeleccionGestorBandejaAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        log.debug("Entramos en SeleccionGestorBandeja");

        String idString = request.getParameter("codigo");
        if (idString == null || idString.length() == 0) {
            log.warn("El par�metre codigo �s null!!");
            return mapping.findForward("fail");
        }

        log.debug("Seleccionar el gestorBandeja " + idString);

        guardarGestorBandeja(mapping, request, idString);
        
        request.setAttribute( "idReadOnly", new Boolean( true ) );

        return mapping.findForward("success");
    }
}
