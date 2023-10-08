package pro.sky.skyprodemo;
import java.util.Objects;
import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

    public class Employee {
        private final String firstName;
        private final String lastName;
        public double salary;
        private int department;

        public Employee(String firstName, String lastName, int department, double salary) {
            this.firstName = capitalize(firstName.toLowerCase());
            this.lastName = capitalize(lastName.toLowerCase());
            this.salary = salary;
            this.department = department;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }


        public String toString() {
            return "Сотрудник: " + this.firstName + " "
                    + this.lastName;

        }

        public int getDepartment() {
            return department;
        }

        public void setDepartment(int department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Double.compare(employee.salary, salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, salary, department);
        }
    }
