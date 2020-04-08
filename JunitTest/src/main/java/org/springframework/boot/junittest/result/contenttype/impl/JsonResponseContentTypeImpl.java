package org.springframework.boot.junittest.result.contenttype.impl;

import java.util.List;
import java.util.Map;

import org.springframework.boot.junittest.constant.BeanNameConstant;
import org.springframework.boot.junittest.result.contenttype.IResponseContentType;
import org.springframework.boot.junittest.result.responsebody.IResponseBody;
import org.springframework.boot.junittest.utils.SpringApplicationContextUtil;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.Assert;

/**
 * 处理接口返回类型是Content type =application/json
 *
 * @Author xiaowen
 */
public class JsonResponseContentTypeImpl implements IResponseContentType {

    @Override
    public List<ResultMatcher> processResponseResult(Map<String, Object> resultMatchersMaps, String responseBody,
        ResultActions resultActions) {
        IResponseBody responseContentType =
            SpringApplicationContextUtil.getBean(BeanNameConstant.JSONRESULT_BEANNAME, IResponseBody.class);
        Assert.notNull(responseContentType, BeanNameConstant.JSONRESULT_BEANNAME + "对象为空");
        return responseContentType.expectResult(resultMatchersMaps);
    }
}
