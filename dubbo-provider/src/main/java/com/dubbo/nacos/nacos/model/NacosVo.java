package com.dubbo.nacos.nacos.model;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import java.io.Serializable;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@NacosPropertySource(dataId = "NacosVo", autoRefreshed = true)
@Component
public class NacosVo implements Serializable {

  @NacosValue(value = "${vo:handsome}", autoRefreshed = true)
  private String useLocalCache;
}
