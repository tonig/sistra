//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.01 at 03:20:58 PM CEST 
//


package es.caib.xml.documentoExternoNotificacion.modelo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.caib.xml.documentoExternoNotificacion.modelo package. 
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

    private final static QName _NOMBRE_QNAME = new QName("", "NOMBRE");
    private final static QName _URL_QNAME = new QName("", "URL");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.caib.xml.documentoExternoNotificacion.modelo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DOCUMENTOEXTERNONOTIFICACION }
     * 
     */
    public DOCUMENTOEXTERNONOTIFICACION createDOCUMENTOEXTERNONOTIFICACION() {
        return new DOCUMENTOEXTERNONOTIFICACION();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NOMBRE")
    public JAXBElement<String> createNOMBRE(String value) {
        return new JAXBElement<String>(_NOMBRE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "URL")
    public JAXBElement<String> createURL(String value) {
        return new JAXBElement<String>(_URL_QNAME, String.class, null, value);
    }

}
