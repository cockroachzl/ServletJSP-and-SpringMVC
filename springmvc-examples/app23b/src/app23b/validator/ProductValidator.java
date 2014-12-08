package app23b.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app23b.domain.Product;

public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Product.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("============== validating product");
        Product product = (Product) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
        Float price = product.getPrice();
        if (price != null && price < 0) {
            errors.rejectValue("price", "price.negative");
        }
    }
}