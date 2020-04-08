package org.springframework.boot.junittest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.junittest.constant.SystemConstant;
import org.springframework.boot.junittest.result.IHttpResponseResult;
import org.springframework.boot.junittest.utils.LogPrintingResultHandler;
import org.springframework.boot.junittest.utils.SpringApplicationContextUtil;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 当http接口返回状态码200 1 接口返回json数据校验 @See org.springframework.boot.junittest.result.responsebody.impl.ResponseJsonBodympl;
 * 2 返回view 页面（ application/json;charset=UTF-8） 和返回model的值 @See
 * org.springframework.boot.junittest.result.responsebody.impl.ResponseModelViewImpl
 *
 * 当http接口返回状态码
 * 
 * 抽象BaseTest 其他项目继承此类 需要指定 @SpringBootTest(classes = Application.class)//这里的Application是springboot的启动类名 后调用
 * 
 * @Author xiaowen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@EnableJunitTestConfig
public abstract class AbstractBaseTest {

    protected Logger log = LoggerFactory.getLogger(getClass());

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected IHttpResponseResult responseResult;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
        SpringApplicationContextUtil.setApplicationContext(webApplicationContext);
    }

    /**
     * 日志输出类
     * 
     * @return
     */
    protected ResultHandler print() {
        return new LogPrintingResultHandler();
    }

    /**
     * 支持post测试url方法
     * 
     * @param url
     *            请求url (url待参数)
     * @param resultMatchersMaps
     *            校验返回的key值是否与 value的值Map集合
     * @return
     * @throws Exception
     */
    protected String postUrl(String url, Map<String, Object> resultMatchersMaps) throws Exception {
        Assert.hasText(url, "[Assertion failed] - this URL argument must have length; it must not be null or empty");

        if (resultMatchersMaps == null || resultMatchersMaps.isEmpty()) {
            log.warn("baseTest -------------- have no resultMatchersMaps");
        }
        ResultActions resultActions = mockMvc.perform(post(url).characterEncoding(SystemConstant.UTF_8.toString()));
        resultActions.andDo(print());
        return responseResult.processResponseResult(resultActions, resultMatchersMaps);
    }

}
