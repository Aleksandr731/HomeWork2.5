package pro.sky.skyprodemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }

    @GetMapping(value = "/all", params = "department")
    public Collection<Employee> getByDepartment(@RequestParam int department) {
        return departmentService.getEmployeesInDepartment(department);
    }

    @GetMapping(value = "/max", params = "department")
    public Employee getMaxSalaryByDepartment(@RequestParam int department) {
        return departmentService.maxSalaryEmployee(department);
    }
    @GetMapping(value = "/min", params = "department")
    public Employee getMinSalaryByDepartment(@RequestParam int department) {
        return departmentService.minSalaryEmployee(department);
    }


}
