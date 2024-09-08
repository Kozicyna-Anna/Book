package pro.sky.Book;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.catalina.startup.ExpandWar.validate;

@RestController
public class EmployeeController {
}
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int department,
                                @RequestParam int salary) {
    validate(firstName, lastName);
        return employeeService.addEmployee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                department, salary);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
    validate(firstName, lastName);
    if (removed) {
        return "Сотрудник" + firstName + " " + lastName + "удален.";
    }
        return "Сотрудник" + firstName + " " + lastName + "не найден!";
    }
    return employeeService.removeEmployee(
                StringUtils.capitalize(firstName),StringUtils.capitalize(lastName));

    @GetMapping(path = "/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        validate(firstName, lastName);
        return employeeService.findEmployee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName));
    }
    @GetMapping(path = "/all")
    public List<Employee> allEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
       validate(firstName, lastName);
       return employeeService.allEmployee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName));
    }

}
