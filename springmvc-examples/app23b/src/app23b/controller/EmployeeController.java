package app23b.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app23b.domain.Employee;

@org.springframework.stereotype.Controller

public class EmployeeController {
	
	private static final Log logger = LogFactory.getLog(EmployeeController.class);
	
	@Autowired
	ConversionService conversionService;
	
	@RequestMapping(value="employee_input")
	public String inputEmployee(Model model) {
		model.addAttribute(new Employee());
		logger.info("inputEmployee called 2. map:" + model.asMap());
		return "EmployeeForm";
	}

	@RequestMapping(value="employee_save")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult,
			Model model) {
		logger.info("saveEmployee called 2");
		
		System.out.println("type of conversion service:" + conversionService.getClass());
		DefaultFormattingConversionService cs = (DefaultFormattingConversionService) conversionService;
		
		
		logger.info("as map:" + model.asMap());
		// we don't need ProductForm anymore,l
		// Spring MVC can bind HTML forms to Java objects
		
		if (bindingResult.hasErrors()) {
		    System.out.println("has errors");
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println("Code:" + fieldError.getCode() 
					+ ", field:" + fieldError.getField());
			
			return "EmployeeForm";
		}
		
		// save product here
		
	    model.addAttribute("employee", employee);
	    
	   
		return "EmployeeDetails";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setDisallowedFields("id");
//        binder.setRequiredFields("username", "password", "emailAddress");
        logger.info("initBinderin EmployeeController");
    }
}
