package com.rhythm.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author peixi
 * @Date 2021/12/28
 * @Description 自定义ribbon负载算法
 */
@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 使用cas、自旋锁获取rest接口请求的次数
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE - 1? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current, next));
        System.out.println("**************next: " + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务集群数量 = 实际调用服务下标，每次重启后rest接口计数从1开始
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
