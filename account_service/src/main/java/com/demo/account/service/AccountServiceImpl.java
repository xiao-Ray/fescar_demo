package com.demo.account.service;

import com.demo.account.dao.AccountDao;
import com.demo.druid.dao.BaseDao;
import com.demo.druid.service.BaseServiceImpl;
import com.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    protected BaseDao<Account> getDao() {
        return accountDao;
    }


}
