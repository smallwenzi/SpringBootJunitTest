package org.springframework.boot.helloworld.controller.oldtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.helloworld.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * HelloWorld  Testcontroller
 *
 * @Author xiaowen
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class HelloWorldControllerTest {

    protected static final String ENCODING = "UTF-8";
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/view/helloWorld").characterEncoding(ENCODING));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
        resultActions.andExpect( MockMvcResultMatchers.view().name("helloWorld"));
        resultActions.andExpect( MockMvcResultMatchers.model().attribute("value", "helloWorld"));
    }
}

