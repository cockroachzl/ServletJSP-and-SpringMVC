package app16a.domain;
import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 748392348L;
	private String name;
    private String description;
    private double price;
}