import java.util.Objects;

public class Employee {

    private final String fullName;
    private int department;
    private int salary;

    private static int counter = 1;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }


    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " fullName='" + fullName + "\'" +
                ", department=" + department +
                ", salary=" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }

}
