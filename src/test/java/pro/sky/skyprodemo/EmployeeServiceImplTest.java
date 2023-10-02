package pro.sky.skyprodemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private EmployeeServiceImpl underTest;
    @BeforeEach
    void beforeEach() {
        underTest = new EmployeeServiceImpl();
    }
private final Employee expectedEmployee = new Employee
        ("Alex","Alexov", 3, 50_000);

    @Test
    void addEmployee_shouldAddEmployeeToMapAndReturnEmployee() {

        Employee result =underTest.add(expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(),
                expectedEmployee.getSalary());

        assertTrue(underTest.findAll().contains(expectedEmployee));
        assertEquals(expectedEmployee, result);
    }
    @Test
    void addEmployee_shouldExceptionWhenNotEnoughMapSize() {
        for (int i = 0; i < 3; i++) {
            underTest.add((expectedEmployee.getFirstName() + i),
                    (expectedEmployee.getFirstName() + i), expectedEmployee.getDepartment(),
                    expectedEmployee.getSalary());
        }

        assertThrows(InvalidImputException.class,
                () -> underTest.add(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                        expectedEmployee.getDepartment(), expectedEmployee.getSalary()));

    }
    @Test
    void addEmployee_shouldThrowExceptionWhenEqualEmployeeInMap() {
        underTest.add(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary());

        assertThrows(EmployeeAlreadyAddedEx.class, () -> underTest.add(
                expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary()));

    }
    @Test
    void removeEmployee_shouldRemoveEmployeeFromMap() {
        Employee result = underTest.remove(expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(),
                expectedEmployee.getSalary());

        assertTrue(underTest.findAll().contains(expectedEmployee));
        assertEquals(expectedEmployee, result);
    }
    @Test
    void findAll_shouldReturnEmployeeListWhenEmployeeInMap() {
        Employee employee = new Employee("Lara", "kroft", 1,100_000);
        underTest.add(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary());
        underTest.add(employee.getFirstName(), employee.getLastName(), employee.getDepartment(),
                employee.getSalary());

        Collection<Employee> result = underTest.findAll();

        assertTrue(result.containsAll(List.of(expectedEmployee, employee)));

    }

    @Test
    void findAll_shouldReturnEmptyListWhenEmployeeNotInMap() {
        Collection<Employee> all = underTest.findAll();
        assertTrue(all.isEmpty());
    }
}