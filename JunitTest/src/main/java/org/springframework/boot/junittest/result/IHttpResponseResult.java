package org.springframework.boot.junittest.result;

import java.util.Map;

import org.springframework.test.web.servlet.ResultActions;

/**
 *
 * 处理回复结果接口类 其他项目继承此类 需要指定 @SpringBootTest(classes = Application.class)//这里的Application是springboot的启动类名
 *
 * @Author xiaowen
 */
public interface IHttpResponseResult {
    /**
     * 处理返回内容
     * 
     * @param resultActions
     *            ResultActions 对象
     * @param resultMatchersMaps
     *            校验结果Map集合
     * @return 200 则返回页面内容 302则返回跳转的url
     * @throws Exception
     */
    public String processResponseResult(ResultActions resultActions, Map<String, Object> resultMatchersMaps)
        throws Exception;
}
