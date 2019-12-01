package com.demo.order.dao;

import com.demo.druid.dao.BaseDao;
import com.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao extends BaseDao<Order> {

}
