package it.soprasteria.pianificazione.v2.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import it.soprasteria.pianificazione.v2.bean.UserBean;

public class SessionHelper {

	private static final String USER_SESSION_KEY = "session.user";
	
	public static void storeUser(UserBean user) {
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession();
	    session.setAttribute(USER_SESSION_KEY, user);
	}
	
	public static UserBean getUser(HttpSession session) {
		
		return (UserBean)session.getAttribute(USER_SESSION_KEY);	
	}
	
	public static UserBean getUser() {
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession();
	    
	    return getUser(session);
	}

	public static void logout() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession();
	    session.invalidate();
	}
}
