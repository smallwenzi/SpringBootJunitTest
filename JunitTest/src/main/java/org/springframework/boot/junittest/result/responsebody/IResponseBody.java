package org.springframework.boot.junittest.result.responsebody;

import java.util.List;
import java.util.Map;

import org.springframework.test.web.servlet.ResultMatcher;

/**
 * 接口返回不同内容 处理结果不一样 可能有json，modelView,String等等
 *
 * @Author xiaowen
 */
public interface IResponseBody {
    /**
     * 定义不同返回类型处理构造ResultMatcher 对象集合列表 不同
     * 
     * @param resultMatchersMaps
     * @return
     */
    public List<ResultMatcher> expectResult(Map<String, Object> resultMatchersMaps);
}
