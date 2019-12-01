package com.demo.account.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.druid.dao.BaseDao;
import com.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao extends BaseDao<Account> {

}
