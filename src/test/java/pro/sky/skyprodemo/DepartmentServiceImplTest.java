package pro.sky.skyprodemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private List<Employee> employees = List.of(
            new Employee("Alex","Alexov", 3, 50_000),
            new Employee("Sasha ","Alexov", 3, 100_000),
            new Employee("Fill","Alexov", 3, 150_000));
    @Test

    void maxSalaryEmployee_shouldReturnEmployeeWithMaxSalaryWhenEmployeeInMap() {
        when(employeeService.findAll()).thenReturn()
    }

    @Test
    void minSalaryEmployee() {
    }

    @Test
    void getEmployeesInDepartment() {
    }

    @Test
    void getAll() {
    }
}