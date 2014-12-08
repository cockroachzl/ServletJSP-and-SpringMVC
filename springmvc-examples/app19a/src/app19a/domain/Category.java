package app19a.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    private int id;
    private String name;
    
}
