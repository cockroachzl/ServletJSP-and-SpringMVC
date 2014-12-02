package app01a;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigDemoServlet", 
    urlPatterns = { "/servletConfigDemo" },
    initParams = {
        @WebInitParam(name="admin", value="Harry Taciak"),
        @WebInitParam(name="email", value="admin@example.com")
    }
)
public class ServletConfigDemoServlet implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void init(ServletConfig servletConfig) 
            throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, 
            ServletResponse response)
            throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        ServletContext context = servletConfig.getServletContext();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head><body>" + 
                "Admin:" + admin + 
                "<br/>Email:" + email +
                "<br> All init parameter names: " + Collections.list(servletConfig.getInitParameterNames()) + 
                "<br> All init parameter names (from context): " + Collections.list(context.getInitParameterNames()) +
                "<br> Context path: " + context.getContextPath() +
                "<br> attribute names: " + Collections.list(context.getAttributeNames()) +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfig demo";
    }
    
    @Override
    public void destroy() {
    }    
}
