package es.caib.bantel.back.action.ficheroExportacion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.bantel.back.action.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para consultar un Fichero de exportacion.
 *
 * @struts.action
 *  path="/back/ficheroExportacion/seleccion"
 *
 * @struts.action-forward
 *  name="success" path=".ficheroExportacion.editar"
 *
 * @struts.action-forward
 *  name="fail" path=".ficheroExportacion.lista"
 */
public class SeleccionFicheroExportacionAction extends BaseAction{
    protected static Log log = LogFactory.getLog(SeleccionFicheroExportacionAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

    	log.debug("Entramos en SeleccionFicheroExportacionAction");

        String idString = request.getParameter("codigo");
        if (idString == null || idString.length() == 0) {
            log.warn("El par�metre codigo �s null!!");
            return mapping.findForward("fail");
        }

        log.debug("Seleccionar el fichero exportacion " + idString);
       
        guardarFicheroExportacion(mapping, request, idString);

        request.setAttribute( "idReadOnly", new Boolean( true ) );

        return mapping.findForward("success");
    }
}