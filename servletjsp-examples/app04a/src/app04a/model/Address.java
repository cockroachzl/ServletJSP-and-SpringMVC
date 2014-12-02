package app04a.model;

import lombok.Data;

@Data
public class Address {
    private String streetName;
    private String streetNumber;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}