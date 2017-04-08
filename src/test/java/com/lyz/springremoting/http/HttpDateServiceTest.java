package com.lyz.springremoting.http;

import org.junit.Test;

import com.lyz.springremoting.ServerRunner;
import com.lyz.springremoting.http.HttpDateService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * 测试http调用方式
 * @author liuyazhuang
 *
 */
public class HttpDateServiceTest extends ServerRunner {

    @Resource(name = "httpDateService")
    private HttpDateService httpDateService;

    @Test
    public void getGetDate() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(httpDateService.getDate()));
    }
}