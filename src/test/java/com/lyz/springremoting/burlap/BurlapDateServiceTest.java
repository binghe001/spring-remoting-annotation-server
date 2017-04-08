package com.lyz.springremoting.burlap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyz.springremoting.ServerRunner;
import com.lyz.springremoting.burlap.BurlapDateService;

import java.text.SimpleDateFormat;

/**
 * 测试Burlap调用方式
 * @author liuyazhuang
 *
 */
public class BurlapDateServiceTest extends ServerRunner {

    @Autowired
    private BurlapDateService burlapDateService;
    @Test
    public void testGetDate() throws Exception {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(burlapDateService.getDate()));
    }
}