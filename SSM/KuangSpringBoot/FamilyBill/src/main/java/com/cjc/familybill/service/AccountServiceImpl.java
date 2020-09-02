package com.cjc.familybill.service;

import com.cjc.familybill.dao.AccountDao;
import com.cjc.familybill.entity.Account;
import com.cjc.familybill.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Result saveAccount(String uname, Double accountMoney, String accountType, String payType,String assetsType, String remarks) {
        Result result = new Result();

        Account account = new Account();
        account.setAccount_id(null);
        account.setUname(uname);
        account.setAccountMoney(accountMoney);
        account.setAccountType(accountType);
        account.setPayType(payType);
        account.setAssetsType(assetsType);
        account.setRemarks(remarks);
        accountDao.saveAccount(account);
        result.setData(account);
        result.setStatus(0);
        result.setMsg("收支记录添加成功");
        return result;
    }

    @Override
    public Result findAllAccount() {
        Result result = new Result();
        List<Account> allAccount = accountDao.findAllAccount();

        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(allAccount);
        return result;
    }

    @Override
    public Result queryAccount(Integer id) {
        Result result = new Result();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("account_id",id);
        Account account = accountDao.queryAccount(map);
        if (account==null) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(account);
        return result;
    }

    @Override
    public Result UpdateById(Integer account_id,Double accountMoney, String accountType, String assetsType, String remarks) {
        Result result = new Result();
        Account account = new Account();
        account.setAccount_id(account_id);
        account.setAccountMoney(accountMoney);
        account.setAccountType(accountType);
        account.setAssetsType(assetsType);
        account.setRemarks(remarks);
        accountDao.updateAccountByMap(account);
        result.setStatus(0);
        result.setMsg("修改成功");
        return result;
    }


    @Override
    public Result deleteAccountById(Integer account_id) {
        Result result = new Result();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("account_id",account_id);
        accountDao.deleteAccountById(map);
        result.setStatus(0);
        result.setMsg("删除成功");
        return result;
    }

    @Override
    public Result queryAccSum(String payType, String uname) {
        Result result = new Result();
        Account account = new Account();
        Double accountsum = accountDao.queryAccSum(payType, uname);
        account.setSum(accountsum);
        result.setStatus(0);
        result.setMsg("查询收支总额成功");
        result.setData(account);
        return result;
    }


}
