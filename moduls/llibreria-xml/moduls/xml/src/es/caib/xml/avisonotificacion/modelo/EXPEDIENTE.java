//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.19 at 03:29:26 PM CEST 
//


package es.caib.xml.avisonotificacion.modelo;

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
 *         &lt;element ref="{}UNIDAD_ADMINISTRATIVA"/>
 *         &lt;element ref="{}IDENTIFICADOR_EXPEDIENTE"/>
 *         &lt;element name="CLAVE_EXPEDIENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TITULO_EXPEDIENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "unidadadministrativa",
    "identificadorexpediente",
    "claveexpediente",
    "tituloexpediente"
})
@XmlRootElement(name = "EXPEDIENTE")
public class EXPEDIENTE {

    @XmlElement(name = "UNIDAD_ADMINISTRATIVA", required = true)
    protected String unidadadministrativa;
    @XmlElement(name = "IDENTIFICADOR_EXPEDIENTE", required = true)
    protected String identificadorexpediente;
    @XmlElement(name = "CLAVE_EXPEDIENTE")
    protected String claveexpediente;
    @XmlElement(name = "TITULO_EXPEDIENTE")
    protected String tituloexpediente;

    /**
     * Gets the value of the unidadadministrativa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNIDADADMINISTRATIVA() {
        return unidadadministrativa;
    }

    /**
     * Sets the value of the unidadadministrativa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNIDADADMINISTRATIVA(String value) {
        this.unidadadministrativa = value;
    }

    /**
     * Gets the value of the identificadorexpediente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDENTIFICADOREXPEDIENTE() {
        return identificadorexpediente;
    }

    /**
     * Sets the value of the identificadorexpediente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDENTIFICADOREXPEDIENTE(String value) {
        this.identificadorexpediente = value;
    }

    /**
     * Gets the value of the claveexpediente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLAVEEXPEDIENTE() {
        return claveexpediente;
    }

    /**
     * Sets the value of the claveexpediente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLAVEEXPEDIENTE(String value) {
        this.claveexpediente = value;
    }

    /**
     * Gets the value of the tituloexpediente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITULOEXPEDIENTE() {
        return tituloexpediente;
    }

    /**
     * Sets the value of the tituloexpediente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITULOEXPEDIENTE(String value) {
        this.tituloexpediente = value;
    }

}
