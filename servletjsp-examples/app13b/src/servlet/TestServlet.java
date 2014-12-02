package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = -5727276180170917125L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter writer = response.getWriter();
//		writer.print("<html><head></head>" + "<body> This is Liang" + "<br>"
//				+ "Protocol: " + request.getProtocol() + "<br>"
//				+ "Content-Length: " + request.getContentLength() + "<br>"
//				+ "Content-Type: " + request.getContentType() + "<br>"
//				+ "Parameters: " + request.getParameterMap() + "<br>"
//				+ "</body></html>");
		throw new ServletException("error");
	}
}
