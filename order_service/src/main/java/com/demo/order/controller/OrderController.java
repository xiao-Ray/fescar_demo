package com.demo.order.controller;

import com.demo.entity.Order;
import com.demo.entity.Res;
import com.demo.entity.response.R;
import com.demo.order.dao.OrderDao;
import com.demo.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("order/")
public class OrderController {

    private static final Logger logger= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDao orderDao;

    /**
     *订单,订单新增
     */
    @GetMapping("add")
    @Transactional
    public R add(){
        try {
            Order order=new Order();
            order.setOrderName("波司登羽绒服");
            order.setMoney(600d);
            order.setCreateTime(new Date());
            order.setState(1);
            int i=orderService.singleInsert(order);
//            int t=100/0;
            if (i<=0){
                return R.error(100,"插入order失败");
            }
            return R.ok("插入order成功");
        } catch (Exception e) {
            logger.info("order新增异常");
            return R.error(e.getMessage());
        }
    }
}
