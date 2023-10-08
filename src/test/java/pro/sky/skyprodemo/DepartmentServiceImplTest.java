package pro.sky.skyprodemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
            new Employee("Fill","Alexov", 1, 150_000));
    @Test
    void maxSalaryEmployee_shouldReturnEmployeeWithMaxSalaryWhenEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Employee result = departmentService.maxSalaryEmployee(employees.get(0).getDepartment());

        assertEquals(employees.get(1), result);

    }

    @Test
    void maxSalaryEmployee_shouldThrowExceptionWhenEmployeeNotInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundEx.class, () -> departmentService.maxSalaryEmployee(1));
    }

    @Test
    void minSalaryEmployee_shouldReturnEmployeeWithMinSalaryWhenEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Employee result = departmentService.minSalaryEmployee(employees.get(0).getDepartment());

        assertEquals(employees.get(0), result);

    }

    @Test
    void minSalaryEmployee_shouldThrowExceptionWhenEmployeeNotInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundEx.class, () -> departmentService.minSalaryEmployee(1));
    }


    @Test
    void getEmployeesInDepartment_shouldReturnEmployeesWhenEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Collection<Employee> result = departmentService.getEmployeesInDepartment(employees.get(0).getDepartment());

        assertEquals(List.of(employees.get(0), employees.get(1)), result);
    }
    @Test
    void getEmployeesInDepartment_shouldThrowExceptionWhenEmployeeNotInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundEx.class, () -> departmentService.maxSalaryEmployee(1));
    }

    @Test
    void getAll_shouldReturnMapWithEmployeeWhenEmployeeInDepartments() {
        when(employeeService.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> expendedMap = Map.of(
                1, List.of(employees.get(2)),
                3, List.of(employees.get(0), employees.get(1)));

        Map<Integer, List<Employee>> result = departmentService.getAll();

        assertEquals(expendedMap,result);

    }
    @Test
    void getAll_shouldThrowExceptionWhenEmployeeNotInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundEx.class, () -> departmentService.maxSalaryEmployee(1));
    }
}