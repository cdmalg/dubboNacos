package com.dubbo.nacos.nacos;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true, groupId = "default")
@EnableDubbo(scanBasePackages = "com.dubbo.nacos.nacos.service")
public class NacosApplication {

  @NacosInjected
  private NamingService namingService;

  @Value("${server.port}")
  private int serverPort;

  @Value("${spring.application.name}")
  private String applicationName;
//
//  @PostConstruct
//  public void registerInstance() throws NacosException {
//    namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
//  }

  public static void main(String[] args) {
    SpringApplication.run(NacosApplication.class, args);
  }

}
