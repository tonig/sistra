
/*
 * 
 */

package es.caib.zonaper.ws.v1.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.2
 * Fri Mar 26 10:36:56 CET 2010
 * Generated source version: 2.2.2
 * 
 */


@WebServiceClient(name = "BackofficeFacadeService", 
                  wsdlLocation = "WEB-INF/wsdl/zonaper/v1/BackofficeFacade.wsdl",
                  targetNamespace = "urn:es:caib:zonaper:ws:v1:services") 
public class BackofficeFacadeService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("urn:es:caib:zonaper:ws:v1:services", "BackofficeFacadeService");
    public final static QName BackofficeFacade = new QName("urn:es:caib:zonaper:ws:v1:services", "BackofficeFacade");
    static {
        URL url = null;
        try {
            url = new URL("WEB-INF/wsdl/zonaper/v1/BackofficeFacade.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from WEB-INF/wsdl/zonaper/v1/BackofficeFacade.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public BackofficeFacadeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BackofficeFacadeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BackofficeFacadeService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns BackofficeFacade
     */
    @WebEndpoint(name = "BackofficeFacade")
    public BackofficeFacade getBackofficeFacade() {
        return super.getPort(BackofficeFacade, BackofficeFacade.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BackofficeFacade
     */
    @WebEndpoint(name = "BackofficeFacade")
    public BackofficeFacade getBackofficeFacade(WebServiceFeature... features) {
        return super.getPort(BackofficeFacade, BackofficeFacade.class, features);
    }

}
