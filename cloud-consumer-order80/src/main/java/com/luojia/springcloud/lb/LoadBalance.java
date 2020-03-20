package com.luojia.springcloud.lb;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
