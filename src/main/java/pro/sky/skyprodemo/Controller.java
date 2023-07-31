package pro.sky.skyprodemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Controller {
    public final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   @GetMapping
    public String getEmployeeInfo(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName")String lastName){
       final String employee;
       employee = employeeService.getEmployee(number);
   }
}
