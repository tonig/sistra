package es.caib.zonaper.front.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * @struts.action
 *  path="/protected/mostrarBandejaFirma"
 *  
 * @struts.action-forward
 *  name="success" path=".bandejaFirma"
 *  
 */
public class MostrarBandejaFirmaAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("success");		
	}

}
