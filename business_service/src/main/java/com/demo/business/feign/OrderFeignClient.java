package com.demo.business.feign;

import com.demo.entity.Res;
import com.demo.entity.response.R;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service",fallbackFactory = OrderFeignClientFallbackFactory.class)
public interface OrderFeignClient {

    @GetMapping("order/update")
    R update();

    @GetMapping("order/add")
    R singleInsert();
}

@Component
class OrderFeignClientFallbackFactory implements FallbackFactory<OrderFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFeignClientFallbackFactory.class);

    @Override
    public OrderFeignClient create(Throwable throwable) {
        return new OrderFeignClient(){

            @Override
            public R update() {
                return null;
            }

            @Override
            public R singleInsert() {
                return null;
            }
        };
    }
}
