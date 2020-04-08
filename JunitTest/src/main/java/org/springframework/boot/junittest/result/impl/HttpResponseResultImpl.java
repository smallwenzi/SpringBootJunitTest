package org.springframework.boot.junittest.result.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.junittest.enums.ResponseContentTypeEnum;
import org.springframework.boot.junittest.result.contenttype.IResponseContentType;
import org.springframework.boot.junittest.utils.SpringApplicationContextUtil;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

/**
 * 当接口http 状态码 返回200 就会调用此
 * 
 * @Author xiaowen
 */
public class HttpResponseResultImpl extends AbstractHttpResponseResult {
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void processHttpStatusOk(MockHttpServletResponse mockHttpServletResponse, ResultActions resultActions,
        Map<String, Object> resultMatchersMaps) throws Exception {
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        String contentType = mockHttpServletResponse.getContentType();
        String responseBody = mockHttpServletResponse.getContentAsString();

        // 获取返回Bean类型
        String responseContentTypeBeanName =
            ResponseContentTypeEnum.getResponseContentTypeBeanNameByContentype(contentType);
        Assert.notNull(responseContentTypeBeanName, "[Assertion failed] - contentType=" + contentType + " not exist");

        // 查找返回类型对象
        IResponseContentType responseContentType =
            SpringApplicationContextUtil.getBean(responseContentTypeBeanName, IResponseContentType.class);
        Assert.notNull(responseContentType,
            "[Assertion failed] - responseContentTypeBeanName=" + responseContentTypeBeanName + " not exist");

        // 构造ResultMatcher 对象集合列表
        List<ResultMatcher> resultMatcherList =
            responseContentType.processResponseResult(resultMatchersMaps, responseBody, resultActions);

        Assert.notNull(resultMatcherList, "[Assertion failed] - resultMatcherList=" + resultMatcherList
            + " this argument is required; it must not be null");
        if (resultMatcherList.isEmpty()) {
            log.warn("have no expectation");
        }

        // 校验返回的key值是否与 value的值
        for (ResultMatcher resultMatcher : resultMatcherList) {
            resultActions.andExpect(resultMatcher);
        }
    }
}
