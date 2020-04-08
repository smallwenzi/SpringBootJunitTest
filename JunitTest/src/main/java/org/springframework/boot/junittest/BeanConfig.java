package org.springframework.boot.junittest;

import org.springframework.boot.junittest.constant.BeanNameConstant;
import org.springframework.boot.junittest.result.IHttpResponseResult;
import org.springframework.boot.junittest.result.contenttype.IResponseContentType;
import org.springframework.boot.junittest.result.contenttype.impl.HtmlResponseContentTypeImpl;
import org.springframework.boot.junittest.result.contenttype.impl.JsonResponseContentTypeImpl;
import org.springframework.boot.junittest.result.impl.HttpResponseResultImpl;
import org.springframework.boot.junittest.result.responsebody.IResponseBody;
import org.springframework.boot.junittest.result.responsebody.impl.ResponseJsonBodympl;
import org.springframework.boot.junittest.result.responsebody.impl.ResponseModelViewImpl;
import org.springframework.boot.junittest.result.responsebody.impl.ResponseTextBodyImpl;
import org.springframework.context.annotation.Bean;

/**
 * Bean Config 类
 *
 * @Author xiaowen
 */
public class BeanConfig {
    @Bean
    public IHttpResponseResult responseResult() {
        return new HttpResponseResultImpl();
    }

    @Bean(BeanNameConstant.JSONCONTENTTYPE_BEANNAME)
    public IResponseContentType jsonResponseContentTypeImpl() {
        return new JsonResponseContentTypeImpl();
    }

    @Bean(BeanNameConstant.HTMLCONTENTTYPE_BEANNAME)
    public IResponseContentType htmlResponseContentTypeImpl() {
        return new HtmlResponseContentTypeImpl();
    }

    @Bean(BeanNameConstant.MODELVIEW_BEANNAME)
    public IResponseBody responseModelViewImpl() {
        return new ResponseModelViewImpl();
    }

    @Bean(BeanNameConstant.JSONRESULT_BEANNAME)
    public IResponseBody responseJsonBodympl() {
        return new ResponseJsonBodympl();
    }

    @Bean(BeanNameConstant.STRING_BEANNAME)
    public IResponseBody responseTextBodyImpl() {
        return new ResponseTextBodyImpl();
    }

}
