package es.caib.mobtratel.front.action;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.util.RequestUtils;

import es.caib.mobtratel.front.taglib.Constants;



/**
 * Action Base.
 */
public abstract class BaseAction extends Action
{
	/**
     * Return the user's currently selected Locale.
     * @param request The request we are processing
     */
    public  Locale getLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return (locale);
    }
    
    public String getLang(HttpServletRequest request) {
        return getLocale(request).getLanguage();
    }
    
    public String getPrincipal( HttpServletRequest request )
    {
		return request.getUserPrincipal().getName();
    }
    
    /** Retorna true si se ha pulsado un bot�n submit de alta */
    protected boolean isAlta(HttpServletRequest request) {
      return (request.getParameter(Constants.ALTA_PROPERTY) != null);
    }
    
    protected ActionForm obtenerActionForm(ActionMapping mapping, HttpServletRequest request, String path) 
    {
        ModuleConfig config = mapping.getModuleConfig();
        ActionMapping newMapping = (ActionMapping) config.findActionConfig(path);
        ActionForm newForm = RequestUtils.createActionForm(request, newMapping, config, this.servlet);
        if ("session".equals(newMapping.getScope())) {
            request.getSession(true).setAttribute(newMapping.getAttribute(), newForm);
        } else {
            request.setAttribute(newMapping.getAttribute(), newForm);
        }
        newForm.reset(newMapping, request);
        return newForm;
    }
    



}
