package com.demo.business.controller;

import com.demo.business.feign.AccountFeignClient;
import com.demo.business.feign.OrderFeignClient;
import com.demo.entity.Res;
import com.demo.entity.response.R;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private AccountFeignClient accountFeignClient;

    /**
     * 调用account, order服务
     */
    @GetMapping("business/add")
    @GlobalTransactional(timeoutMills = 300000, name = "businessAdd")
    public R businessAdd() {

        //调用order-service服务
        R order = orderFeignClient.singleInsert();
        if (null == order || !order.get("code").toString().equals("200")) {
            logger.info("调用order失败");
            throw new RuntimeException();
        }

        int i=100/0;
        //调用account-service服务
        R account = accountFeignClient.singleInsert();

        if (null == account || !account.get("code").toString().equals("200")) {
            logger.info("调用account失败");
            throw new RuntimeException();
        }

        return R.ok("请求成功");
    }
}
