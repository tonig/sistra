//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.19 at 01:07:26 PM CEST 
//


package es.caib.xml.datospropios.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="TITULO" type="{}string_no_vacio"/>
 *         &lt;element name="IDENTIFICADOR" type="{}string_no_vacio" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TIPO" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="J"/>
 *             &lt;enumeration value="F"/>
 *             &lt;enumeration value="G"/>
 *             &lt;enumeration value="A"/>
 *             &lt;enumeration value="P"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FIRMAR" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="COMPULSAR" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="FOTOCOPIA" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "titulo",
    "identificador"
})
@XmlRootElement(name = "DOCUMENTO")
public class DOCUMENTO {

    @XmlElement(name = "TITULO", required = true)
    protected String titulo;
    @XmlElement(name = "IDENTIFICADOR")
    protected String identificador;
    @XmlAttribute(name = "TIPO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipo;
    @XmlAttribute(name = "FIRMAR")
    protected Boolean firmar;
    @XmlAttribute(name = "COMPULSAR")
    protected Boolean compulsar;
    @XmlAttribute(name = "FOTOCOPIA")
    protected Boolean fotocopia;

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITULO() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITULO(String value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the identificador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDENTIFICADOR() {
        return identificador;
    }

    /**
     * Sets the value of the identificador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDENTIFICADOR(String value) {
        this.identificador = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPO() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPO(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the firmar property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFIRMAR() {
        return firmar;
    }

    /**
     * Sets the value of the firmar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFIRMAR(Boolean value) {
        this.firmar = value;
    }

    /**
     * Gets the value of the compulsar property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCOMPULSAR() {
        return compulsar;
    }

    /**
     * Sets the value of the compulsar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCOMPULSAR(Boolean value) {
        this.compulsar = value;
    }

    /**
     * Gets the value of the fotocopia property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFOTOCOPIA() {
        return fotocopia;
    }

    /**
     * Sets the value of the fotocopia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFOTOCOPIA(Boolean value) {
        this.fotocopia = value;
    }

}
