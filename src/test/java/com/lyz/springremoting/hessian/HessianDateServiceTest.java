package com.lyz.springremoting.hessian;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyz.springremoting.ServerRunner;
import com.lyz.springremoting.hessian.HessianDateService;

import java.text.SimpleDateFormat;

/**
 * 测试Hessian调用方式
 * @author liuyazhuang
 *
 */
public class HessianDateServiceTest extends ServerRunner {

    @Autowired
    private HessianDateService hessianDateService;
    @Test
    public void testGetDate() throws Exception {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(hessianDateService.getDate()));
    }
}