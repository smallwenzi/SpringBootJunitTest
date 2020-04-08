package org.springframework.boot.junittest.result.responsebody.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.junittest.result.responsebody.IResponseBody;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * 
 * 抽象类
 * 
 * @Author xiaowen
 */
public abstract class AbstractResponseBody implements IResponseBody {

    @Override
    public List<ResultMatcher> expectResult(Map<String, Object> resultMatchersMaps) {
        List<ResultMatcher> resultMatcherList = new ArrayList<ResultMatcher>();
        if (resultMatchersMaps == null || resultMatchersMaps.isEmpty()) {
            return resultMatcherList;
        }
        iteratorMapDatas(resultMatcherList, resultMatchersMaps);
        return resultMatcherList;
    }

    /**
     * 定义不同返回类型处理构造ResultMatcher 对象集合列表 不同
     * 
     * @param resultMatcherList
     *            ResultMatcher 对象集合列表
     * @param resultMatchersMaps
     *            校验返回的key值是否与 value的值Map集合
     * @return
     */
    protected abstract void iteratorMapDatas(List<ResultMatcher> resultMatcherList,
        Map<String, Object> resultMatchersMaps);

}
