package com.client.test;

import com.spring.cloud.eureka.client.Application;
import com.spring.cloud.eureka.client.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;

import static org.hamcrest.Matchers.*;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = Application.class)
public class MockmvcTest {
        private MockMvc mockMvc;
        @Before
        public void setup() {
            this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();//获取mockMvc实例
        }

        @Test
        public void simple() throws Exception {
            mockMvc.perform(post("/hello").accept(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.a.length()",greaterThan(2)));
          //  .andDo(print());

        }


}//{"a":"[{"b":"hello"},{"c":"hi"},{"d":"think"}]"}
