package tmax.account2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import tmax.account2.controller.EmployeeController;
import tmax.account2.repository.EmployeeRepository;
import tmax.account2.service.EmployeeControllerTest;
import tmax.account2.service.EmployeeService;

import javax.persistence.Access;

@SpringBootTest
public class SpringContainerTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeController employeeController;

    @Test
    void 저장된빈확인(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String s : names) {
            System.out.println("name = " + s);
        }
    }
    @Test
    void 빈확인(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        EmployeeService bean = ac.getBean(EmployeeService.class);
        System.out.println("bean = " + bean);
        Assertions.assertThat(bean).isInstanceOf(EmployeeService.class);
    }
}
