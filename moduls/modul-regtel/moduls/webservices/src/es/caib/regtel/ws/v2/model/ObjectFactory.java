
package es.caib.regtel.ws.v2.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.caib.regtel.ws.v2.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DatosRegistroSalidaDocumentos_QNAME = new QName("", "documentos");
    private final static QName _FirmaWSFormato_QNAME = new QName("", "formato");
    private final static QName _OficioRemisionTramiteSubsanacionParametrosTramite_QNAME = new QName("", "parametrosTramite");
    private final static QName _DatosNotificacionAccesiblePorClave_QNAME = new QName("", "accesiblePorClave");
    private final static QName _DatosNotificacionPlazo_QNAME = new QName("", "plazo");
    private final static QName _DetalleAvisoConfirmadoEnvio_QNAME = new QName("", "confirmadoEnvio");
    private final static QName _DetalleAvisoFechaEnvio_QNAME = new QName("", "fechaEnvio");
    private final static QName _PrepararRegistroEntradaDiasPersistencia_QNAME = new QName("urn:es:caib:regtel:ws:v2:model:BackofficeFacade", "diasPersistencia");
    private final static QName _DatosInteresadoCodigoPais_QNAME = new QName("", "codigoPais");
    private final static QName _DatosInteresadoCodigoProvincia_QNAME = new QName("", "codigoProvincia");
    private final static QName _DatosInteresadoAutenticado_QNAME = new QName("", "autenticado");
    private final static QName _DatosInteresadoNombreLocalidad_QNAME = new QName("", "nombreLocalidad");
    private final static QName _DatosInteresadoCodigoLocalidad_QNAME = new QName("", "codigoLocalidad");
    private final static QName _DatosInteresadoNombreProvincia_QNAME = new QName("", "nombreProvincia");
    private final static QName _DatosInteresadoNombrePais_QNAME = new QName("", "nombrePais");
    private final static QName _DocumentoExtension_QNAME = new QName("", "extension");
    private final static QName _DocumentoNombre_QNAME = new QName("", "nombre");
    private final static QName _DocumentoReferenciaRDS_QNAME = new QName("", "referenciaRDS");
    private final static QName _DocumentoModelo_QNAME = new QName("", "modelo");
    private final static QName _DocumentoFirmas_QNAME = new QName("", "firmas");
    private final static QName _DocumentoDatosFichero_QNAME = new QName("", "datosFichero");
    private final static QName _DocumentoPlantilla_QNAME = new QName("", "plantilla");
    private final static QName _DocumentoVersion_QNAME = new QName("", "version");
    private final static QName _OficioRemisionTramiteSubsanacion_QNAME = new QName("", "tramiteSubsanacion");
    private final static QName _AvisoTextoSMS_QNAME = new QName("", "textoSMS");
    private final static QName _Fault_QNAME = new QName("urn:es:caib:regtel:ws:v2:model:BackofficeFacade", "fault");
    private final static QName _DetalleAcuseReciboAvisos_QNAME = new QName("", "avisos");
    private final static QName _DetalleAcuseReciboFicheroAcuseRecibo_QNAME = new QName("", "ficheroAcuseRecibo");
    private final static QName _DetalleAcuseReciboFechaAcuseRecibo_QNAME = new QName("", "fechaAcuseRecibo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.caib.regtel.ws.v2.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosRegistroSalida }
     * 
     */
    public DatosRegistroSalida createDatosRegistroSalida() {
        return new DatosRegistroSalida();
    }

    /**
     * Create an instance of {@link FirmaWS }
     * 
     */
    public FirmaWS createFirmaWS() {
        return new FirmaWS();
    }

    /**
     * Create an instance of {@link OficioRemision.TramiteSubsanacion }
     * 
     */
    public OficioRemision.TramiteSubsanacion createOficioRemisionTramiteSubsanacion() {
        return new OficioRemision.TramiteSubsanacion();
    }

    /**
     * Create an instance of {@link AnexosMap }
     * 
     */
    public AnexosMap createAnexosMap() {
        return new AnexosMap();
    }

    /**
     * Create an instance of {@link RegistroSalidaResponse }
     * 
     */
    public RegistroSalidaResponse createRegistroSalidaResponse() {
        return new RegistroSalidaResponse();
    }

    /**
     * Create an instance of {@link RegistroEntrada }
     * 
     */
    public RegistroEntrada createRegistroEntrada() {
        return new RegistroEntrada();
    }

    /**
     * Create an instance of {@link RegistroEntradaConFirma }
     * 
     */
    public RegistroEntradaConFirma createRegistroEntradaConFirma() {
        return new RegistroEntradaConFirma();
    }

    /**
     * Create an instance of {@link Documentos }
     * 
     */
    public Documentos createDocumentos() {
        return new Documentos();
    }

    /**
     * Create an instance of {@link RegistroEntradaConFirmaResponse }
     * 
     */
    public RegistroEntradaConFirmaResponse createRegistroEntradaConFirmaResponse() {
        return new RegistroEntradaConFirmaResponse();
    }

    /**
     * Create an instance of {@link DetalleAvisos }
     * 
     */
    public DetalleAvisos createDetalleAvisos() {
        return new DetalleAvisos();
    }

    /**
     * Create an instance of {@link DatosInteresado }
     * 
     */
    public DatosInteresado createDatosInteresado() {
        return new DatosInteresado();
    }

    /**
     * Create an instance of {@link Documento }
     * 
     */
    public Documento createDocumento() {
        return new Documento();
    }

    /**
     * Create an instance of {@link ObtenerAcuseRecibo }
     * 
     */
    public ObtenerAcuseRecibo createObtenerAcuseRecibo() {
        return new ObtenerAcuseRecibo();
    }

    /**
     * Create an instance of {@link DatosRepresentado }
     * 
     */
    public DatosRepresentado createDatosRepresentado() {
        return new DatosRepresentado();
    }

    /**
     * Create an instance of {@link ReferenciaRDSAsientoRegistral }
     * 
     */
    public ReferenciaRDSAsientoRegistral createReferenciaRDSAsientoRegistral() {
        return new ReferenciaRDSAsientoRegistral();
    }

    /**
     * Create an instance of {@link OficioRemision.TramiteSubsanacion.ParametrosTramite }
     * 
     */
    public OficioRemision.TramiteSubsanacion.ParametrosTramite createOficioRemisionTramiteSubsanacionParametrosTramite() {
        return new OficioRemision.TramiteSubsanacion.ParametrosTramite();
    }

    /**
     * Create an instance of {@link OficinaRegistral }
     * 
     */
    public OficinaRegistral createOficinaRegistral() {
        return new OficinaRegistral();
    }

    /**
     * Create an instance of {@link BackofficeFacadeException }
     * 
     */
    public BackofficeFacadeException createBackofficeFacadeException() {
        return new BackofficeFacadeException();
    }

    /**
     * Create an instance of {@link DetalleAcuseRecibo }
     * 
     */
    public DetalleAcuseRecibo createDetalleAcuseRecibo() {
        return new DetalleAcuseRecibo();
    }

    /**
     * Create an instance of {@link DatosAsunto }
     * 
     */
    public DatosAsunto createDatosAsunto() {
        return new DatosAsunto();
    }

    /**
     * Create an instance of {@link ObtenerDetalleAcuseRecibo }
     * 
     */
    public ObtenerDetalleAcuseRecibo createObtenerDetalleAcuseRecibo() {
        return new ObtenerDetalleAcuseRecibo();
    }

    /**
     * Create an instance of {@link DatosNotificacion }
     * 
     */
    public DatosNotificacion createDatosNotificacion() {
        return new DatosNotificacion();
    }

    /**
     * Create an instance of {@link DetalleAviso }
     * 
     */
    public DetalleAviso createDetalleAviso() {
        return new DetalleAviso();
    }

    /**
     * Create an instance of {@link PrepararRegistroEntrada }
     * 
     */
    public PrepararRegistroEntrada createPrepararRegistroEntrada() {
        return new PrepararRegistroEntrada();
    }

    /**
     * Create an instance of {@link IdentificacionRepresentadoDesglosada }
     * 
     */
    public IdentificacionRepresentadoDesglosada createIdentificacionRepresentadoDesglosada() {
        return new IdentificacionRepresentadoDesglosada();
    }

    /**
     * Create an instance of {@link PrepararRegistroEntradaResponse }
     * 
     */
    public PrepararRegistroEntradaResponse createPrepararRegistroEntradaResponse() {
        return new PrepararRegistroEntradaResponse();
    }

    /**
     * Create an instance of {@link ObtenerDetalleAcuseReciboResponse }
     * 
     */
    public ObtenerDetalleAcuseReciboResponse createObtenerDetalleAcuseReciboResponse() {
        return new ObtenerDetalleAcuseReciboResponse();
    }

    /**
     * Create an instance of {@link ResultadoRegistro }
     * 
     */
    public ResultadoRegistro createResultadoRegistro() {
        return new ResultadoRegistro();
    }

    /**
     * Create an instance of {@link AnexoItem }
     * 
     */
    public AnexoItem createAnexoItem() {
        return new AnexoItem();
    }

    /**
     * Create an instance of {@link ParametroTramite }
     * 
     */
    public ParametroTramite createParametroTramite() {
        return new ParametroTramite();
    }

    /**
     * Create an instance of {@link IdentificacionInteresadoDesglosada }
     * 
     */
    public IdentificacionInteresadoDesglosada createIdentificacionInteresadoDesglosada() {
        return new IdentificacionInteresadoDesglosada();
    }

    /**
     * Create an instance of {@link ReferenciaRDS }
     * 
     */
    public ReferenciaRDS createReferenciaRDS() {
        return new ReferenciaRDS();
    }

    /**
     * Create an instance of {@link Aviso }
     * 
     */
    public Aviso createAviso() {
        return new Aviso();
    }

    /**
     * Create an instance of {@link OficioRemision }
     * 
     */
    public OficioRemision createOficioRemision() {
        return new OficioRemision();
    }

    /**
     * Create an instance of {@link ObtenerAcuseReciboResponse }
     * 
     */
    public ObtenerAcuseReciboResponse createObtenerAcuseReciboResponse() {
        return new ObtenerAcuseReciboResponse();
    }

    /**
     * Create an instance of {@link DatosRegistroEntrada }
     * 
     */
    public DatosRegistroEntrada createDatosRegistroEntrada() {
        return new DatosRegistroEntrada();
    }

    /**
     * Create an instance of {@link AcuseRecibo }
     * 
     */
    public AcuseRecibo createAcuseRecibo() {
        return new AcuseRecibo();
    }

    /**
     * Create an instance of {@link FirmasWS }
     * 
     */
    public FirmasWS createFirmasWS() {
        return new FirmasWS();
    }

    /**
     * Create an instance of {@link DatosExpediente }
     * 
     */
    public DatosExpediente createDatosExpediente() {
        return new DatosExpediente();
    }

    /**
     * Create an instance of {@link RegistroEntradaResponse }
     * 
     */
    public RegistroEntradaResponse createRegistroEntradaResponse() {
        return new RegistroEntradaResponse();
    }

    /**
     * Create an instance of {@link ReferenciasRDS }
     * 
     */
    public ReferenciasRDS createReferenciasRDS() {
        return new ReferenciasRDS();
    }

    /**
     * Create an instance of {@link RegistroSalida }
     * 
     */
    public RegistroSalida createRegistroSalida() {
        return new RegistroSalida();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documentos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "documentos", scope = DatosRegistroSalida.class)
    public JAXBElement<Documentos> createDatosRegistroSalidaDocumentos(Documentos value) {
        return new JAXBElement<Documentos>(_DatosRegistroSalidaDocumentos_QNAME, Documentos.class, DatosRegistroSalida.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "formato", scope = FirmaWS.class)
    public JAXBElement<String> createFirmaWSFormato(String value) {
        return new JAXBElement<String>(_FirmaWSFormato_QNAME, String.class, FirmaWS.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OficioRemision.TramiteSubsanacion.ParametrosTramite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parametrosTramite", scope = OficioRemision.TramiteSubsanacion.class)
    public JAXBElement<OficioRemision.TramiteSubsanacion.ParametrosTramite> createOficioRemisionTramiteSubsanacionParametrosTramite(OficioRemision.TramiteSubsanacion.ParametrosTramite value) {
        return new JAXBElement<OficioRemision.TramiteSubsanacion.ParametrosTramite>(_OficioRemisionTramiteSubsanacionParametrosTramite_QNAME, OficioRemision.TramiteSubsanacion.ParametrosTramite.class, OficioRemision.TramiteSubsanacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "accesiblePorClave", scope = DatosNotificacion.class)
    public JAXBElement<Boolean> createDatosNotificacionAccesiblePorClave(Boolean value) {
        return new JAXBElement<Boolean>(_DatosNotificacionAccesiblePorClave_QNAME, Boolean.class, DatosNotificacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "plazo", scope = DatosNotificacion.class)
    public JAXBElement<Integer> createDatosNotificacionPlazo(Integer value) {
        return new JAXBElement<Integer>(_DatosNotificacionPlazo_QNAME, Integer.class, DatosNotificacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConfirmacionAviso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "confirmadoEnvio", scope = DetalleAviso.class)
    public JAXBElement<TipoConfirmacionAviso> createDetalleAvisoConfirmadoEnvio(TipoConfirmacionAviso value) {
        return new JAXBElement<TipoConfirmacionAviso>(_DetalleAvisoConfirmadoEnvio_QNAME, TipoConfirmacionAviso.class, DetalleAviso.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fechaEnvio", scope = DetalleAviso.class)
    public JAXBElement<XMLGregorianCalendar> createDetalleAvisoFechaEnvio(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DetalleAvisoFechaEnvio_QNAME, XMLGregorianCalendar.class, DetalleAviso.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", name = "diasPersistencia", scope = PrepararRegistroEntrada.class)
    public JAXBElement<String> createPrepararRegistroEntradaDiasPersistencia(String value) {
        return new JAXBElement<String>(_PrepararRegistroEntradaDiasPersistencia_QNAME, String.class, PrepararRegistroEntrada.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codigoPais", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoCodigoPais(String value) {
        return new JAXBElement<String>(_DatosInteresadoCodigoPais_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codigoProvincia", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoCodigoProvincia(String value) {
        return new JAXBElement<String>(_DatosInteresadoCodigoProvincia_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "autenticado", scope = DatosInteresado.class)
    public JAXBElement<Boolean> createDatosInteresadoAutenticado(Boolean value) {
        return new JAXBElement<Boolean>(_DatosInteresadoAutenticado_QNAME, Boolean.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombreLocalidad", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoNombreLocalidad(String value) {
        return new JAXBElement<String>(_DatosInteresadoNombreLocalidad_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codigoLocalidad", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoCodigoLocalidad(String value) {
        return new JAXBElement<String>(_DatosInteresadoCodigoLocalidad_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombreProvincia", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoNombreProvincia(String value) {
        return new JAXBElement<String>(_DatosInteresadoNombreProvincia_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombrePais", scope = DatosInteresado.class)
    public JAXBElement<String> createDatosInteresadoNombrePais(String value) {
        return new JAXBElement<String>(_DatosInteresadoNombrePais_QNAME, String.class, DatosInteresado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "extension", scope = Documento.class)
    public JAXBElement<String> createDocumentoExtension(String value) {
        return new JAXBElement<String>(_DocumentoExtension_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombre", scope = Documento.class)
    public JAXBElement<String> createDocumentoNombre(String value) {
        return new JAXBElement<String>(_DocumentoNombre_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenciaRDS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "referenciaRDS", scope = Documento.class)
    public JAXBElement<ReferenciaRDS> createDocumentoReferenciaRDS(ReferenciaRDS value) {
        return new JAXBElement<ReferenciaRDS>(_DocumentoReferenciaRDS_QNAME, ReferenciaRDS.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "modelo", scope = Documento.class)
    public JAXBElement<String> createDocumentoModelo(String value) {
        return new JAXBElement<String>(_DocumentoModelo_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmasWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "firmas", scope = Documento.class)
    public JAXBElement<FirmasWS> createDocumentoFirmas(FirmasWS value) {
        return new JAXBElement<FirmasWS>(_DocumentoFirmas_QNAME, FirmasWS.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datosFichero", scope = Documento.class)
    public JAXBElement<byte[]> createDocumentoDatosFichero(byte[] value) {
        return new JAXBElement<byte[]>(_DocumentoDatosFichero_QNAME, byte[].class, Documento.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "plantilla", scope = Documento.class)
    public JAXBElement<String> createDocumentoPlantilla(String value) {
        return new JAXBElement<String>(_DocumentoPlantilla_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "version", scope = Documento.class)
    public JAXBElement<Integer> createDocumentoVersion(Integer value) {
        return new JAXBElement<Integer>(_DocumentoVersion_QNAME, Integer.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OficioRemision.TramiteSubsanacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tramiteSubsanacion", scope = OficioRemision.class)
    public JAXBElement<OficioRemision.TramiteSubsanacion> createOficioRemisionTramiteSubsanacion(OficioRemision.TramiteSubsanacion value) {
        return new JAXBElement<OficioRemision.TramiteSubsanacion>(_OficioRemisionTramiteSubsanacion_QNAME, OficioRemision.TramiteSubsanacion.class, OficioRemision.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "textoSMS", scope = Aviso.class)
    public JAXBElement<String> createAvisoTextoSMS(String value) {
        return new JAXBElement<String>(_AvisoTextoSMS_QNAME, String.class, Aviso.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documentos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "documentos", scope = DatosRegistroEntrada.class)
    public JAXBElement<Documentos> createDatosRegistroEntradaDocumentos(Documentos value) {
        return new JAXBElement<Documentos>(_DatosRegistroSalidaDocumentos_QNAME, Documentos.class, DatosRegistroEntrada.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BackofficeFacadeException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", name = "fault")
    public JAXBElement<BackofficeFacadeException> createFault(BackofficeFacadeException value) {
        return new JAXBElement<BackofficeFacadeException>(_Fault_QNAME, BackofficeFacadeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetalleAvisos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "avisos", scope = DetalleAcuseRecibo.class)
    public JAXBElement<DetalleAvisos> createDetalleAcuseReciboAvisos(DetalleAvisos value) {
        return new JAXBElement<DetalleAvisos>(_DetalleAcuseReciboAvisos_QNAME, DetalleAvisos.class, DetalleAcuseRecibo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenciaRDS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ficheroAcuseRecibo", scope = DetalleAcuseRecibo.class)
    public JAXBElement<ReferenciaRDS> createDetalleAcuseReciboFicheroAcuseRecibo(ReferenciaRDS value) {
        return new JAXBElement<ReferenciaRDS>(_DetalleAcuseReciboFicheroAcuseRecibo_QNAME, ReferenciaRDS.class, DetalleAcuseRecibo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fechaAcuseRecibo", scope = DetalleAcuseRecibo.class)
    public JAXBElement<XMLGregorianCalendar> createDetalleAcuseReciboFechaAcuseRecibo(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DetalleAcuseReciboFechaAcuseRecibo_QNAME, XMLGregorianCalendar.class, DetalleAcuseRecibo.class, value);
    }

}
