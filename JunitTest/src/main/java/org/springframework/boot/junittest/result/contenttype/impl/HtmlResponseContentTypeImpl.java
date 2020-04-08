package org.springframework.boot.junittest.result.contenttype.impl;

import java.util.List;
import java.util.Map;

import org.springframework.boot.junittest.constant.BeanNameConstant;
import org.springframework.boot.junittest.result.contenttype.IResponseContentType;
import org.springframework.boot.junittest.result.responsebody.IResponseBody;
import org.springframework.boot.junittest.utils.JsonUtil;
import org.springframework.boot.junittest.utils.SpringApplicationContextUtil;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.Assert;

/**
 * 处理接口返回类型是Content type =text/html;charset=UTF-8
 * 
 * @Author xiaowen
 */
public class HtmlResponseContentTypeImpl implements IResponseContentType {

    @Override
    public List<ResultMatcher> processResponseResult(Map<String, Object> resultMatchersMaps, String responseBody,
        ResultActions resultActions) {
        MvcResult mvcResult = resultActions.andReturn();
        IResponseBody responseBodyObject = null;
        // 判断responseBody 是否是json字符串 ，true转为json校验
        if (JsonUtil.isJson(responseBody)) {
            IResponseContentType responseContentType = SpringApplicationContextUtil
                .getBean(BeanNameConstant.JSONCONTENTTYPE_BEANNAME, IResponseContentType.class);
            if (responseContentType != null) {
                return responseContentType.processResponseResult(resultMatchersMaps, responseBody, resultActions);
            }
            return null;
            // 判断 接口是否返回页面
        } else if (mvcResult.getModelAndView() != null) {
            responseBodyObject =
                SpringApplicationContextUtil.getBean(BeanNameConstant.MODELVIEW_BEANNAME, IResponseBody.class);
        } else { // 接口返回的时候字符串
            responseBodyObject =
                SpringApplicationContextUtil.getBean(BeanNameConstant.STRING_BEANNAME, IResponseBody.class);
        }
        Assert.notNull(responseBodyObject, "responseBodyObject 为空");

        return responseBodyObject.expectResult(resultMatchersMaps);
    }

}
