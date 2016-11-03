
package es.caib.regtel.ws.v1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ResultadoRegistro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultadoRegistro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="referecinaRDSJustificante" type="{urn:es:caib:regtel:ws:v1:model:ReferenciaRDS}ReferenciaRDS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultadoRegistro", namespace = "urn:es:caib:regtel:ws:v1:model:ResultadoRegistro", propOrder = {
    "numeroRegistro",
    "fechaRegistro",
    "referecinaRDSJustificante"
})
public class ResultadoRegistro {

    @XmlElement(required = true)
    protected String numeroRegistro;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaRegistro;
    @XmlElement(required = true)
    protected ReferenciaRDS referecinaRDSJustificante;

    /**
     * Gets the value of the numeroRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    /**
     * Sets the value of the numeroRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRegistro(String value) {
        this.numeroRegistro = value;
    }

    /**
     * Gets the value of the fechaRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Sets the value of the fechaRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegistro(XMLGregorianCalendar value) {
        this.fechaRegistro = value;
    }

    /**
     * Gets the value of the referecinaRDSJustificante property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenciaRDS }
     *     
     */
    public ReferenciaRDS getReferecinaRDSJustificante() {
        return referecinaRDSJustificante;
    }

    /**
     * Sets the value of the referecinaRDSJustificante property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenciaRDS }
     *     
     */
    public void setReferecinaRDSJustificante(ReferenciaRDS value) {
        this.referecinaRDSJustificante = value;
    }

}
