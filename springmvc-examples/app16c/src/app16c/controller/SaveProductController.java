package app16c.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16c.domain.Product;
import app16c.form.ProductForm;
import app16c.validator.ProductValidator;

public class SaveProductController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request,
            HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        // populate action properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        // validate ProductForm
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if (errors.isEmpty()) {
            // create Product from ProductForm
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            // no validation error, execute action method
            // insert code to save product to the database

            // store product in a scope variable for the view
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
            // store errors and form in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }

}
