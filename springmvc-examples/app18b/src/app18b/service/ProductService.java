package app18b.service;

import app18b.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
