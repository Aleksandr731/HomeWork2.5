package pro.sky.skyprodemo;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    public double salary;
    private int department;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServiceImpl employee = (EmployeeServiceImpl) o;
        return Objects.equals(firstName, employee.employees) && Objects.equals(lastName, employee.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public String toString() {
        return "Сотрудник: " + this.firstName + " "
                + this.lastName;

    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
