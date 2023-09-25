package pro.sky.skyprodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
private final EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    @Test
    void addEmployee_shouldAddEmployeeToMapAndReturnEmployee() {
        String firstName = "Alex";
        String lastName = "Alexov";
        int department = 4;
        double salary = 50_000;
        Employee expectedEmployee = new Employee(firstName, lastName, department, salary);

        Employee result = underTest.add(firstName, lastName, department, salary);

        assertTrue(underTest.findAll().contains(
                new Employee((firstName), lastName, department, salary)));
        assertEquals(expectedEmployee, result);

    }

    @Test
    void remove() {
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }
}