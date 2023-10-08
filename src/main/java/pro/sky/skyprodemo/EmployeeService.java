package pro.sky.skyprodemo;


import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, double getSalary);

    Employee remove(String firstName, String lastName, int department, double getSalary);

    Employee find(String firstName, String lastName, int department, double salary);

    Collection<Employee> findAll();
}
