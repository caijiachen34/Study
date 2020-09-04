package com.cjc.familybill.service;

import com.cjc.familybill.entity.Account;
import com.cjc.familybill.util.Result;

import java.sql.Timestamp;
import java.util.Map;

public interface AccountService {

    public Result saveAccount(String uname, Double accountMoney, String accountType, String payType,String assetsType,String remarks);

    public Result findAllAccount();

    //根据id查询账单
    public Result queryAccount(Integer id);

    //根据uname查询账单
    public Result queryAccountByUname(String  uname);

    //根据id修改账单
    public Result UpdateById(Integer account_id,Double accountMoney,String accountType,String assetsType,String remarks);//update元素
    //根据id删除账单
    public Result deleteAccountById(Integer account_id);
    //根据查询支出/收入金额
    public Result queryAccSum(String payType,String uname);

}
