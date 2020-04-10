package org.springframework.boot.junittest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.util.CollectionUtils;

/**
 * 执行日志输出到日志文件
 * 
 * @see org.springframework.test.web.servlet.result.MockMvcResultHandlers.PrintWriterPrintingResultHandler类
 * @author wen
 */
public class LogPrintingResultHandler extends PrintingResultHandler {
    static Logger log = LoggerFactory.getLogger(LogPrintingResultHandler.class);

    public LogPrintingResultHandler() {
        super(new ResultValuePrinter() {
            @Override
            public void printHeading(String heading) {
                log.info("");
                log.info(String.format("%20s:", heading));
            }

            @Override
            public void printValue(String label, Object value) {
                if (value != null && value.getClass().isArray()) {
                    value = CollectionUtils.arrayToList(value);
                }
                log.info(String.format("%20s = %s", label, value));
            }
        });
    }

}
