package pro.sky.skyprodemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class Controller {
    public EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") double salary
                                ) {
        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") int department,
                                   @RequestParam("salary") double salary) {
        return employeeService.remove(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("department") int  department,
                                 @RequestParam("salary") double salary) {
        return employeeService.find(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
