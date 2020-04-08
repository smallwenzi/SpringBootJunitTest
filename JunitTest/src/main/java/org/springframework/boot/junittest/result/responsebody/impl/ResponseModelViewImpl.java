package org.springframework.boot.junittest.result.responsebody.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.boot.junittest.constant.SystemConstant;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 
 * 处理是一个页面（ModelAndView） 构造ResultMatcher 对象集合列表 校验ViewName 和返回model的值
 * 
 * @Author xiaowen
 */
public class ResponseModelViewImpl extends AbstractResponseBody {

    @Override
    protected void iteratorMapDatas(List<ResultMatcher> resultMatcherList, Map<String, Object> resultMatchersMaps) {
        // TODO Auto-generated method stub
        Iterator<String> iterator = resultMatchersMaps.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = resultMatchersMaps.get(key);
            if (SystemConstant.VIEW_NAME.equalsIgnoreCase(key) && value != null) {
                ResultMatcher resultMatcher = MockMvcResultMatchers.view().name(value.toString());
                resultMatcherList.add(resultMatcher);
            } else {
                ResultMatcher resultMatcher = MockMvcResultMatchers.model().attribute(key, value);
                resultMatcherList.add(resultMatcher);
            }
        }

    }

}
