package org.ibit.rol.form.front.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.ibit.rol.form.front.registro.RegistroManager;

import java.io.IOException;

/**
 * Action Base.
 */
public abstract class BaseAction extends Action {

    protected String getLang(HttpServletRequest request) {
        return getLocale(request).getLanguage();
    }

    protected String prepareRedirectInstanciaURL(HttpServletRequest request, HttpServletResponse response, String path) {
        if (path.indexOf('?') > -1) {
            path += "&";
        } else {
            path += "?";
        }
        path += RegistroManager.ID_INSTANCIA + "=" + request.getAttribute(RegistroManager.ID_INSTANCIA);
        return response.encodeRedirectURL(request.getContextPath() + path);
    }

    public void sendFile(HttpServletResponse response, String name, String contentType, byte[] data) throws IOException {
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        response.setContentLength(data.length);
        response.getOutputStream().write(data);
        response.flushBuffer();
    }
}
