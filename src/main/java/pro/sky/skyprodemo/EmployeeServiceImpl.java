package pro.sky.skyprodemo;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Object firstName;
    public Object lastName;
    List<Employee> employees = List.of(
            new Employee("firstName","lastName"),


            );

}
