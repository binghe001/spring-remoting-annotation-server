package com.lyz.springremoting;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试服务
 * @author liuyazhuang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:DateServiceTest-context.xml"})
public class ServerRunner {

    private static Server server;

    @Before
    public static void startWebapp() throws Exception {
        server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);

        server.addConnector(connector);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/remoting");

        webAppContext.setWar("src/main/webapp");

        server.setHandler(webAppContext);
        server.start();
        System.out.println("system start sucess.");
    }
    
    @Test
    public void startup(){
    	System.out.println("system start success...");
    }

    @After
    public static void stopWebapp() throws Exception {
        server.stop();
    }
}
