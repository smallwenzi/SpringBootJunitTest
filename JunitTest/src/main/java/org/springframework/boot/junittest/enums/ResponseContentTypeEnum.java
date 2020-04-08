package org.springframework.boot.junittest.enums;

import org.springframework.boot.junittest.constant.BeanNameConstant;
import org.springframework.boot.junittest.constant.ResponseContentType;

/**
 * ResponseContentTypeEnum 枚举类
 * 
 * @Author xiaowen
 */
public enum ResponseContentTypeEnum {
    HTML(BeanNameConstant.HTMLCONTENTTYPE_BEANNAME, ResponseContentType.TEXT_HTML.toString()),
    JSON(BeanNameConstant.JSONCONTENTTYPE_BEANNAME, ResponseContentType.APPLICATION_JSON.toString());

    private String contentType;

    private String beanName;

    ResponseContentTypeEnum(String beanName, String contentType) {
        this.contentType = contentType;
        this.beanName = beanName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static String getResponseContentTypeBeanNameByContentype(String contentType) {
        for (ResponseContentTypeEnum e : ResponseContentTypeEnum.values()) {
            if (e.contentType.equalsIgnoreCase(contentType)) {
                return e.getBeanName();
            }
        }
        return null;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
