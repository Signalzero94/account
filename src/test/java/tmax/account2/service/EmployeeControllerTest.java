package tmax.account2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import tmax.account2.controller.EmployeeController;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmployeeControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void home화면_오류여부확인() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/"))
                        .andExpect(MockMvcResultMatchers
                        .status().isOk()).andDo(print());
    }
    @Test
    void 가입화면_오류여부확인() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/employees/new"))
                .andExpect(MockMvcResultMatchers
                        .status().isOk()).andDo(print());
    }
    @Test
    void 직원목록화면_오류여부확인() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers
                        .status().isOk()).andDo(print());
    }

}