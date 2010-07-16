//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.07 at 08:58:49 AM CEST 
//


package es.caib.xml.registro.modelo;

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
 *         &lt;element ref="{}ESTRUCTURADO"/>
 *         &lt;element ref="{}TIPO_DE_DOCUMENTO"/>
 *         &lt;element ref="{}IDENTIFICADOR_DOCUMENTO"/>
 *         &lt;element ref="{}CODIGO_RDS"/>
 *         &lt;element ref="{}NOMBRE_DOCUMENTO"/>
 *         &lt;element ref="{}EXTRACTO_DOCUMENTO" minOccurs="0"/>
 *         &lt;element ref="{}HASH_DOCUMENTO"/>
 *         &lt;element ref="{}CODIGO_NORMALIZADO" minOccurs="0"/>
 *         &lt;element ref="{}FIRMA_TERCEROS" minOccurs="0"/>
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
    "estructurado",
    "tipodedocumento",
    "identificadordocumento",
    "codigords",
    "nombredocumento",
    "extractodocumento",
    "hashdocumento",
    "codigonormalizado",
    "firmaterceros"
})
@XmlRootElement(name = "DATOS_ANEXO_DOCUMENTACION")
public class DATOSANEXODOCUMENTACION {

    @XmlElement(name = "ESTRUCTURADO", required = true)
    protected String estructurado;
    @XmlElement(name = "TIPO_DE_DOCUMENTO", required = true)
    protected String tipodedocumento;
    @XmlElement(name = "IDENTIFICADOR_DOCUMENTO", required = true)
    protected String identificadordocumento;
    @XmlElement(name = "CODIGO_RDS", required = true)
    protected String codigords;
    @XmlElement(name = "NOMBRE_DOCUMENTO", required = true)
    protected String nombredocumento;
    @XmlElement(name = "EXTRACTO_DOCUMENTO")
    protected String extractodocumento;
    @XmlElement(name = "HASH_DOCUMENTO", required = true)
    protected String hashdocumento;
    @XmlElement(name = "CODIGO_NORMALIZADO")
    protected String codigonormalizado;
    @XmlElement(name = "FIRMA_TERCEROS")
    protected String firmaterceros;

    /**
     * Gets the value of the estructurado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESTRUCTURADO() {
        return estructurado;
    }

    /**
     * Sets the value of the estructurado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESTRUCTURADO(String value) {
        this.estructurado = value;
    }

    /**
     * Gets the value of the tipodedocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPODEDOCUMENTO() {
        return tipodedocumento;
    }

    /**
     * Sets the value of the tipodedocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPODEDOCUMENTO(String value) {
        this.tipodedocumento = value;
    }

    /**
     * Gets the value of the identificadordocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDENTIFICADORDOCUMENTO() {
        return identificadordocumento;
    }

    /**
     * Sets the value of the identificadordocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDENTIFICADORDOCUMENTO(String value) {
        this.identificadordocumento = value;
    }

    /**
     * Gets the value of the codigords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODIGORDS() {
        return codigords;
    }

    /**
     * Sets the value of the codigords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODIGORDS(String value) {
        this.codigords = value;
    }

    /**
     * Gets the value of the nombredocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMBREDOCUMENTO() {
        return nombredocumento;
    }

    /**
     * Sets the value of the nombredocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMBREDOCUMENTO(String value) {
        this.nombredocumento = value;
    }

    /**
     * Gets the value of the extractodocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTRACTODOCUMENTO() {
        return extractodocumento;
    }

    /**
     * Sets the value of the extractodocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTRACTODOCUMENTO(String value) {
        this.extractodocumento = value;
    }

    /**
     * Gets the value of the hashdocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHASHDOCUMENTO() {
        return hashdocumento;
    }

    /**
     * Sets the value of the hashdocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHASHDOCUMENTO(String value) {
        this.hashdocumento = value;
    }

    /**
     * Gets the value of the codigonormalizado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODIGONORMALIZADO() {
        return codigonormalizado;
    }

    /**
     * Sets the value of the codigonormalizado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODIGONORMALIZADO(String value) {
        this.codigonormalizado = value;
    }

    /**
     * Gets the value of the firmaterceros property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIRMATERCEROS() {
        return firmaterceros;
    }

    /**
     * Sets the value of the firmaterceros property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIRMATERCEROS(String value) {
        this.firmaterceros = value;
    }

}
