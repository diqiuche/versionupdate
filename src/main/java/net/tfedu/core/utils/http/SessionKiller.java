package net.tfedu.core.utils.http;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 使session失效
 * @author bruce
 *
 */
public class SessionKiller  implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        final HttpServletRequest servletRequest = (HttpServletRequest)sre.getServletRequest();
        final HttpSession session = servletRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
       
    }

}
