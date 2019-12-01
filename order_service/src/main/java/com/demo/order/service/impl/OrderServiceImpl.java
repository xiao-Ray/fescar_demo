package com.demo.order.service.impl;

import com.demo.druid.dao.BaseDao;
import com.demo.druid.service.BaseServiceImpl;
import com.demo.entity.Order;
import com.demo.order.dao.OrderDao;
import com.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    protected BaseDao<Order> getDao() {
        return orderDao;
    }
}
