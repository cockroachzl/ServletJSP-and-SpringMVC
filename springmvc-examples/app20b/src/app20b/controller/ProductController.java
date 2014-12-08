package app20b.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app20b.domain.Product;

@org.springframework.stereotype.Controller

public class ProductController {
	
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/product_input")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		logger.info("inputProduct called 2c");
		return "ProductForm";
	}

	@RequestMapping(value="/product_save")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult,
			Model model) {
		logger.info("saveProduct called 2bb");
		// we don't need ProductForm anymore,l
		// Spring MVC can bind HTML forms to Java objects
		
		if (bindingResult.hasErrors()) {
			logger.info("has errors");
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() 
					+ ", field:" + fieldError.getField());
			
			return "ProductForm";
		}
		
		// save product here
		
	    model.addAttribute("product", product);
		return "ProductDetails";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        logger.info("initBinder in ProductController");
        binder.initDirectFieldAccess();
        binder.setDisallowedFields("id");
        binder.setRequiredFields("name", "description", "price");
    }

}
