package app16c.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16c.controller.InputProductController;
import app16c.controller.SaveProductController;

public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 98279L;

    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /app10a/product_input. 
         * However, in the case of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1); 
        String dispatchUrl = null;

        if (action.equals("product_input.action")) {
        	InputProductController controller = new InputProductController();
        	dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
        	SaveProductController controller = new SaveProductController();
        	dispatchUrl = controller.handleRequest(request, response);
        }

        // forward to a view
        if (dispatchUrl != null) {
            RequestDispatcher rd = 
                    request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
