package com.demo.account.controller;

import com.demo.account.dao.AccountDao;
import com.demo.account.service.AccountService;
import com.demo.entity.Account;
import com.demo.entity.Res;
import com.demo.entity.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("account/")
public class AccountController {

    private static final Logger logger= LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDao accountDao;

    /**
     *账户,新增
     */
    @GetMapping("add")
    public R add(){
        try {
            Account account=new Account();
            account.setUserName("zhangsan");
            account.setMoney(1000D);
            account.setCreateTime(new Date());
            account.setState(1);
            int i=accountService.singleInsert(account);
            if (i<=0){
                return R.error(100,"插入account失败");
            }
            return R.ok("插入account成功");
        } catch (Exception e) {
            logger.info("account新增异常");
            return R.error(e.getMessage());
        }
    }

    /**
     * test_tag
     */
    public static void main(String[] args) {
        System.out.println("测试新增的tag版本v1.0.1");
    }
}
