package com.dubbo.nacos.nacos.controller;


import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.dubbo.nacos.nacos.model.NacosVo;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

  @NacosInjected
  private NamingService namingService;

  @NacosValue(value = "${jht:handsome}", autoRefreshed = true)
  private String useLocalCache;

  @Resource
  private NacosVo vo;


  @GetMapping("/get")
  public String test() throws NacosException {
    namingService.getAllInstances("");
    return vo.getUseLocalCache();
//    return useLocalCache;
  }
}
