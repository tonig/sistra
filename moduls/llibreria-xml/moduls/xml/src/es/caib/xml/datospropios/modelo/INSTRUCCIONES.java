//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.19 at 01:07:26 PM CEST 
//


package es.caib.xml.datospropios.modelo;

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
 *         &lt;element name="TEXTO_INSTRUCCIONES" type="{}string_no_vacio"/>
 *         &lt;element ref="{}DOCUMENTOS_ENTREGAR" minOccurs="0"/>
 *         &lt;element ref="{}FECHA_TOPE_ENTREGA" minOccurs="0"/>
 *         &lt;element ref="{}TEXTO_FECHA_TOPE_ENTREGA" minOccurs="0"/>
 *         &lt;element ref="{}IDENTIFICADOR_PERSISTENCIA" minOccurs="0"/>
 *         &lt;element ref="{}IDENTIFICADOR_PROCEDIMIENTO" minOccurs="0"/>
 *         &lt;element ref="{}HABILITAR_NOTIFICACION_TELEMATICA" minOccurs="0"/>
 *         &lt;element ref="{}HABILITAR_AVISOS" minOccurs="0"/>
 *         &lt;element ref="{}AVISO_SMS" minOccurs="0"/>
 *         &lt;element ref="{}AVISO_EMAIL" minOccurs="0"/>
 *         &lt;element ref="{}TRAMITE_SUBSANACION" minOccurs="0"/>
 *         &lt;element ref="{}FORMULARIOS_JUSTIFICANTE" minOccurs="0"/>
 *         &lt;element ref="{}PERSONALIZACION_JUSTIFICANTE" minOccurs="0"/>
 *         &lt;element ref="{}ALERTAS_TRAMITACION" minOccurs="0"/>
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
    "textoinstrucciones",
    "documentosentregar",
    "fechatopeentrega",
    "textofechatopeentrega",
    "identificadorpersistencia",
    "identificadorprocedimiento",
    "habilitarnotificaciontelematica",
    "habilitaravisos",
    "avisosms",
    "avisoemail",
    "tramitesubsanacion",
    "formulariosjustificante",
    "personalizacionjustificante",
    "alertastramitacion"
})
@XmlRootElement(name = "INSTRUCCIONES")
public class INSTRUCCIONES {

    @XmlElement(name = "TEXTO_INSTRUCCIONES", required = true)
    protected String textoinstrucciones;
    @XmlElement(name = "DOCUMENTOS_ENTREGAR")
    protected DOCUMENTOSENTREGAR documentosentregar;
    @XmlElement(name = "FECHA_TOPE_ENTREGA")
    protected String fechatopeentrega;
    @XmlElement(name = "TEXTO_FECHA_TOPE_ENTREGA")
    protected String textofechatopeentrega;
    @XmlElement(name = "IDENTIFICADOR_PERSISTENCIA")
    protected String identificadorpersistencia;
    @XmlElement(name = "IDENTIFICADOR_PROCEDIMIENTO")
    protected String identificadorprocedimiento;
    @XmlElement(name = "HABILITAR_NOTIFICACION_TELEMATICA")
    protected String habilitarnotificaciontelematica;
    @XmlElement(name = "HABILITAR_AVISOS")
    protected String habilitaravisos;
    @XmlElement(name = "AVISO_SMS")
    protected String avisosms;
    @XmlElement(name = "AVISO_EMAIL")
    protected String avisoemail;
    @XmlElement(name = "TRAMITE_SUBSANACION")
    protected TRAMITESUBSANACION tramitesubsanacion;
    @XmlElement(name = "FORMULARIOS_JUSTIFICANTE")
    protected FORMULARIOSJUSTIFICANTE formulariosjustificante;
    @XmlElement(name = "PERSONALIZACION_JUSTIFICANTE")
    protected PERSONALIZACIONJUSTIFICANTE personalizacionjustificante;
    @XmlElement(name = "ALERTAS_TRAMITACION")
    protected ALERTASTRAMITACION alertastramitacion;

    /**
     * Gets the value of the textoinstrucciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEXTOINSTRUCCIONES() {
        return textoinstrucciones;
    }

    /**
     * Sets the value of the textoinstrucciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEXTOINSTRUCCIONES(String value) {
        this.textoinstrucciones = value;
    }

    /**
     * Gets the value of the documentosentregar property.
     * 
     * @return
     *     possible object is
     *     {@link DOCUMENTOSENTREGAR }
     *     
     */
    public DOCUMENTOSENTREGAR getDOCUMENTOSENTREGAR() {
        return documentosentregar;
    }

    /**
     * Sets the value of the documentosentregar property.
     * 
     * @param value
     *     allowed object is
     *     {@link DOCUMENTOSENTREGAR }
     *     
     */
    public void setDOCUMENTOSENTREGAR(DOCUMENTOSENTREGAR value) {
        this.documentosentregar = value;
    }

    /**
     * Gets the value of the fechatopeentrega property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFECHATOPEENTREGA() {
        return fechatopeentrega;
    }

    /**
     * Sets the value of the fechatopeentrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFECHATOPEENTREGA(String value) {
        this.fechatopeentrega = value;
    }

    /**
     * Gets the value of the textofechatopeentrega property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEXTOFECHATOPEENTREGA() {
        return textofechatopeentrega;
    }

    /**
     * Sets the value of the textofechatopeentrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEXTOFECHATOPEENTREGA(String value) {
        this.textofechatopeentrega = value;
    }

    /**
     * Gets the value of the identificadorpersistencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDENTIFICADORPERSISTENCIA() {
        return identificadorpersistencia;
    }

    /**
     * Sets the value of the identificadorpersistencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDENTIFICADORPERSISTENCIA(String value) {
        this.identificadorpersistencia = value;
    }

    /**
     * Gets the value of the identificadorprocedimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDENTIFICADORPROCEDIMIENTO() {
        return identificadorprocedimiento;
    }

    /**
     * Sets the value of the identificadorprocedimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDENTIFICADORPROCEDIMIENTO(String value) {
        this.identificadorprocedimiento = value;
    }

    /**
     * Gets the value of the habilitarnotificaciontelematica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHABILITARNOTIFICACIONTELEMATICA() {
        return habilitarnotificaciontelematica;
    }

    /**
     * Sets the value of the habilitarnotificaciontelematica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHABILITARNOTIFICACIONTELEMATICA(String value) {
        this.habilitarnotificaciontelematica = value;
    }

    /**
     * Gets the value of the habilitaravisos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHABILITARAVISOS() {
        return habilitaravisos;
    }

    /**
     * Sets the value of the habilitaravisos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHABILITARAVISOS(String value) {
        this.habilitaravisos = value;
    }

    /**
     * Gets the value of the avisosms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAVISOSMS() {
        return avisosms;
    }

    /**
     * Sets the value of the avisosms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAVISOSMS(String value) {
        this.avisosms = value;
    }

    /**
     * Gets the value of the avisoemail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAVISOEMAIL() {
        return avisoemail;
    }

    /**
     * Sets the value of the avisoemail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAVISOEMAIL(String value) {
        this.avisoemail = value;
    }

    /**
     * Gets the value of the tramitesubsanacion property.
     * 
     * @return
     *     possible object is
     *     {@link TRAMITESUBSANACION }
     *     
     */
    public TRAMITESUBSANACION getTRAMITESUBSANACION() {
        return tramitesubsanacion;
    }

    /**
     * Sets the value of the tramitesubsanacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRAMITESUBSANACION }
     *     
     */
    public void setTRAMITESUBSANACION(TRAMITESUBSANACION value) {
        this.tramitesubsanacion = value;
    }

    /**
     * Gets the value of the formulariosjustificante property.
     * 
     * @return
     *     possible object is
     *     {@link FORMULARIOSJUSTIFICANTE }
     *     
     */
    public FORMULARIOSJUSTIFICANTE getFORMULARIOSJUSTIFICANTE() {
        return formulariosjustificante;
    }

    /**
     * Sets the value of the formulariosjustificante property.
     * 
     * @param value
     *     allowed object is
     *     {@link FORMULARIOSJUSTIFICANTE }
     *     
     */
    public void setFORMULARIOSJUSTIFICANTE(FORMULARIOSJUSTIFICANTE value) {
        this.formulariosjustificante = value;
    }

    /**
     * Gets the value of the personalizacionjustificante property.
     * 
     * @return
     *     possible object is
     *     {@link PERSONALIZACIONJUSTIFICANTE }
     *     
     */
    public PERSONALIZACIONJUSTIFICANTE getPERSONALIZACIONJUSTIFICANTE() {
        return personalizacionjustificante;
    }

    /**
     * Sets the value of the personalizacionjustificante property.
     * 
     * @param value
     *     allowed object is
     *     {@link PERSONALIZACIONJUSTIFICANTE }
     *     
     */
    public void setPERSONALIZACIONJUSTIFICANTE(PERSONALIZACIONJUSTIFICANTE value) {
        this.personalizacionjustificante = value;
    }

    /**
     * Gets the value of the alertastramitacion property.
     * 
     * @return
     *     possible object is
     *     {@link ALERTASTRAMITACION }
     *     
     */
    public ALERTASTRAMITACION getALERTASTRAMITACION() {
        return alertastramitacion;
    }

    /**
     * Sets the value of the alertastramitacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ALERTASTRAMITACION }
     *     
     */
    public void setALERTASTRAMITACION(ALERTASTRAMITACION value) {
        this.alertastramitacion = value;
    }

}
