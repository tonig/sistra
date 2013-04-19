package es.caib.xml.movilidad.factoria.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import es.caib.xml.CargaObjetoXMLException;
import es.caib.xml.EstablecerPropiedadException;
import es.caib.xml.GuardaObjetoXMLException;
import es.caib.xml.InicializacionFactoriaException;
import es.caib.xml.movilidad.factoria.FactoriaObjetosXMLMovilidad;
import es.caib.xml.movilidad.modelo.ENVIO;
import es.caib.xml.movilidad.modelo.ObjectFactory;

/** Implementa una factor�a capaz de crear objetos que encapsulan el acceso
 * al documento XML de Envio
 * 
 * @author magroig
 *
 */
public class FactoriaObjetosXMLMovilidadImpl implements
	FactoriaObjetosXMLMovilidad {
	
	private static final String FICHERO_PROPIEDADES_JAXB = "movilidad_JAXB.properties"; 
	private static final String PAQUETE_FORMULARIO_PROP = "PAQUETE_MODELO_MOVILIDAD_IMPL";	 
	
	private JAXBContext contextoJAXB;
	private Unmarshaller unmsh;
	private Marshaller msh;
	private ObjectFactory of;

	/** Crea la factor�a. Se necesita que exista en el paquete un fichero properies (xxxx_JAXB.properties),
	 * que debe contener la propiedad PAQUETE_MODELO_OFICIOREMISION_IMPL, cuyo valor indicar� cual es el
	 * paquete donde se encuentra la jerarqu�a de clases generadas mediante JAXB para manejar el acceso
	 * a la creaci�n/recuperaci�n de contenido para el documento de DATOS_PROPIOS
	 * 
	 * @throws InicializacionFactoriaException Se ha producido un error inesperado al incializar la factor�a
	 */
	public FactoriaObjetosXMLMovilidadImpl () throws InicializacionFactoriaException {
		try {
			
			Properties propsJAXB = obtenerPropiedadesJAXB ();

			// Creamos marshaller y unmarshaller
			contextoJAXB = JAXBContext.newInstance (obtenerPaqueteImpl (propsJAXB));
			unmsh = contextoJAXB.createUnmarshaller();	
			msh = contextoJAXB.createMarshaller();
			
			/*
			// Habilitamos validacion en el unmarshaller y marshaller
			SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema( new File("xsd/MOVILIDAD.xsd"));  						
			unmsh.setSchema(schema);
			msh.setSchema(schema);
			*/
			
			of = new ObjectFactory ();
		} catch (Exception e) {
			throw new InicializacionFactoriaException (e.getClass().getName() + " -> " + e.getLocalizedMessage(), 
					"JAXB",e);
		}		
	}
		
	
	/** Carga el fichero properties de configuraci�n de la factor�a
	 * 
	 * @return Fichero de properties para configuraci�n de la factor�a
	 * 
	 * @throws IOException Si se produce un error al acceder al fichero
	 * de properties y sus valores
	 */			
	private Properties obtenerPropiedadesJAXB () throws IOException{
		Properties prop = new Properties ();
		
		prop.load(getClass().getResourceAsStream (FICHERO_PROPIEDADES_JAXB));
		
		return prop;
	}
	
	/**A partir de un objeto properties, retorna el nombre del paquete donde estan las clases generadas
	 * mediante JAXB para acceder al documento
	 * @param propiedadesJAXB Properties de configuracion de la factoria
	 * @return Nombre del paquete donde estan las clases generadas por JAXB
	 * @throws IOException
	 */
	private String obtenerPaqueteImpl (Properties propiedadesJAXB) throws IOException {		
		return propiedadesJAXB.getProperty(PAQUETE_FORMULARIO_PROP);
	}
	
	public Envio crearEnvio() {		
		return new Envio ();					
	}

	public Envio crearEnvio(InputStream datosXML)
			throws CargaObjetoXMLException {
		try {			
			ENVIO envioJAXB = (ENVIO) unmsh.unmarshal(datosXML);		
			return Envio.fromJAXB(envioJAXB);			
		}catch (Exception e) {			
			throw new CargaObjetoXMLException (e.getClass().getName() + ": " + e.getLocalizedMessage(), "Envio", datosXML,e);
		}		
	}

	public Envio crearEnvio(File ficheroXML)
			throws CargaObjetoXMLException {
		
		if (ficheroXML == null){
			throw new CargaObjetoXMLException ("Se ha especificado un fichero nulo",
					"Envio", "");
		}
				
		try {
			return crearEnvio (new FileInputStream (ficheroXML));		
		} catch (FileNotFoundException e) {
			throw new CargaObjetoXMLException (e.getClass().getName() + ": " + e.getLocalizedMessage(),
					"Envio", ficheroXML.getName());
		}
		
		
	}

	public void guardarEnvio(Envio data,
			OutputStream dataXML) 
	throws es.caib.xml.GuardaObjetoXMLException, EstablecerPropiedadException {
		
		// Validar que el output stream no es nulo
		if (dataXML == null)
			throw new es.caib.xml.GuardaObjetoXMLException("Se ha especificado un flujo de salida nulo", 
					"Envio", (OutputStream) null);
		
		// Validar que el justificante no es nulo
		if (data == null)
			throw new es.caib.xml.GuardaObjetoXMLException("Se ha especificado un objeto formulario nulo", 
					"Envio", (OutputStream) null);
		
		// Validar que al justificante tiene todos los datos requeridos
		data.comprobarDatosRequeridos();
		
		// Crear objetos JAXB equivalentes
		ENVIO dataImplInterno = null;
		try {			
			dataImplInterno = Envio.toJAXB(data);						
		} catch (JAXBException e) {
			throw new es.caib.xml.GuardaObjetoXMLException("Se ha producido un error al guardar Envio [" 
					+ e.getClass().getName() + ": " + e.getLocalizedMessage() + "]", 
					"Envio", dataXML);
		}				
		
		// Si todo ha ido bien volvemos a generar el xml esta vez al outputstream indicado
		try{
			msh.marshal (dataImplInterno, dataXML);
		}catch (JAXBException e) {
			throw new es.caib.xml.GuardaObjetoXMLException("Se ha producido un error al guardar Envio [" 
					+ e.getClass().getName() + ": " + e.getLocalizedMessage() + "]", 
					"Envio", dataXML,e);
		}
								
	}

	public void guardarEnvio(Envio data,
			File ficheroXML) 
	throws es.caib.xml.GuardaObjetoXMLException, EstablecerPropiedadException {

		try {
			guardarEnvio (data, new FileOutputStream (ficheroXML));
		} catch (FileNotFoundException e) {
			throw new es.caib.xml.GuardaObjetoXMLException (e.getClass().getName() + ": " + e.getLocalizedMessage(),
					"Envio", ficheroXML.getName());
		} 		
		

	}

	public String guardarEnvio(Envio data)
	throws es.caib.xml.GuardaObjetoXMLException, EstablecerPropiedadException 
	{
	
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(); 
		guardarEnvio (data, byteOutputStream);
		String encoding = getEncoding ();
		
		if ( (encoding != null) && (!encoding.trim().equals(""))){
			try {
				return byteOutputStream.toString(encoding);
			} catch (UnsupportedEncodingException e) {			
				throw new GuardaObjetoXMLException("La codificaci�n " + encoding + " no est� soportada", "Envio", (OutputStream) null);
			}
		}
		else
			return byteOutputStream.toString();
	}

	/* (non-Javadoc)
	 * @see es.caib.xml.FactoriaObjetosXML#getEncoding()
	 */
	public String getEncoding() {
		try {
			return msh.getProperty("jaxb.encoding").toString();
		} catch (PropertyException e) {
			//TODO quiz� manejar mejor la excepci�n
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see es.caib.xml.FactoriaObjetosXML#setEncoding(java.lang.String)
	 */
	public void setEncoding(String encoding) {
		try {
			msh.setProperty("jaxb.encoding", encoding);
		} catch (PropertyException e) {
			//TODO manejar correctamente la excepci�n
			;
		}

	}

	/* (non-Javadoc)
	 * @see es.caib.xml.FactoriaObjetosXML#isIdentacion()
	 */
	public boolean isIdentacion() {
		try {
			return ((Boolean) msh.getProperty("jaxb.formatted.output")).booleanValue();
		} catch (PropertyException e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see es.caib.xml.FactoriaObjetosXML#setIndentacion(boolean)
	 */
	public void setIndentacion(boolean indentacion) {
		try {
			msh.setProperty("jaxb.formatted.output", (indentacion) ? Boolean.TRUE : Boolean.FALSE);
		} catch (PropertyException e) {
			// TODO Manejar excepci�n de forma m�s conveniente
			;
		}

	}


	public MensajeSMS crearMensajeSMS() {	
		return new MensajeSMS();
	}


	public MensajeEMAIL crearMensajeEMAIL() {	
		return new MensajeEMAIL();
	}
	
}