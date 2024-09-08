package service;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final int salary;
    private final int departmentId;
    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.departmentId = departmentId;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getSalary() {
        return salary;
    }
    public int getDepartmentId() {
        return departmentId;
    }
}@Override
public String toString() {
    return "Employee{" +
            ", lastName='`'" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", salary=" + salary +
            ", departmentId=" + departmentId +
            '}';
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return departmentId == employee.departmentId && salary == employee.salary &&
            Objects.equals(lastName, employee.lastName) &&
            Objects.equals(firstName, employee.firstName);
}
@Override
public int hashCode() {
    return Objects.hash(lastName, firstName, salary, departmentId);
}

