package app20a.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = -908L;

    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salaryLevel;

}
