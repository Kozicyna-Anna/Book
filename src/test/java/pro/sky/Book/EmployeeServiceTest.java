package pro.sky.Book;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();

    @Test
    void testAdd() {
        assertThat(employeeService.allEmployee()).size().isEqualTo(5);
        var emp = employeeService.addEmployee("Test", "test test", 1, 1000);
        assertThat(emp.getFirstName()).isEqualTo("Test");
        assertThat(emp.getLastName()).isEqualTo("test test");
        assertThat(emp.getDepartmentId()).isEqualTo(1);
        assertThat(emp.getSalary()).isEqualTo(1000);

        assertThat(employeeService.allEmployees()).size().isEqualTo(6);
         assertThat(employeeService.allEmployees()).contains(emp);
    }
    @Test
    testAddAlreadyExists() {
     var emp = employeeService.addEmployee("Test", "test test", 1, 1000);
     assertThat(emp).isNotNull();
     assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Test", "test test", 1, 1000));
    }

    @Test
    void testAddMaxEmployee() {
        employeeService.addEmployee("Test1", "test test1", 1, 1000);
        employeeService.addEmployee("Test2", "test test2", 2, 2000);
        employeeService.addEmployee("Test3", "test test3", 3, 3000);
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("Test4", "test test4", 4, 4000));
    }

    @Test
    void testFindEmp() {
     employeeService.addEmployee("Test1", "test test1", 1, 1000);
     var actual = employeeService.findEmployee("Test1", "test test1");
      assertThat(actual).isNotNull();
      assertThat(actual.getFirstName()).isEqualTo("Test1");
      assertThat(actual.getLastName()).isEqualTo("test test1");
      assertThat(actual.getDepartmentId()).isEqualTo(1);
      assertThat(actual.getSalary()).isEqualTo(1000);
    }
    @Test
    void testFindEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("NotFound", "NotFOUND"));
    }
    @Test
    void testAllEmployees() {
       var expected = List.of(
               new Employee("Sergey", "Ivanov", 1, 30000);
            new Employee("Oleg","Semenov",2,28_000);
            new Employee("Alexander","Petrov",2,4600);
            new Employee("Roman","Samsonov",3,37000);
            new Employee("Igor","Romanov",3,400_000);
            new Employee("test","testtest",4,4000);
            new Employee("test2","testtest2",4,4500);
            new Employee("test3","testtest3",5,6000));

        employeeService.addEmployee("test", "testtest", 4, 4000);
        employeeService.addEmployee("test2", "testtest2", 4, 4500);
        employeeService.addEmployee("test3", "testtest3", 5, 6000);

        assertThat(employeeService.allEmployees()).containsExactlyElementsOf(expected);
    }
    @Test
    void testRemoveEmployee() {
        assertThat(employeeService.removeEmployee("Igor","Romanov")).isTrue();
        assertThat(employeeService.removeEmployee("NOTFOUND","NOTFOUND")).isFalse();
    }

}



