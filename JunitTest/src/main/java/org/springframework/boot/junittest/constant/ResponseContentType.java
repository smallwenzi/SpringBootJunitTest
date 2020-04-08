package org.springframework.boot.junittest.constant;

import java.nio.charset.Charset;

/**
 * 返回内容类型对象
 * 
 * @Author xiaowen
 */
public class ResponseContentType {
    private static final long serialVersionUID = -7768694718232371896L;
    /**
     * application/json;charset=UTF-8
     */
    public static final ResponseContentType APPLICATION_JSON = create("application/json", SystemConstant.UTF_8);
    /**
     * text/html;charset=UTF-8
     */
    public static final ResponseContentType TEXT_HTML = create("text/html", SystemConstant.UTF_8);

    /**
     * 返回类型
     */
    private final String mimeType;
    /**
     * 编码
     */
    private final Charset charset;

    ResponseContentType(final String mimeType, final Charset charset) {
        this.mimeType = mimeType;
        this.charset = charset;

    }

    /**
     * 创建 ResponseContentType
     * 
     * @param mimeType
     *            返回类型
     * @param charset
     *            字符编码
     * @return
     */
    private static ResponseContentType create(final String mimeType, final Charset charset) {
        return new ResponseContentType(mimeType, charset);
    }

    @Override
    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(this.mimeType);
        if (this.charset != null) {
            stringBuffer.append(";charset=");
            stringBuffer.append(this.charset.name());
        }
        return stringBuffer.toString();
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

}
