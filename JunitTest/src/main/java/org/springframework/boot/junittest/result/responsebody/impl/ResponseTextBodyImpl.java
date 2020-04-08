package org.springframework.boot.junittest.result.responsebody.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class ResponseTextBodyImpl extends AbstractResponseBody {

    @Override
    protected void iteratorMapDatas(List<ResultMatcher> resultMatcherList, Map<String, Object> resultMatchersMaps) {
        Iterator<String> iterator = resultMatchersMaps.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = resultMatchersMaps.get(key);
            if (value != null) {
                ResultMatcher resultMatcher = MockMvcResultMatchers.content().string(value.toString());
                resultMatcherList.add(resultMatcher);
            }
        }
    }

}
