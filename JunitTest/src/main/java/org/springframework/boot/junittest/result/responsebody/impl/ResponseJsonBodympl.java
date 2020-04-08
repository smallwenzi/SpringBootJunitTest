package org.springframework.boot.junittest.result.responsebody.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * 处理 接口返回json数据校验 构造ResultMatcher 对象集合列表 暂时仅支持json 第一层
 *
 * @Author xiaowen
 */
public class ResponseJsonBodympl extends AbstractResponseBody {

    @Override
    protected void iteratorMapDatas(List<ResultMatcher> resultMatcherList, Map<String, Object> resultMatchersMaps) {
        // TODO Auto-generated method stub
        Iterator<String> iterator = resultMatchersMaps.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = resultMatchersMaps.get(key);
            ResultMatcher resultMatcher = MockMvcResultMatchers.jsonPath("$." + key).value(value);
            resultMatcherList.add(resultMatcher);
        }
    }

}
