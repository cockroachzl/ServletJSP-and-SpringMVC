package app21a.domain;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 748392348L;
	private String name;
    private String description;
    private Float price;
    private Date productionDate;    
}