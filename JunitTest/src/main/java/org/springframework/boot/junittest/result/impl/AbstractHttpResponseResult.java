package org.springframework.boot.junittest.result.impl;

import java.util.Map;

import org.springframework.boot.junittest.result.IHttpResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

/**
 *
 * 处理回复结果抽象类 子类必须覆写processHttpStatusOK
 * 
 * @Author xiaowen
 */
public abstract class AbstractHttpResponseResult implements IHttpResponseResult {

    @Override
    public String processResponseResult(ResultActions resultActions, Map<String, Object> resultMatchersMaps)
        throws Exception {
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        int status = mockHttpServletResponse.getStatus();
        // 判断返回状态码是否是200
        if (HttpStatus.OK.value() == status) {
            this.processHttpStatusOk(mockHttpServletResponse, resultActions, resultMatchersMaps);
            return mockHttpServletResponse.getContentAsString();
            // 判断返回状态码是否是302
        } else if (HttpStatus.FOUND.value() == status) {
            return mockHttpServletResponse.getRedirectedUrl();
        } else {
            throw new Exception("暂时不支持处理http状态为：" + HttpStatus.valueOf(status));
        }
    }

    /**
     * 子类需要处理http请求200ok 的情况
     * 
     * @param mockHttpServletResponse
     *            MockHttpServletResponse 对象
     * @param resultActions
     *            ResultActions 对象
     * @param resultMatchersMaps
     * @throws Exception
     */
    protected abstract void processHttpStatusOk(MockHttpServletResponse mockHttpServletResponse,
        ResultActions resultActions, Map<String, Object> resultMatchersMaps) throws Exception;

}
