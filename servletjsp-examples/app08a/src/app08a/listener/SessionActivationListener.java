package app08a.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class SessionActivationListener implements HttpSessionActivationListener{

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("Session will be passivated: " + se.getSession());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("Session has been activated: " + se.getSession());
	}

}
