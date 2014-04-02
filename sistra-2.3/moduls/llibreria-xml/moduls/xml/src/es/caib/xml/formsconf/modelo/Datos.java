//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.24 at 12:21:56 PM CET 
//


package es.caib.xml.formsconf.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}idioma"/>
 *         &lt;element ref="{}modelo"/>
 *         &lt;element ref="{}version"/>
 *         &lt;element ref="{}codigoPerfil" minOccurs="0"/>
 *         &lt;element ref="{}layout" minOccurs="0"/>
 *         &lt;element ref="{}guardarSinTerminar" minOccurs="0"/>
 *         &lt;element ref="{}urlSisTraOK"/>
 *         &lt;element ref="{}urlRedireccionOK"/>
 *         &lt;element ref="{}urlSisTraCancel"/>
 *         &lt;element ref="{}urlRedireccionCancel"/>
 *         &lt;element ref="{}urlSisTraMantenimientoSesion"/>
 *         &lt;element ref="{}nomParamXMLDatosIni"/>
 *         &lt;element ref="{}nomParamXMLDatosFin"/>
 *         &lt;element ref="{}nomParamXMLSinTerminar"/>
 *         &lt;element ref="{}nomParamTokenRetorno"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idioma",
    "modelo",
    "version",
    "codigoPerfil",
    "layout",
    "guardarSinTerminar",
    "urlSisTraOK",
    "urlRedireccionOK",
    "urlSisTraCancel",
    "urlRedireccionCancel",
    "urlSisTraMantenimientoSesion",
    "nomParamXMLDatosIni",
    "nomParamXMLDatosFin",
    "nomParamXMLSinTerminar",
    "nomParamTokenRetorno"
})
@XmlRootElement(name = "datos")
public class Datos {

    @XmlElement(required = true)
    protected String idioma;
    @XmlElement(required = true)
    protected String modelo;
    protected int version;
    protected String codigoPerfil;
    protected String layout;
    protected String guardarSinTerminar;
    @XmlElement(required = true)
    protected String urlSisTraOK;
    @XmlElement(required = true)
    protected String urlRedireccionOK;
    @XmlElement(required = true)
    protected String urlSisTraCancel;
    @XmlElement(required = true)
    protected String urlRedireccionCancel;
    @XmlElement(required = true)
    protected String urlSisTraMantenimientoSesion;
    @XmlElement(required = true)
    protected String nomParamXMLDatosIni;
    @XmlElement(required = true)
    protected String nomParamXMLDatosFin;
    @XmlElement(required = true)
    protected String nomParamXMLSinTerminar;
    @XmlElement(required = true)
    protected String nomParamTokenRetorno;

    /**
     * Gets the value of the idioma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Sets the value of the idioma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdioma(String value) {
        this.idioma = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(String value) {
        this.modelo = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the codigoPerfil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    /**
     * Sets the value of the codigoPerfil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPerfil(String value) {
        this.codigoPerfil = value;
    }

    /**
     * Gets the value of the layout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayout(String value) {
        this.layout = value;
    }

    /**
     * Gets the value of the guardarSinTerminar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuardarSinTerminar() {
        return guardarSinTerminar;
    }

    /**
     * Sets the value of the guardarSinTerminar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuardarSinTerminar(String value) {
        this.guardarSinTerminar = value;
    }

    /**
     * Gets the value of the urlSisTraOK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlSisTraOK() {
        return urlSisTraOK;
    }

    /**
     * Sets the value of the urlSisTraOK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlSisTraOK(String value) {
        this.urlSisTraOK = value;
    }

    /**
     * Gets the value of the urlRedireccionOK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlRedireccionOK() {
        return urlRedireccionOK;
    }

    /**
     * Sets the value of the urlRedireccionOK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlRedireccionOK(String value) {
        this.urlRedireccionOK = value;
    }

    /**
     * Gets the value of the urlSisTraCancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlSisTraCancel() {
        return urlSisTraCancel;
    }

    /**
     * Sets the value of the urlSisTraCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlSisTraCancel(String value) {
        this.urlSisTraCancel = value;
    }

    /**
     * Gets the value of the urlRedireccionCancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlRedireccionCancel() {
        return urlRedireccionCancel;
    }

    /**
     * Sets the value of the urlRedireccionCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlRedireccionCancel(String value) {
        this.urlRedireccionCancel = value;
    }

    /**
     * Gets the value of the urlSisTraMantenimientoSesion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlSisTraMantenimientoSesion() {
        return urlSisTraMantenimientoSesion;
    }

    /**
     * Sets the value of the urlSisTraMantenimientoSesion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlSisTraMantenimientoSesion(String value) {
        this.urlSisTraMantenimientoSesion = value;
    }

    /**
     * Gets the value of the nomParamXMLDatosIni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomParamXMLDatosIni() {
        return nomParamXMLDatosIni;
    }

    /**
     * Sets the value of the nomParamXMLDatosIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomParamXMLDatosIni(String value) {
        this.nomParamXMLDatosIni = value;
    }

    /**
     * Gets the value of the nomParamXMLDatosFin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomParamXMLDatosFin() {
        return nomParamXMLDatosFin;
    }

    /**
     * Sets the value of the nomParamXMLDatosFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomParamXMLDatosFin(String value) {
        this.nomParamXMLDatosFin = value;
    }

    /**
     * Gets the value of the nomParamXMLSinTerminar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomParamXMLSinTerminar() {
        return nomParamXMLSinTerminar;
    }

    /**
     * Sets the value of the nomParamXMLSinTerminar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomParamXMLSinTerminar(String value) {
        this.nomParamXMLSinTerminar = value;
    }

    /**
     * Gets the value of the nomParamTokenRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomParamTokenRetorno() {
        return nomParamTokenRetorno;
    }

    /**
     * Sets the value of the nomParamTokenRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomParamTokenRetorno(String value) {
        this.nomParamTokenRetorno = value;
    }

}
