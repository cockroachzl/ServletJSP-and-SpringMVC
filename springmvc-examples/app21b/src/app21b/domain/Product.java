package app21b.domain;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 78L;

    @Size(min=2, max=10)
    private String name;
    
    private String description;
    private Float price;
    
    @Past @NotNull
    private Date productionDate;

}