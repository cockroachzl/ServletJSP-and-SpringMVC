package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/prog" })
public class ProgrammaticServlet extends HttpServlet {

	private static final long serialVersionUID = 87620L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.authenticate(response)) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Welcome");
		} else {
			// user not authenticated
			// do something
			System.out.println("User not authenticated");
		}
	}
}