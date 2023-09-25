package pro.sky.skyprodemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.tomcat.util.http.parser.HttpParser.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override

    public Employee add(String firstName, String lastName, int department, double salary) {
        String key = generateKey(lastName, firstName);

        if (!validateImput(firstName, lastName)) {
            throw new InvalidImputException();
        }

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedEx("Уже добавлен");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) {

        String key = generateKey(lastName, firstName);

        Employee employee = employees.remove(key);

        if (!validateImput(firstName, lastName)) {
            throw new InvalidImputException();
        }

        if (employee == null) {
            throw new EmployeeNotFoundEx("Не найден");
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key = generateKey(lastName, firstName);

        if (!validateImput(firstName, lastName)) {
            throw new InvalidImputException();
        }

        if (employees.containsKey(key)) {
            return employee;
        }
        throw new EmployeeNotFoundEx("Не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private String generateKey(String firstName, String lastName) {
        return lastName + firstName;
    }

    private boolean validateImput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}
