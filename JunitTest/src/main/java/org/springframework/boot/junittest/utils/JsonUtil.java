package org.springframework.boot.junittest.utils;

import com.alibaba.fastjson.JSON;

/**
 * JSON 工具类
 * 
 * @Author xiaowen
 */
public class JsonUtil {

    /**
     * 判断是否是json
     * 
     * @param json
     * @return
     */
    public static boolean isJson(String json) {
        try {
            JSON.parse(json);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
