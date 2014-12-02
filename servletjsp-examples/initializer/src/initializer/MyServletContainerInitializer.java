package initializer;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import servlet.UsefulServlet;

@HandlesTypes({ UsefulServlet.class })
public class MyServletContainerInitializer implements
		ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext servletContext)
			throws ServletException {

		System.out.println("onStartup");
		ServletRegistration registration = servletContext.addServlet(
				"usefulServlet", "servlet.UsefulServlet");
		registration.addMapping("/useful");
		System.out.println("leaving onStartup");
	}
}