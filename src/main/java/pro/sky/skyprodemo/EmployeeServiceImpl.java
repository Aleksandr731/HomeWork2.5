package pro.sky.skyprodemo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override

    public Employee add(String firstName, String lastName) {
        String key = generateKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedEx("Уже добавлен");
        }
        Employee employee = new Employee(firstName, lastName, 0, 0);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        String key = generateKey(lastName, firstName);

        Employee employee = employees.remove(key);

        if (employee == null) {
            throw new EmployeeNotFoundEx("Не найден");
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, 0, 0);
        String key = generateKey(lastName, firstName);
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
}
