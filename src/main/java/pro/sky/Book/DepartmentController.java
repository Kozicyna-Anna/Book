package pro.sky.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DepartmentController {

     private final DepartmentService service;
public DepartmentController(DepartmentService service) {
    this.service = service;
}
    @GetMapping("/max-salary")
    public Employee max(@RequestParam int departmentId) {
        return service.getMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee min(@RequestParam int departmentId) {
        return service.getMinSalary(departmentId);
    }

    @GetMapping(value = "/all-by-dept")
    public List<Employee> all(@RequestParam int departmentId) {
        return service.getByDepartment(departmentId);
    }
    @GetMapping ("/all")
    public Map<Integer, List<Employee>> all() {
        return service.grounByDepartment();
    }
}

