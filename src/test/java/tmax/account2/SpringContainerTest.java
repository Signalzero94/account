package tmax.account2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.Access;

public class SpringContainerTest {

    @Autowired
    private ApplicationContext ac;

    @Test
    void 저장된빈확인(){
        String[] names = ac.getBeanDefinitionNames();
        for (String s : names) {
            System.out.println("name = " + s);
        }


    }


}
