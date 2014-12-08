package app16b.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16b.domain.Product;
import app16b.form.ProductForm;

public class SaveProductController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        // populate form properties
        productForm.setName(
                request.getParameter("name"));
        productForm.setDescription(
                request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        
        // create model
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
        	product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
        }

        // insert code to add product to the database

        request.setAttribute("product", product);
        return "/WEB-INF/jsp/ProductDetails.jsp";
	}

}
