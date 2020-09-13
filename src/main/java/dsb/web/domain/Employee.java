package dsb.web.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int employeeID;
    private String initials;
    private String inserts;
    private String surname;
    private String employeeUserName;
    private String password;
    //private Role role; TODO Aparte klasse Role?


    public Employee(int employeeID, String password) {
        this.employeeID = 0;
        this.password = password;
    }

    public Employee() {
        super();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
