package org.springframework.boot.junittest.result.contenttype;

import java.util.List;
import java.util.Map;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * 
 * 定义不同返回类型处理构造ResultMatcher 对象集合列表 不同
 * 
 * @Author xiaowen
 */
public interface IResponseContentType {
    /**
     * 构造ResultMatcher 对象集合列表
     * 
     * @param resultMatchersMaps
     *            校验返回的key值是否与 value的值Map集合
     * @param responseBody
     * @param resultActions
     * @return
     */
    public List<ResultMatcher> processResponseResult(Map<String, Object> resultMatchersMaps, String responseBody,
        ResultActions resultActions);
}
