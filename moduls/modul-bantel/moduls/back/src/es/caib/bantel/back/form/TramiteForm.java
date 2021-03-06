package es.caib.bantel.back.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import es.caib.bantel.back.taglib.Constants;
import es.caib.bantel.model.Procedimiento;
import es.caib.bantel.persistence.delegate.DelegateException;
import es.caib.bantel.persistence.delegate.DelegateUtil;
import es.caib.bantel.persistence.delegate.ProcedimientoDelegate;


public class TramiteForm extends BantelForm implements InitForm
{

	protected static Log log = LogFactory.getLog(TramiteForm.class);
	
	private String userPlain;
	private String passPlain;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{		
        ActionErrors errors = super.validate(mapping, request);
        
       
        if (errors == null) 
        {
            errors = new ActionErrors();
        }
        try 
        {
        	Procedimiento tramite = ( Procedimiento ) this.getValues();
        	
        	// Comprobamos restricciones
        	if (tramite.getIntervaloInforme() != null && tramite.getIntervaloInforme().longValue() > 0){

        		// Url
        		if ( (tramite.getTipoAcceso() == Procedimiento.ACCESO_EJB && tramite.getLocalizacionEJB() == Procedimiento.EJB_REMOTO) 
        			|| 
        			tramite.getTipoAcceso() == Procedimiento.ACCESO_WEBSERVICE){
		    			if (StringUtils.isEmpty(tramite.getUrl())){
		        			errors.add("values.url", new ActionError("errors.url.vacia"));
		        		}        			
        		}
        		//version WS
        		if(tramite.getTipoAcceso() == Procedimiento.ACCESO_WEBSERVICE){
        			if (StringUtils.isEmpty(tramite.getVersionWS())){
	        			errors.add("values.versionWS", new ActionError("errors.versionWS.vacia"));
	        		}
        		}
        		
        		// Jndi
        		if (tramite.getTipoAcceso() == Procedimiento.ACCESO_EJB && StringUtils.isEmpty(tramite.getJndiEJB())){
		    		errors.add("values.jndiEJB", new ActionError("errors.jndi.vacia"));		        	        		
        		}
        		
        		// Usr y pswd
        		if (tramite.getAutenticacionEJB() == Procedimiento.AUTENTICACION_ESTANDAR){        		
        			if (StringUtils.isEmpty(userPlain) || StringUtils.isEmpty(passPlain))
        				errors.add("userPlain", new ActionError("errors.userpasswd.vacio"));
        		}
        		
        	}
        	        	
        	// Comprobamos que no exista otro tr�mite con ese c�digo
        	if (  request.getParameter(Constants.ALTA_PROPERTY) != null  ) {
		    	ProcedimientoDelegate delegate = DelegateUtil.getTramiteDelegate();
		    	Procedimiento tramiteTmp = delegate.obtenerProcedimiento( tramite.getIdentificador() );
		    	if ( tramiteTmp != null ) 		    	{
		    		errors.add("values.identificador", new ActionError("errors.tramite.duplicado", tramite.getIdentificador() ));
		    	} 
        	}
        
        }
	    catch (DelegateException e) 
	    {
	        log.error(e);
	    }	   
        
	    return errors;

	}

	public String getPassPlain() {
		return passPlain;
	}


	public void setPassPlain(String passPlain) {
		this.passPlain = passPlain;
	}


	public String getUserPlain() {
		return userPlain;
	}


	public void setUserPlain(String userPlain) {
		this.userPlain = userPlain;
	}

}
