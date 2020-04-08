package org.springframework.boot.junittest.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 *
 * spring 容器工具类
 * 
 * @Author xiaowen
 * 
 */
public class SpringApplicationContextUtil {

    public static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        Assert.notNull(applicationContext,
            "[Assertion failed] - this applicationContext is required; it must not be null");
        SpringApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取实例
     * 
     * @param name
     *            Bean名称
     * @param type
     *            Bean类型
     * @return 实例
     */
    public static <T> T getBean(String beanName, Class<T> type) {
        checkBeanNameIsExist(beanName);
        Assert.notNull(type, "[Assertion failed] - type argument is required; it must not be null");
        return applicationContext.getBean(beanName, type);
    }

    /**
     * 检查beanName是否存在
     * 
     * @param beanName
     */
    protected static void checkBeanNameIsExist(String beanName) {
        Assert.notNull(applicationContext,
            "[Assertion failed] - this applicationContext is required; it must not be null");
        Assert.hasText(beanName,
            "[Assertion failed] - this beanName argument must have length; it must not be null or empty");
        if (!applicationContext.containsBean(beanName)) {
            throw new IllegalArgumentException("[Assertion failed] - bean name=" + beanName + " not exist");
        }
    }
}
