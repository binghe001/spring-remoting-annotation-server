package com.lyz.springremoting.rmi;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyz.springremoting.ServerRunner;
import com.lyz.springremoting.rmi.RmiDateService;

import java.text.SimpleDateFormat;

/**
 * 测试RMI调用方式
 * @author liuyazhuang
 *
 */
public class RmiDateServiceTest extends ServerRunner {

    @Autowired
    private RmiDateService rmiDateService;
    @Test
    public void testGetDate() throws Exception {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rmiDateService.getDate()));
    }
}