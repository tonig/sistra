package es.caib.bantel.front.action;


import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;


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
    
    public Principal getPrincipal( HttpServletRequest request )
    {
		return request.getUserPrincipal();
    }

}
