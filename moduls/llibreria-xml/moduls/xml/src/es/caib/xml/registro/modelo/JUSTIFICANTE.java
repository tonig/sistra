//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.22 at 10:40:52 AM CEST 
//


package es.caib.xml.registro.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}ASIENTO_REGISTRAL"/>
 *         &lt;element ref="{}NUMERO_REGISTRO"/>
 *         &lt;element ref="{}FECHA_REGISTRO"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "asientoregistral",
    "numeroregistro",
    "fecharegistro"
})
@XmlRootElement(name = "JUSTIFICANTE")
public class JUSTIFICANTE {

    @XmlElement(name = "ASIENTO_REGISTRAL", required = true)
    protected ASIENTOREGISTRAL asientoregistral;
    @XmlElement(name = "NUMERO_REGISTRO", required = true)
    protected String numeroregistro;
    @XmlElement(name = "FECHA_REGISTRO", required = true)
    protected String fecharegistro;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String version;

    /**
     * Gets the value of the asientoregistral property.
     * 
     * @return
     *     possible object is
     *     {@link ASIENTOREGISTRAL }
     *     
     */
    public ASIENTOREGISTRAL getASIENTOREGISTRAL() {
        return asientoregistral;
    }

    /**
     * Sets the value of the asientoregistral property.
     * 
     * @param value
     *     allowed object is
     *     {@link ASIENTOREGISTRAL }
     *     
     */
    public void setASIENTOREGISTRAL(ASIENTOREGISTRAL value) {
        this.asientoregistral = value;
    }

    /**
     * Gets the value of the numeroregistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMEROREGISTRO() {
        return numeroregistro;
    }

    /**
     * Sets the value of the numeroregistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMEROREGISTRO(String value) {
        this.numeroregistro = value;
    }

    /**
     * Gets the value of the fecharegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFECHAREGISTRO() {
        return fecharegistro;
    }

    /**
     * Sets the value of the fecharegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFECHAREGISTRO(String value) {
        this.fecharegistro = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
