//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.22 at 10:40:52 AM CEST 
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
 *         &lt;element ref="{}NOMBRE_INTERESADO"/>
 *         &lt;element ref="{}APELLIDO1_INTERESADO" minOccurs="0"/>
 *         &lt;element ref="{}APELLIDO2_INTERESADO" minOccurs="0"/>
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
    "nombreinteresado",
    "apellido1INTERESADO",
    "apellido2INTERESADO"
})
@XmlRootElement(name = "IDENTIFICACION_INTERESADO_DESGLOSADA")
public class IDENTIFICACIONINTERESADODESGLOSADA {

    @XmlElement(name = "NOMBRE_INTERESADO", required = true)
    protected String nombreinteresado;
    @XmlElement(name = "APELLIDO1_INTERESADO")
    protected String apellido1INTERESADO;
    @XmlElement(name = "APELLIDO2_INTERESADO")
    protected String apellido2INTERESADO;

    /**
     * Gets the value of the nombreinteresado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMBREINTERESADO() {
        return nombreinteresado;
    }

    /**
     * Sets the value of the nombreinteresado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMBREINTERESADO(String value) {
        this.nombreinteresado = value;
    }

    /**
     * Gets the value of the apellido1INTERESADO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPELLIDO1INTERESADO() {
        return apellido1INTERESADO;
    }

    /**
     * Sets the value of the apellido1INTERESADO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPELLIDO1INTERESADO(String value) {
        this.apellido1INTERESADO = value;
    }

    /**
     * Gets the value of the apellido2INTERESADO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPELLIDO2INTERESADO() {
        return apellido2INTERESADO;
    }

    /**
     * Sets the value of the apellido2INTERESADO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPELLIDO2INTERESADO(String value) {
        this.apellido2INTERESADO = value;
    }

}
