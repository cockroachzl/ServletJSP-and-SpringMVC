package app08a.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

@WebListener
public class SessionIdListener implements HttpSessionIdListener{

	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		System.out.println("New session id: " + se.getSession().getId());
		System.out.println("Old session id: " + oldSessionId);
	}

}
