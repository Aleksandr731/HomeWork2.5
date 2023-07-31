package pro.sky.skyprodemo;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServiceImpl employee = (EmployeeServiceImpl) o;
        return Objects.equals(firstName, employee.employeeList) && Objects.equals(lastName, employee.employeeList);
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
}
