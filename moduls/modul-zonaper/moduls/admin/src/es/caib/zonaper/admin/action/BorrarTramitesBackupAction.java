package es.caib.zonaper.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.zonaper.persistence.delegate.DelegateUtil;
import es.caib.zonaper.persistence.delegate.ProcesosAutoDelegate;

/**
 * @struts.action
 *  path="/borrarTramitesBackup"
 *  scope="request"
 *  validate="false"
 */
public class BorrarTramitesBackupAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception 
    {
		
		ProcesosAutoDelegate delegate = DelegateUtil.getProcesosAutoDelegate();
		delegate.procesaEliminarTramitesBackup();
		
		response.getOutputStream().write("Proceso finalizado".getBytes());
		return null;
	}    
	

}
