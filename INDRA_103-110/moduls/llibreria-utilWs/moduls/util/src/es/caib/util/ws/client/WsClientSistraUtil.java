package es.caib.util.ws.client;

import java.util.Properties;

import javax.xml.ws.BindingProvider;

import es.caib.util.ws.ConfigurationUtil;

public class WsClientSistraUtil {

	/**
	 * Configura puerto segun la configuracion de sistra
	 * @param port
	 * @param url
	 * @param user
	 * @param pass
	 * @throws Exception
	 */
	public static void configurePort(BindingProvider port, String url,
			String user, String pass) throws Exception {
		
		Properties props = ConfigurationUtil.getInstance().obtenerPropiedades();
		
		String auth = props.getProperty("sistra.ws.authenticacion");
		
		boolean generateTimestamp = (props.getProperty("sistra.ws.authenticacion.usernameToken.generateTimestamp") != null?
										"true".equals(props.getProperty("sistra.ws.authenticacion.usernameToken.generateTimestamp")):false);
		boolean logCalls = (props.getProperty("sistra.ws.client.logCalls") != null?
								"true".equals(props.getProperty("sistra.ws.client.logCalls")):false);
		boolean disableCnCheck = (props.getProperty("sistra.ws.client.disableCnCheck") != null?
									"true".equals(props.getProperty("sistra.ws.client.disableCnCheck")):false);
				
		
		WsClientUtil.configurePort(port,url,user,pass,auth,generateTimestamp,logCalls,disableCnCheck);
		
	}
	
}