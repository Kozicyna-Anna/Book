package service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 8;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Sergey", "Ivanov", 1, 30000),
            new Employee("Oleg","Semenov",2,28_000),
            new Employee("Alexander","Petrov",2,4600),
            new Employee("Roman","Samsonov",3,37000),
            new Employee("Igor","Romanov",1,400_000)
    ));
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public boolean removeEmployee(String firstName, String lastName) {
       return employees.removeIf(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName));
    }
}
public Employee findEmployee(String firstName, String lastName) {
    return employees.stream()
            .filter(e -> e.getFirstName().equsls(firstName) && e.getLastName().equals(lastName));
            .findFirst()
            .orElseThrow(EmployeeNotFoundException : : new);
}

public List<Employee> allEmployees() {
    return employees;
}

