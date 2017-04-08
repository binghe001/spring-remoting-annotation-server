###作者简介:
刘亚壮   高级软件架构师   精通大数据与分布式系统架构设计与研发   精通Android底层与应用层架构设计与框架研发    精通NIO、AIO与Netty开发   精通分布式数据库中间件   国内知名分布式数据库中间件Mycat核心Committer

###用法
###先使用jetty启动web服务，再通过客户端调用
###创建测试类ServerRunner

package cn.lyz.spring.rpc.annotation.demo;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用jetty作为服务端，运行测试前，先启动startWebapp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
public class ServerRunner {
	private static Server server;

	@BeforeClass
	public static void startWebapp() throws Exception {
		server = new Server();
		Connector connector = new SelectChannelConnector();
		connector.setPort(8080); //设置webapp端口
		server.addConnector(connector);
		WebAppContext webAppContext = new WebAppContext();
		//设置工程名称
		webAppContext.setContextPath("/remoting");
		//这是webapp目录
		webAppContext.setWar("src/main/webapp");
		server.setHandler(webAppContext);
		server.start();
		System.out.println("syetem start sucess.");
	}

	@AfterClass
	public static void stopWebapp() throws Exception {
		server.stop();
	}
}

###创建测试类UserServiceTest.java
package cn.lyz.spring.rpc.annotation.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserService测试类
 */
public class UserServiceTest extends ServerRunner{
	@Autowired
	private UserService userService;
	
	@Test
	  public void getUser() {
	    System.out.println(userService.getUser("slim"));
	  }
}
