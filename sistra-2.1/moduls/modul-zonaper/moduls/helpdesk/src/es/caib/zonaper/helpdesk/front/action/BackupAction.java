package es.caib.zonaper.helpdesk.front.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.zonaper.helpdesk.front.Constants;

/**
 * @struts.action
 *  path="/backup"
 *  validate="false"
 *  
 * @struts.action-forward
 *  name="success" path=".backup"
 *
 * @struts.action-forward
 *  name="fail" path=".error"
 */
public class BackupAction extends BaseAction
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception 
    {
		request.getSession().setAttribute(Constants.OPCION_SELECCIONADA_KEY,Constants.BACKUP_TAB);		
		return mapping.findForward( "success" );
    }
}
