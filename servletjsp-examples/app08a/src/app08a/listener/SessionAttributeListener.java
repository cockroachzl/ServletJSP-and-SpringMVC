package app08a.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se ) {
		System.out.println("Session attribute added: " + se.getName() + " : " + se.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Session attribute removed: " + se.getName() + " : " + se.getValue());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("Session attribute replaced: " + se.getName() + " : " + se.getValue());
		
	}

}
