package pro.sky.skyprodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
private final EmployeeServiceImpl underTest = new EmployeeServiceImpl();
private Employee expectedEmployee = new Employee
        ("Alex","Alexov", 4, 50_000);
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
    void find() {
    }

    @Test
    void findAll() {
    }
}