package com.dubboapi.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.dubbocommon.service.IDubboService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboTestController {

  @NacosInjected
  private NamingService namingService;

  @Reference
  private IDubboService dubboService;

  @GetMapping(value = "/get")
  public List<Instance> get(@RequestParam String serviceName) throws NacosException {
    return namingService.getAllInstances(serviceName);
  }

  @GetMapping(value = "test")
  public String dubboTest(){
    return dubboService.sayHello();
  }
}
