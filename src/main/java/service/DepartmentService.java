package service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalary(int departmentId) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.getDepartmentId())
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMinSalary(int departmentId) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.getDepartmentId())
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public long getSum(int departmentId) {
        return employeeService.allEmployee()
                .stream()
                .filter(employee -> departmentId == employee.getDepartmentId())
                .mapToInt(e -> e.getSalary)
                .sum();
    }
    public List<Employee> getByDepartment(int departmentId) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.getDepartmentId())
                .toList();
    }

    public Map<Integer, List<Employee>> groupByDepartment() {
        return employeeService.allEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}


