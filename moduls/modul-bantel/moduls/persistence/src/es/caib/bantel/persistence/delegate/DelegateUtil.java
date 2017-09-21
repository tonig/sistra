package es.caib.bantel.persistence.delegate;

import es.caib.bantel.persistence.delegate.DelegateFactory;
import es.caib.bantel.persistence.delegate.IdiomaDelegate;

/**
 * Define m�todos est�ticos para obtener delegates.
 */
public final class DelegateUtil {

    private DelegateUtil() {

    }
    
    public static EntidadDelegate getEntidadDelegate() {
        return (EntidadDelegate) DelegateFactory.getDelegate(EntidadDelegate.class);
    }
   
    public static TramiteBandejaDelegate getTramiteBandejaDelegate() {
        return (TramiteBandejaDelegate) DelegateFactory.getDelegate(TramiteBandejaDelegate.class);
    }
    
    public static DocumentoBandejaDelegate getDocumentoBandejaDelegate() {
        return (DocumentoBandejaDelegate) DelegateFactory.getDelegate(DocumentoBandejaDelegate.class);
    }
    
    public static ProcedimientoDelegate getTramiteDelegate() {    	
        return (ProcedimientoDelegate) DelegateFactory.getDelegate(ProcedimientoDelegate.class);
    }
    
    public static GestorBandejaDelegate getGestorBandejaDelegate() {
    	return (GestorBandejaDelegate) DelegateFactory.getDelegate(GestorBandejaDelegate.class);
    }      
    
    public static BteProcesosDelegate getBteProcesosDelegate() {
        return (BteProcesosDelegate) DelegateFactory.getDelegate(BteProcesosDelegate.class);
    }
    
    public static BteOperacionesProcesosDelegate getBteOperacionesProcesosDelegate() {
        return (BteOperacionesProcesosDelegate) DelegateFactory.getDelegate(BteOperacionesProcesosDelegate.class);
    }
        
    public static ConfiguracionDelegate getConfiguracionDelegate() {
        return (ConfiguracionDelegate) DelegateFactory.getDelegate(ConfiguracionDelegate.class);
    }
    
    public static ConsultaPADDelegate getConsultaPADDelegate() {
        return (ConsultaPADDelegate) DelegateFactory.getDelegate(ConsultaPADDelegate.class);
    }
    
    public static VersionWSDelegate getVersionWSDelegate() {
        return (VersionWSDelegate) DelegateFactory.getDelegate(VersionWSDelegate.class);
    }
    
    public static FicheroExportacionDelegate getFicheroExportacionDelegate() {
        return (FicheroExportacionDelegate) DelegateFactory.getDelegate(FicheroExportacionDelegate.class);
    }
    
    public static AvisosBandejaDelegate getAvisosBandejaDelegate() {
        return (AvisosBandejaDelegate) DelegateFactory.getDelegate(AvisosBandejaDelegate.class);
    }
    
    public static FuenteDatosDelegate getFuenteDatosDelegate() {
        return (FuenteDatosDelegate) DelegateFactory.getDelegate(FuenteDatosDelegate.class);
    }
    
    public static IdiomaDelegate getIdiomaDelegate() {
        return (IdiomaDelegate) DelegateFactory.getDelegate(IdiomaDelegate.class);
    }
    
}
