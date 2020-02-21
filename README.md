### 作者简介:
冰河，高级软件架构师，Java编程专家，大数据架构师与编程专家，信息安全高级工程师，Mykit系列开源框架创始人、核心架构师和开发者，Android开源消息组件Android-MQ独立作者，精通Java, Python, Hadoop大数据生态体系，熟悉MySQL、Redis内核，Android底层架构。多年来致力于分布式系统架构、微服务、分布式数据库、分布式事务与大数据技术的研究，曾主导过众多分布式系统、微服务及大数据项目的架构设计、研发和实施落地。在高并发、高可用、高可扩展性、高可维护性和大数据等领域拥有丰富的架构经验。对Hadoop、Spark、Storm、Flink等大数据框架源码进行过深度分析并具有丰富的实战经验。《海量数据处理与大数据技术实战》、《MySQL开发、优化与运维实战》作者。

### 用法
### 先使用jetty启动web服务，再通过客户端调用
### 创建测试类ServerRunner

```
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
```

### 创建测试类UserServiceTest.java
```
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
```
