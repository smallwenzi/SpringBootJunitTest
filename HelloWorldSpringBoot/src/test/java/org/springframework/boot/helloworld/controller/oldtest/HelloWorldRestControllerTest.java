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
 * HelloWorld Restful Testcontroller
 * 
 * @Author xiaowen
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
// 这里的Application是springboot的启动类名
@WebAppConfiguration
public class HelloWorldRestControllerTest {

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
        // perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        // post 声明发送一个get请求的方法
        ResultActions resultActions = mockMvc.perform(post("/restful/helloWorld").characterEncoding(ENCODING));
        // andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）
        resultActions.andDo(print());
        // andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.result").value("helloWorld"));
    }
}
