package pro.sky.skyprodemo;

import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private String firstName;
    private String lastName;

    public EmployeeServiceImpl(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServiceImpl employee = (EmployeeServiceImpl) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
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
