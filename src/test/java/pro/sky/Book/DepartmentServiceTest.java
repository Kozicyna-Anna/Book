package pro.sky.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest {

    @ExtendWith(MockitoExtension.class)
    class DepartmentServiceTest {

        @Mock
        EmployeeService employeeService;

        @InjectMocks
        DepartmentService departmentService;

        @BeforeEach
        void setUp() {
            List<Employee> employees = new ArrayList<>(List.of(
                    new Employee("Sergey", "Ivanov", 1, 30000),
                    new Employee("Oleg", "Semenov", 2, 28_000),
                    new Employee("Alexander", "Petrov", 2, 4600),
                    new Employee("Roman", "Samsonov", 3, 37000),
                    new Employee("Igor", "Romanov", 3, 400_000)
            ));
            when(employeeService.allEmployee()).thenReturn(employees);
        }

        @Test
        void testMaxSalary() {
            assertEquals(new Employee("Sergey", "Ivanov", 1, 30000), departmentService.getMaxSalary(1));
            assertNull(departmentService.getMaxSalary(-1));
        }

        @Test
        void testByDepartment() {
            assertThat(departmentService.getByDepartment(3)).containsExactly(
                    new Employee("Roman", "Samsonov", 3, 37000),
                    new Employee("Igor", "Romanov", 3, 400_000));

            assertThat(departmentService.getByDepartment(2)).containsExactly(
                    new Employee("Oleg", "Semenov", 2, 28_000));

        }
        @Test
        void testGroupDepartment() {
            Map<Integer, List<Employee>> actual = departmentService.groupByDepartment();

            assertThat(actual).isEqualTo(
                    Map.of(
                    1,List.of(new Employee("Sergey", "Ivanov", 1, 30000)),
                            2,List.of( new Employee("Oleg", "Semenov", 2, 28_000), new Employee("Alexander", "Petrov", 2, 4600)),
                     3, List.of( new Employee("Roman", "Samsonov", 3, 37000), new Employee("Igor", "Romanov", 3, 400_000))

                    )
            );

        }
    }
}
