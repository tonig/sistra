//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.07 at 08:58:40 AM CEST 
//


package es.caib.xml.movilidad.modelo;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}MENSAJE_SMS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}MENSAJE_EMAIL" maxOccurs="unbounded" minOccurs="0"/>
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
    "mensajesms",
    "mensajeemail"
})
@XmlRootElement(name = "MENSAJES")
public class MENSAJES {

    @XmlElement(name = "MENSAJE_SMS")
    protected List<MENSAJESMS> mensajesms;
    @XmlElement(name = "MENSAJE_EMAIL")
    protected List<MENSAJEEMAIL> mensajeemail;

    /**
     * Gets the value of the mensajesms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mensajesms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMENSAJESMS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MENSAJESMS }
     * 
     * 
     */
    public List<MENSAJESMS> getMENSAJESMS() {
        if (mensajesms == null) {
            mensajesms = new ArrayList<MENSAJESMS>();
        }
        return this.mensajesms;
    }

    /**
     * Gets the value of the mensajeemail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mensajeemail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMENSAJEEMAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MENSAJEEMAIL }
     * 
     * 
     */
    public List<MENSAJEEMAIL> getMENSAJEEMAIL() {
        if (mensajeemail == null) {
            mensajeemail = new ArrayList<MENSAJEEMAIL>();
        }
        return this.mensajeemail;
    }

}
