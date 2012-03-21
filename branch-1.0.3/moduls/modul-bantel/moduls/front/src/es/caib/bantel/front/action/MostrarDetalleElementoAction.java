package es.caib.bantel.front.action;


import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.caib.bantel.front.form.DetalleTramiteForm;
import es.caib.bantel.model.DocumentoBandeja;
import es.caib.bantel.model.GestorBandeja;
import es.caib.bantel.model.Tramite;
import es.caib.bantel.model.TramiteBandeja;
import es.caib.bantel.persistence.delegate.DelegateUtil;
import es.caib.bantel.persistence.delegate.GestorBandejaDelegate;
import es.caib.bantel.persistence.delegate.TramiteBandejaDelegate;
import es.caib.redose.modelInterfaz.DocumentoRDS;
import es.caib.redose.modelInterfaz.ReferenciaRDS;
import es.caib.redose.persistence.delegate.DelegateRDSUtil;
import es.caib.redose.persistence.delegate.RdsDelegate;
import es.caib.xml.datospropios.factoria.FactoriaObjetosXMLDatosPropios;
import es.caib.xml.datospropios.factoria.ServicioDatosPropiosXML;
import es.caib.xml.datospropios.factoria.impl.DatosPropios;
import es.caib.xml.registro.factoria.ConstantesAsientoXML;
import es.caib.zonaper.modelInterfaz.EventoExpedientePAD;
import es.caib.zonaper.modelInterfaz.ExpedientePAD;
import es.caib.zonaper.modelInterfaz.NotificacionExpedientePAD;
import es.caib.zonaper.modelInterfaz.TramiteExpedientePAD;
import es.caib.zonaper.persistence.delegate.PadBackOfficeDelegate;

/**
 * @struts.action
 *  path="/mostrarDetalleElemento"
 *  validate="true"
 *  
 * @struts.action-forward
 *  name="succesAviso" path=".detalleAviso"
 *  
 * @struts.action-forward
 *  name="succesNotificacion" path=".detalleNotificacion"
 *  
 * @struts.action-forward
 *  name="succesTramite" path=".detalleTramiteRecuperado"
 *
 * @struts.action-forward
 *  name="fail" path=".error"
 */
public class MostrarDetalleElementoAction extends BaseAction
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception 
    {
		PadBackOfficeDelegate ejb = new PadBackOfficeDelegate();
		String clave = request.getParameter("clave");
		String unidad = request.getParameter("unidad");
		String identificador = request.getParameter("identificador");
		String codigo = request.getParameter("codigo");
		String tipo = request.getParameter("tipo");
		ExpedientePAD exp;
		try{
			if(clave!=null && !"".equals(clave)){
				exp = ejb.consultaExpediente( new Long(unidad), identificador,clave);
			}else{
				exp = ejb.consultaExpediente( new Long(unidad), identificador);
			}
			//si existe el expediente miramos si hay elementos y si existe el que nos estan pasando.
			if(exp != null){
				request.setAttribute("expediente", exp);
				//miramos si hay elementos y si existe el elemento en la posicion codigo, miramos si es del tipo que nos pasan
				if(exp.getElementos() != null && exp.getElementos().size() >= Integer.parseInt(codigo)){
					if(tipo.equals("A") && exp.getElementos().get(Integer.parseInt(codigo)) instanceof EventoExpedientePAD) {
						request.setAttribute("elemento",exp.getElementos().get(Integer.parseInt(codigo)));
						return mapping.findForward("succesAviso");
					}else if(tipo.equals("N") && exp.getElementos().get(Integer.parseInt(codigo)) instanceof NotificacionExpedientePAD){
						request.setAttribute("elemento",exp.getElementos().get(Integer.parseInt(codigo)));
						return mapping.findForward("succesNotificacion");
					}else if(tipo.equals("T") && exp.getElementos().get(Integer.parseInt(codigo)) instanceof TramiteExpedientePAD){
						String numeroRegistro = ((TramiteExpedientePAD)exp.getElementos().get(Integer.parseInt(codigo))).getNumeroRegistro();
						String tipoTramite = ((TramiteExpedientePAD)exp.getElementos().get(Integer.parseInt(codigo))).getTipo()+"";
						TramiteBandejaDelegate tramiteDelegate = DelegateUtil.getTramiteBandejaDelegate();
						TramiteBandeja tramite;
						if(tipoTramite.equals(ConstantesAsientoXML.TIPO_PREENVIO) || tipoTramite.equals(ConstantesAsientoXML.TIPO_PREREGISTRO)){
							tramite = tramiteDelegate.obtenerTramiteBandejaPorNumeroPreregistro( numeroRegistro );
						}else{
							tramite = tramiteDelegate.obtenerTramiteBandejaPorNumeroRegistro( numeroRegistro );						
						}
						RdsDelegate rdsDelegate = DelegateRDSUtil.getRdsDelegate();
						Set documentosEstructurados = new HashSet();
						Set documentosTramite = tramite.getDocumentos();
						for ( Iterator it = documentosTramite.iterator(); it.hasNext(); )
						{
							DocumentoBandeja documento = ( DocumentoBandeja ) it.next();
							if ( documento.getIdentificador().startsWith( ConstantesAsientoXML.IDENTIFICADOR_DATOS_PROPIOS ) )
							{
								// Acceder al documento rds con su referencia y parsear el xml para construir la informacion
								// de datos propios:
									// --instrucciones -> Instrucciones presencial
									// --solicitud     -> Datos propios de la solicitud
								ReferenciaRDS referenciaRDS = new ReferenciaRDS();
								referenciaRDS.setCodigo( documento.getRdsCodigo().longValue() );
								referenciaRDS.setClave( documento.getRdsClave() );
								
								
								DocumentoRDS documentoRDS = rdsDelegate.consultarDocumento( referenciaRDS );
								byte[] byteArraySolicitud = documentoRDS.getDatosFichero();
								
								FactoriaObjetosXMLDatosPropios factoria = ServicioDatosPropiosXML.crearFactoriaObjetosXML();
								DatosPropios datosPropios = factoria.crearDatosPropios (
											new ByteArrayInputStream(byteArraySolicitud)
										);
								
								request.setAttribute( "datosPropios", datosPropios );				
							}else{
								// Detectamos que docs telematicos son de tipo estructurado (xml) para dar opcion a descargar el xml
								if (documento.getRdsCodigo() != null) {				
									DocumentoRDS documentoRDS = rdsDelegate.consultarDocumento(new ReferenciaRDS(documento.getRdsCodigo().longValue(),documento.getRdsClave()),false);
									if (documentoRDS.isEstructurado()){
										documentosEstructurados.add(documento.getCodigo());
									}
								}
							}
						}		
						request.setAttribute("documentosEstructurados",documentosEstructurados);
						
						// Buscamos si gestor tiene permiso de cambio de estado
						GestorBandejaDelegate gestorBandejaDelegate = DelegateUtil.getGestorBandejaDelegate();
						GestorBandeja gestor = gestorBandejaDelegate.obtenerGestorBandeja(this.getPrincipal(request).getName());
					
						// Verificamos que el gestor tenga acceso al tramite
						boolean acceso = false;		
						for (Iterator it=gestor.getTramitesGestionados().iterator();it.hasNext();){
								Tramite tram = (Tramite) it.next();
								if (tram.getIdentificador().equals(tramite.getTramite().getIdentificador())){
									acceso = true;
									break;
								}
						}
						if (!acceso){
							MessageResources resources = ((MessageResources) request.getAttribute(Globals.MESSAGES_KEY));
							request.setAttribute("message",resources.getMessage( getLocale( request ), "errors.tramiteNoAcceso", new Object[] {tramite.getTramite().getIdentificador()}));			
							return mapping.findForward( "fail" );
						}
						// ------------------------------------------------------------------------------------------------------------------
						DetalleTramiteForm detalleTramiteForm = new DetalleTramiteForm();
						detalleTramiteForm.setCodigo(tramite.getCodigo());
						detalleTramiteForm.setLang(tramite.getIdioma());
						detalleTramiteForm.setLanguage(tramite.getIdioma());
						request.setAttribute( "tramite", tramite );
						request.setAttribute("permitirCambioEstado",Character.toString(gestor.getPermitirCambioEstado()));
						request.setAttribute("detalleTramiteForm",detalleTramiteForm);
						return mapping.findForward("succesTramite");
					}else{
						return mapping.findForward("fail");
					}
				}else{
					return mapping.findForward("fail");
				}
			}else{
				return mapping.findForward("fail");
			}
		}catch(Exception e){
			return mapping.findForward("fail");
		}
    }
}