package es.caib.bantel.front.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.caib.bantel.front.Constants;
import es.caib.bantel.front.form.DetalleExpedienteForm;
import es.caib.bantel.front.util.Dominios;
import es.caib.bantel.modelInterfaz.TramiteBTE;
import es.caib.bantel.persistence.delegate.DelegateBTEUtil;
import es.caib.bantel.persistence.delegate.DelegateException;

/**
 * @struts.action
 * 	name="detalleExpedienteForm"
 *  path="/altaEntradaExpediente"
 *  validate="true"
 *  input = ".entradaAltaExpediente"
 *  
 * @struts.action-forward
 *  name="success" path=".altaExpediente"
 *
 * @struts.action-forward
 *  name="fail" path=".error"
 */
public class AltaEntradaExpedienteAction extends BaseAction
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception 
    {		
		MessageResources resources = ((MessageResources) request.getAttribute(Globals.MESSAGES_KEY));
		try{			
			DetalleExpedienteForm expForm = (DetalleExpedienteForm)form;
			request.getSession().setAttribute(Constants.OPCION_SELECCIONADA_KEY,"3");
			TramiteBTE entrada = consultaEntradaBTE(expForm.getNumeroEntrada());	
			if (entrada != null){
				
				if (entrada.getNivelAutenticacion() == 'A' && StringUtils.isEmpty(entrada.getUsuarioNif())){
					request.setAttribute("message",resources.getMessage( getLocale( request ), "errors.anomimoSinNif"));
					return mapping.findForward( "fail" );
				}
				
				request.setAttribute("existeEntrada","S");
				expForm.setUsuarioSeycon(StringUtils.defaultString(entrada.getUsuarioSeycon()));
				expForm.setDescripcion(StringUtils.defaultString(entrada.getDescripcionTramite()));
				expForm.setIdioma(StringUtils.defaultString(entrada.getIdioma(),"es"));
				expForm.setNif(StringUtils.defaultString(entrada.getUsuarioNif()));
				expForm.setNombre(StringUtils.defaultString(entrada.getUsuarioNombre()));
				if(entrada.getUnidadAdministrativa() != null){
					expForm.setUnidadAdm(entrada.getUnidadAdministrativa()+"");
				}else{
					expForm.setUnidadAdm("");
				}
				expForm.setNumeroEntrada(entrada.getNumeroEntrada());
				expForm.setEmail(entrada.getAvisoEmail());
				expForm.setHabilitarAvisos(entrada.getHabilitarAvisos());
				expForm.setMovil(entrada.getAvisoSMS());
				List unidades=Dominios.listarUnidadesAdministrativas();												
				request.setAttribute("unidades",unidades);
				return mapping.findForward( "success" );
			}else{
				request.setAttribute("message",resources.getMessage( getLocale( request ), "errors.tramiteNoExiste"));
				return mapping.findForward( "fail" );
			}
		}catch(Exception ex){
			request.setAttribute("message",ex.getMessage());
			return mapping.findForward( "fail" );	
		}
		
    }
	
	private TramiteBTE consultaEntradaBTE(String numeroEntrada) throws DelegateException{
		return DelegateBTEUtil.getBteDelegate().obtenerEntrada(numeroEntrada);
	}
	
}