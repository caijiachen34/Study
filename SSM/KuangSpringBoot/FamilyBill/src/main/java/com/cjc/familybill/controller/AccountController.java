package com.cjc.familybill.controller;

import com.cjc.familybill.service.AccountService;
import com.cjc.familybill.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    //添加收支记录
    //注册
    @ResponseBody
    @PostMapping
    public Result saveAccount(String uname, Double accountMoney, String accountType, String payType, String assetsType,  String remarks){
        Result result = accountService.saveAccount(uname, accountMoney, accountType, payType, assetsType, remarks);
        return result;
    }

    //添加收支记录
    @ResponseBody
    @PostMapping("/findAll")
    public Result findAllAccount(){
        Result result = accountService.findAllAccount();
        return result;
    }

    //删除收支记录
    @ResponseBody
    @PostMapping("/delete")
    public Result deleteAccount(Integer account_id){
        Result result = accountService.deleteAccountById(account_id);
        return result;
    }

    //根据类型查找收支记录
    @ResponseBody
    @PostMapping("/queryAccountByType")
    public Result queryAccSum(String payType, String uname){
        Result result = accountService.queryAccSum(payType, uname);
        return result;
    }

    @ResponseBody
    @PostMapping("/updateById")
    public Result UpdateById(Integer account_id,Double accountMoney, String accountType, String assetsType, String remarks){
        Result result = accountService.UpdateById(account_id, accountMoney, accountType, assetsType, remarks);
        return result;
    }

    @ResponseBody
    @PostMapping("/queryAccById")
    public Result queryAccById(Integer account_id){
        Result result = accountService.queryAccount(account_id);
        return result;
    }

}
