package com.demo.business.feign;

import com.demo.entity.Res;
import com.demo.entity.response.R;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

@FeignClient(name = "account-service",fallbackFactory = AccountFeignClientFallbackFactory.class)
public interface AccountFeignClient {

    @GetMapping("account/update")
    R update();

    @GetMapping("account/add")
    R singleInsert();
}

@Component
class AccountFeignClientFallbackFactory implements FallbackFactory<AccountFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFeignClientFallbackFactory.class);

    @Override
    public AccountFeignClient create(Throwable throwable) {
        return new AccountFeignClient(){

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
