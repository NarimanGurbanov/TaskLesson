package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Teacher implements Serializable {


    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age;
    }


}
