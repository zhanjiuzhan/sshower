package com.jcpl.sshower;

import com.jcpl.sshower.server.NettyServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@ComponentScan(basePackages= "com.jcpl.sshower")
public class AppMain {
    private static final Logger logger = LogManager.getLogger(AppMain.class);

    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        logger.info("log4j2 使用...");
        logger.info("AppMain 项目启动...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AppMain appMain = applicationContext.getBean("appMain", AppMain.class);
        logger.info("使用 spring 容器完成...");
        logger.info("Netty 服务启动...");
        appMain.init();
    }

    private void init() {
        nettyServer.start();
    }
}
