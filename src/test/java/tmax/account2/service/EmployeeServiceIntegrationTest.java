package tmax.account2.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import tmax.account2.domain.Employee;
import tmax.account2.repository.EmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional   //Test 의 Transactional 은 중복 Test 방지를 위해 테스트 후 롤백 되도록 해주는 기능.
public class EmployeeServiceIntegrationTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @Commit//Commit 은 Test 임에도 실제 DB에 자료를 넣을 수 있게 해줌.
    void 회원가입() {
        //given
        Employee employee = new Employee();
        employee.setName("호영");

        //when
        Long saveId = employeeService.join(employee);

        //then
        Employee findEmployee = employeeService.findOne(saveId).get();
        Assertions.assertThat(employee.getName()).isEqualTo(findEmployee.getName());
    }
    @Test
    void 삭제(){
        //given
        Employee employee = new Employee();
        employee.setName("호영");
        employee.setResRegiNumber("123");
        employeeService.join(employee);

        Employee employee1 = new Employee();
        employee1.setName("자우");
        employee1.setResRegiNumber("123e21");
        employeeService.join(employee1);

        //when
        employeeService.delete(employee);

        //then
        List<Employee> result = employeeService.findAccounts();
        Assertions.assertThat(1).isEqualTo(result.size());
    }

    @Test
    void ID로_삭제(){
        //given
        Employee employee = new Employee();
        employee.setName("철수");
        employeeService.join(employee);

        //when
        employeeService.deleteById(employee.getId());

        //then
        List<Employee> result = employeeService.findAccounts();
        Assertions.assertThat(0).isEqualTo(result.size());

    }

    @Test
    void 주민등록번호로_삭제() {
        //given
        Employee employee = new Employee();
        employee.setResRegiNumber("9-8");
        employeeService.join(employee);

        Employee employee1 = new Employee();
        employee1.setResRegiNumber("9-9");
        employeeService.join(employee1);

        //when
        employeeService.deleteByResRegiNumber(employee.getResRegiNumber());

        //then
        List<Employee> result = employeeService.findAccounts();
        Assertions.assertThat(1).isEqualTo(result.size());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Employee employee1 = new Employee();
        employee1.setName("지우");
        employee1.setResRegiNumber("999999-1111111");

        Employee employee2 = new Employee();
        employee2.setName("정지우");
        employee2.setResRegiNumber("999999-1111111");

        //when
        employeeService.join(employee1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> employeeService.join(employee2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            accountService.join(account2);
//            fail();
//        }catch(IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }
}