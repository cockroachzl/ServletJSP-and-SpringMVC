package app02a.httpsession;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private int id;
    private String name;
    private String description;
    private double price;
}