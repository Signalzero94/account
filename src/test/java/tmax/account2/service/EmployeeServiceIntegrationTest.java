package tmax.account2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tmax.account2.domain.Employee;
import tmax.account2.repository.EmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class EmployeeServiceIntegrationTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void 회원가입() {
        Employee employee = new Employee();
        employee.setName("호영");

        Long saveId = employeeService.join(employee);

        Employee findEmployee = employeeService.findOne(saveId).get();
        Assertions.assertThat(employee.getName()).isEqualTo(findEmployee.getName());
    }
    @Test
    void 삭제(){
        Employee employee = new Employee();
        employee.setName("호영");
        employee.setResRegiNumber("810226-1322458");
        employeeService.join(employee);

        Employee employee1 = new Employee();
        employee1.setName("자우");
        employee1.setResRegiNumber("751221-1102154");
        employeeService.join(employee1);

        employeeService.delete(employee);

        List<Employee> result = employeeService.findEmployees();
        Assertions.assertThat(1).isEqualTo(result.size());
    }

    @Test
    void ID로_삭제(){
        Employee employee = new Employee();
        employee.setName("철수");
        employeeService.join(employee);

        employeeService.deleteById(employee.getId());

        List<Employee> result = employeeService.findEmployees();
        Assertions.assertThat(0).isEqualTo(result.size());
    }

    @Test
    void 주민등록번호로_삭제() {
        Employee employee = new Employee();
        employee.setResRegiNumber("9-8");
        employeeService.join(employee);

        Employee employee1 = new Employee();
        employee1.setResRegiNumber("9-9");
        employeeService.join(employee1);

        employeeService.deleteByResRegiNumber(employee.getResRegiNumber());

        List<Employee> result = employeeService.findEmployees();
        Assertions.assertThat(1).isEqualTo(result.size());
    }

    @Test
    public void 중복회원_예외(){
        Employee employee1 = new Employee();
        employee1.setName("김지우");
        employee1.setResRegiNumber("999999-1111111");

        Employee employee2 = new Employee();
        employee2.setName("정지우");
        employee2.setResRegiNumber("999999-1111111");

        employeeService.join(employee1);
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> employeeService.join(employee2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}