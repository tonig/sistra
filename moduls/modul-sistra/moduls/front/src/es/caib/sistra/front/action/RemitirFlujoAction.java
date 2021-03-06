package es.caib.sistra.front.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.sistra.front.Constants;
import es.caib.sistra.front.util.InstanciaManager;
import es.caib.sistra.model.ParametrosMensaje;
import es.caib.sistra.persistence.delegate.InstanciaDelegate;

/**
 * @struts.action
 *  path="/protected/remitirFlujo"
 *  scope="request"
 *  validate="false"
 *
 * @struts.action-forward
 *  name="success" path=".exit"
 *
 * @struts.action-forward
 *  name="fail" path="/fail.do"
 */
public class RemitirFlujoAction extends BaseAction
{
	 public ActionForward executeTask(ActionMapping mapping, ActionForm form, HttpServletRequest request,
             HttpServletResponse response) throws Exception 
     {
		 
		 // Remitimos flujo tramitación
		 InstanciaDelegate delegate = InstanciaManager.recuperarInstancia( request );
		 this.setRespuestaFront( request, delegate.remitirFlujoTramitacion() );
		 
		 if (!this.isSetError(request)){			
			 InstanciaManager.desregistrarInstancia(request);
			 
			// Indicamos destino tras mensaje
			// TODO EL TEMA DE LOS MENSAJES HAY Q RETOCARLO, PARA Q SEA MAS MANEJABLE. AL GENERAR EL MENSAJEFRONT, POSIBLIDAD DE ESTABLECER UNA KEY QUE INDIQUE EL DESTINO
			ParametrosMensaje param = new ParametrosMensaje();
			param.setAction("main");	
			request.setAttribute( Constants.MENSAJE_PARAM, param );				
		 }
		 
		 return mapping.findForward( "success" );			 
		 
     }
}
