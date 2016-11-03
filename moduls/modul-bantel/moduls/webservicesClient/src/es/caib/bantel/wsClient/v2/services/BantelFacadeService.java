
/*
 * 
 */

package es.caib.bantel.wsClient.v2.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.7
 * Tue Jul 06 12:26:22 CEST 2010
 * Generated source version: 2.2.7
 * 
 */


@WebServiceClient(name = "BantelFacadeService", 
                  wsdlLocation = "WEB-INF/wsdl/v2/BantelFacade.wsdl",
                  targetNamespace = "urn:es:caib:bantel:ws:v2:services") 
public class BantelFacadeService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("urn:es:caib:bantel:ws:v2:services", "BantelFacadeService");
    public final static QName BantelFacade = new QName("urn:es:caib:bantel:ws:v2:services", "BantelFacade");
    static {
        URL url = null;
        try {
            url = new URL("WEB-INF/wsdl/v2/BantelFacade.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from WEB-INF/wsdl/v2/BantelFacade.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public BantelFacadeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BantelFacadeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BantelFacadeService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns BantelFacade
     */
    @WebEndpoint(name = "BantelFacade")
    public BantelFacade getBantelFacade() {
        return super.getPort(BantelFacade, BantelFacade.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BantelFacade
     */
    @WebEndpoint(name = "BantelFacade")
    public BantelFacade getBantelFacade(WebServiceFeature... features) {
        return super.getPort(BantelFacade, BantelFacade.class, features);
    }

}
