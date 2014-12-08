package app22a.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app22a.domain.Product;

@Controller

public class ProductController {
	
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/product_input")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm";
	}

	@RequestMapping(value="/product_save")
	public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult,
			Model model) {
		
		// save product here
		
	    model.addAttribute("product", product);
		return "ProductDetails";
	}
	
}
