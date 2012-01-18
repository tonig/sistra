package es.caib.regtel.ws.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.jboss.security.NobodyPrincipal;
import org.jboss.security.SecurityAssociation;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.SubjectSecurityManager;
import org.springframework.beans.factory.annotation.Required;

/**
 * CXF Interceptor that provides HTTP Basic Authentication validation.
 * 
 * Based on the concepts outline here:
 *    http://chrisdail.com/2008/03/31/apache-cxf-with-http-basic-authentication
 *
 * @author CDail
 */
public class BasicAuthAuthorizationInterceptor extends SoapHeaderInterceptor {

    /** whether this handler has been initialized already */
    protected boolean isInitialised;
 
    /** whether this handler should let through unauthenticated calls */
    protected boolean shouldValidateUnauthenticatedCalls;
    private static Log log = LogFactory.getLog(BasicAuthAuthorizationInterceptor.class);
	
    /** 
     * this is the authentication manager that is responsible for our security domain 
     * if that is null, this authenticationhandler will block any call, rather deactivate
     * the handler, then, or run against a NullSecurityManager
     */
    protected SubjectSecurityManager authMgr;
    protected String unauthenticatedCalls;
    protected String securityDomain;
	/** 
     * initialize this authenticationhandler lazy, after the options have been
     * set.
     */
    
    @Required
    public void setUnauthenticatedCalls(String unauthenticatedCalls) {
        this.unauthenticatedCalls = unauthenticatedCalls;
    }
    
    @Required
    public void setSecurityDomain(String securityDomain) {
        this.securityDomain = securityDomain;
    }
    
    
    protected void initialise(){
         isInitialised = true;
         authMgr=null;
         shouldValidateUnauthenticatedCalls=false;
         if (securityDomain != null) {
            try {
               // bind against the jboss security subsystem
               authMgr = (SubjectSecurityManager) new InitialContext().lookup(securityDomain);
            } catch (NamingException e) {
            	log.error("Error en el interceptor funcion initialise " + e.getMessage(),e);
            }
         }
         
         if (unauthenticatedCalls != null) {
            try {
               // bind against the jboss security subsystem
               shouldValidateUnauthenticatedCalls=new Boolean(unauthenticatedCalls).booleanValue();
            } catch (Exception e) {
            	log.error("Error en el interceptor funcion initialise " + e.getMessage(),e);
            }
         }
      }
   
      /** 
       * creates a new principal belonging to the given username,
       * override to adapt to specific security domains.
       */
      protected Principal getPrincipal(String userName) {
         if (userName == null) {
            return NobodyPrincipal.NOBODY_PRINCIPAL;
         } else {
            return new SimplePrincipal(userName);
         }
      }
   
      /** validates the given principal with the given password */
      protected void validate(Principal userPrincipal, String passwd) throws Exception {
         // build passchars
         char[] passChars = passwd != null ? passwd.toCharArray() : null;
         // do the validation only if authenticated or validation enforced
         if(shouldValidateUnauthenticatedCalls || userPrincipal != NobodyPrincipal.NOBODY_PRINCIPAL) {
            // have to use pointer comparison here, but it?s a singleton, right?
            if(!authMgr.isValid(userPrincipal, passChars)) {
            	log.error("Autentificaci�n de usuario incorrecta.");
                throw new Exception( "Autentificaci� de l'usuari incorrecta."); 
            }
         }
      }
   
      /** associates the call context with the given info */
      protected Subject associate(Principal userPrincipal, String passwd) {
         // pointer comparison, again	      
         if (shouldValidateUnauthenticatedCalls || userPrincipal != NobodyPrincipal.NOBODY_PRINCIPAL) {
            SecurityAssociation.setPrincipal(userPrincipal);
            SecurityAssociation.setCredential(passwd!=null ? passwd.toCharArray() : null);
         } else {
            // Jboss security normally does not like nobody:null
            SecurityAssociation.setPrincipal(null);
            SecurityAssociation.setCredential(null);
         }
         return authMgr.getActiveSubject();
      }
   
     
    @Override public void handleMessage(Message message) throws Fault {
        // This is set by CXF
    	try {
	    	AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
	        
	        // If the policy is not set, the user did not specify credentials
	        // A 401 is sent to the client to indicate that authentication is required
	        if (policy == null) {
	        	log.error("Usuario intentando acceder sin las credenciales");
	            sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
	            return;
	        }
	        log.debug("Accede el Usuario: " + policy.getUserName());
		      
	               
	        // double check does not work on multiple processors, unfortunately
	        if (!isInitialised) {
	           synchronized (this) {
	              if (!isInitialised) {
	                 initialise();
	              }
	           }
	        }
	        
	        if (authMgr == null) {
	        	log.debug("No hay ning�n dominio de seguridad asociado.");
	        	sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
	            return;
	         }
	   
	
	        // we take the id out of the        
	        String userID = policy.getUserName();
	        // convert into a principal
	        Principal userPrincipal = getPrincipal(userID);
	        // the password that has been provided
	        String passwd = policy.getPassword();
	        // validate the user
	        validate(userPrincipal, passwd);
	        // associate the context 
	        Subject subject = associate(userPrincipal, passwd);
	        // with the security subject
		} catch (Exception e) {
			log.error(e.getMessage()+"  "+ e.getCause());
			sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
            return;
		}

    }
    
    private void sendErrorResponse(Message message, int responseCode) {
        Message outMessage = getOutMessage(message);
        outMessage.put(Message.RESPONSE_CODE, responseCode);
        
        // Set the response headers
        Map<String, List<String>> responseHeaders =
            (Map<String, List<String>>)message.get(Message.PROTOCOL_HEADERS);
        if (responseHeaders != null) {
            responseHeaders.put("WWW-Authenticate", Arrays.asList(new String[]{"Basic realm=realm"}));
            responseHeaders.put("Content-length", Arrays.asList(new String[]{"0"}));
        }
        message.getInterceptorChain().abort();
        try {
            getConduit(message).prepare(outMessage);
            close(outMessage);
        } catch (IOException e) {
        	log.error(e.getMessage()+"  "+ e.getCause());
        }
    }
    
    private Message getOutMessage(Message inMessage) {
        Exchange exchange = inMessage.getExchange();
        Message outMessage = exchange.getOutMessage();
        if (outMessage == null) {
            Endpoint endpoint = exchange.get(Endpoint.class);
            outMessage = endpoint.getBinding().createMessage();
            exchange.setOutMessage(outMessage);
        }
        outMessage.putAll(inMessage);
        return outMessage;
    }
    
    private Conduit getConduit(Message inMessage) throws IOException {
        Exchange exchange = inMessage.getExchange();
        EndpointReferenceType target = exchange.get(EndpointReferenceType.class);
        Conduit conduit =
            exchange.getDestination().getBackChannel(inMessage, null, target);
        exchange.setConduit(conduit);
        return conduit;
    }
    
    private void close(Message outMessage) throws IOException {
        OutputStream os = outMessage.getContent(OutputStream.class);
        os.flush();
        os.close();
    }
}