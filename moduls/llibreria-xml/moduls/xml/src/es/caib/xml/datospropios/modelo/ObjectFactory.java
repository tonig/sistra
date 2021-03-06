//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.19 at 01:07:26 PM CEST 
//


package es.caib.xml.datospropios.modelo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.caib.xml.datospropios.modelo package. 
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

    private final static QName _DESCRIPCION_QNAME = new QName("", "DESCRIPCION");
    private final static QName _AVISOEMAIL_QNAME = new QName("", "AVISO_EMAIL");
    private final static QName _HABILITARAVISOS_QNAME = new QName("", "HABILITAR_AVISOS");
    private final static QName _AVISOSMS_QNAME = new QName("", "AVISO_SMS");
    private final static QName _VALOR_QNAME = new QName("", "VALOR");
    private final static QName _HABILITARNOTIFICACIONTELEMATICA_QNAME = new QName("", "HABILITAR_NOTIFICACION_TELEMATICA");
    private final static QName _IDENTIFICADORPROCEDIMIENTO_QNAME = new QName("", "IDENTIFICADOR_PROCEDIMIENTO");
    private final static QName _TEXTOFECHATOPEENTREGA_QNAME = new QName("", "TEXTO_FECHA_TOPE_ENTREGA");
    private final static QName _FECHATOPEENTREGA_QNAME = new QName("", "FECHA_TOPE_ENTREGA");
    private final static QName _IDENTIFICADORPERSISTENCIA_QNAME = new QName("", "IDENTIFICADOR_PERSISTENCIA");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.caib.xml.datospropios.modelo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FORMULARIOSJUSTIFICANTE }
     * 
     */
    public FORMULARIOSJUSTIFICANTE createFORMULARIOSJUSTIFICANTE() {
        return new FORMULARIOSJUSTIFICANTE();
    }

    /**
     * Create an instance of {@link TRAMITESUBSANACION }
     * 
     */
    public TRAMITESUBSANACION createTRAMITESUBSANACION() {
        return new TRAMITESUBSANACION();
    }

    /**
     * Create an instance of {@link ALERTASTRAMITACION }
     * 
     */
    public ALERTASTRAMITACION createALERTASTRAMITACION() {
        return new ALERTASTRAMITACION();
    }

    /**
     * Create an instance of {@link PERSONALIZACIONJUSTIFICANTE }
     * 
     */
    public PERSONALIZACIONJUSTIFICANTE createPERSONALIZACIONJUSTIFICANTE() {
        return new PERSONALIZACIONJUSTIFICANTE();
    }

    /**
     * Create an instance of {@link DOCUMENTO }
     * 
     */
    public DOCUMENTO createDOCUMENTO() {
        return new DOCUMENTO();
    }

    /**
     * Create an instance of {@link SOLICITUD }
     * 
     */
    public SOLICITUD createSOLICITUD() {
        return new SOLICITUD();
    }

    /**
     * Create an instance of {@link DOCUMENTOSENTREGAR }
     * 
     */
    public DOCUMENTOSENTREGAR createDOCUMENTOSENTREGAR() {
        return new DOCUMENTOSENTREGAR();
    }

    /**
     * Create an instance of {@link DATOSPROPIOS }
     * 
     */
    public DATOSPROPIOS createDATOSPROPIOS() {
        return new DATOSPROPIOS();
    }

    /**
     * Create an instance of {@link INSTRUCCIONES }
     * 
     */
    public INSTRUCCIONES createINSTRUCCIONES() {
        return new INSTRUCCIONES();
    }

    /**
     * Create an instance of {@link DATO }
     * 
     */
    public DATO createDATO() {
        return new DATO();
    }

    /**
     * Create an instance of {@link FORMULARIOJUSTIFICANTE }
     * 
     */
    public FORMULARIOJUSTIFICANTE createFORMULARIOJUSTIFICANTE() {
        return new FORMULARIOJUSTIFICANTE();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DESCRIPCION")
    public JAXBElement<String> createDESCRIPCION(String value) {
        return new JAXBElement<String>(_DESCRIPCION_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AVISO_EMAIL")
    public JAXBElement<String> createAVISOEMAIL(String value) {
        return new JAXBElement<String>(_AVISOEMAIL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HABILITAR_AVISOS")
    public JAXBElement<String> createHABILITARAVISOS(String value) {
        return new JAXBElement<String>(_HABILITARAVISOS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AVISO_SMS")
    public JAXBElement<String> createAVISOSMS(String value) {
        return new JAXBElement<String>(_AVISOSMS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VALOR")
    public JAXBElement<String> createVALOR(String value) {
        return new JAXBElement<String>(_VALOR_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HABILITAR_NOTIFICACION_TELEMATICA")
    public JAXBElement<String> createHABILITARNOTIFICACIONTELEMATICA(String value) {
        return new JAXBElement<String>(_HABILITARNOTIFICACIONTELEMATICA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IDENTIFICADOR_PROCEDIMIENTO")
    public JAXBElement<String> createIDENTIFICADORPROCEDIMIENTO(String value) {
        return new JAXBElement<String>(_IDENTIFICADORPROCEDIMIENTO_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TEXTO_FECHA_TOPE_ENTREGA")
    public JAXBElement<String> createTEXTOFECHATOPEENTREGA(String value) {
        return new JAXBElement<String>(_TEXTOFECHATOPEENTREGA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FECHA_TOPE_ENTREGA")
    public JAXBElement<String> createFECHATOPEENTREGA(String value) {
        return new JAXBElement<String>(_FECHATOPEENTREGA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IDENTIFICADOR_PERSISTENCIA")
    public JAXBElement<String> createIDENTIFICADORPERSISTENCIA(String value) {
        return new JAXBElement<String>(_IDENTIFICADORPERSISTENCIA_QNAME, String.class, null, value);
    }

}
