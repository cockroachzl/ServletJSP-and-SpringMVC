package app16c.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}
}
