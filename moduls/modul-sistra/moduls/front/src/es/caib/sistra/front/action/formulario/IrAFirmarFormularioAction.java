package es.caib.sistra.front.action.formulario;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.caib.sistra.front.Constants;
import es.caib.sistra.front.action.BaseAction;
import es.caib.sistra.front.form.formulario.IrAFirmarFormularioForm;
import es.caib.sistra.front.util.InstanciaManager;
import es.caib.sistra.model.DocumentoFront;
import es.caib.sistra.model.RespuestaFront;
import es.caib.sistra.model.TramiteFront;
import es.caib.sistra.persistence.delegate.InstanciaDelegate;
import es.caib.util.ConvertUtil;

/**
 * @struts.action
 *  name="irAFirmarFormularioForm"
 *  path="/protected/irAFirmarFormulario"
 *  scope="request"
 *  validate="false"
 *
 * @struts.action-forward
 *  name="success" path=".irAFirmarFormulario"
 *
 * @struts.action-forward
 *  name="fail" path="/fail.do"
 */
public class IrAFirmarFormularioAction extends BaseAction
{
	public ActionForward executeTask(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
		IrAFirmarFormularioForm formulario = ( IrAFirmarFormularioForm ) form;
		InstanciaDelegate delegate = InstanciaManager.recuperarInstancia( request );
		
		RespuestaFront respuestaFront = delegate.pasoActual();
		
		TramiteFront tramite = respuestaFront.getInformacionTramite();
		
		// Buscamos formulario a firmar
		ArrayList arlFormularios = tramite.getFormularios();
		DocumentoFront f = null; 
		for ( int i = 0; i < arlFormularios.size(); i++ )
		{
			f = ( DocumentoFront ) arlFormularios.get( i );
			if ( formulario.getIdentificador().equals( f.getIdentificador() ) )
			{
				request.setAttribute( "formulario", f );
				break;
			}
		}
		
		// Pasamos a firmar formulario 
		respuestaFront = delegate.irAFirmarFormulario( formulario.getIdentificador(), formulario.getInstancia() );
		
		// Establecemos datos formulario
		String xmlFormulario = ( String )respuestaFront.getParametros().get( "datos" );
		String base64EncXml = ConvertUtil.cadenaToBase64UrlSafe( xmlFormulario );
		request.setAttribute( "base64XmlForm", base64EncXml );
		
		// Indicamos si debemos mostrar la firma digital o firma delegada
		String mostrarFirmaDigital = "N";
		String listaFirmantes = "";
		if (f.isFirmar()){
			if (f.isFirmaDelegada()){
				mostrarFirmaDigital = "D";
			}else{
				mostrarFirmaDigital = "S";
			}
			// Formateamos lista de firmantes
			String[] nifFirmantes = f.getFirmante().split("#");
			String[] nomFirmantes = f.getNombreFirmante().split("#");
			
			String partY = " y ";
			if ("ca".equals(this.getLang(request))){
				partY = " i ";
			}else if ("en".equals(this.getLang(request))){
				partY = " and ";
			}
					
			for (int i=0;i<nifFirmantes.length;i++){
				if (i>0){
					if (i == (nifFirmantes.length - 1)){
						listaFirmantes +=  partY;
					}else{
						listaFirmantes += ", ";
					}
				}
				listaFirmantes += nifFirmantes[i] + (StringUtils.isNotBlank(nomFirmantes[i])?" - " + nomFirmantes[i]:"");				
			}
		}
		request.setAttribute(Constants.MOSTRAR_FIRMA_DIGITAL,mostrarFirmaDigital);
		request.setAttribute( "listaFirmantes", listaFirmantes );
				
		this.setRespuestaFront( request, respuestaFront );
		return mapping.findForward("success");
	}
}
