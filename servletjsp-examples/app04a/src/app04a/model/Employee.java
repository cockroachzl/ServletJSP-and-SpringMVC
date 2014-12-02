package app04a.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private Address address;
}
