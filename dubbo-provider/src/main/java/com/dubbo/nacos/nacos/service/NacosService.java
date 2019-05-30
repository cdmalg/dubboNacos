package com.dubbo.nacos.nacos.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbocommon.service.IDubboService;

@Service
public class NacosService implements IDubboService {

  @Override
  public String sayHello() {
    return "hello nacos";
  }
}
