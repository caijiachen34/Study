package com.cjc.familybill.service;

import com.cjc.familybill.dao.AccountDao;
import com.cjc.familybill.entity.Account;
import com.cjc.familybill.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList<Account> list = new ArrayList<>();
        list.add(account);
        result.setData(list);
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
    public Result queryAccount(Integer account_id) {
        Result result = new Result();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("account_id",account_id);
        List<Account> account = accountDao.queryAccount(map);
        if (account.size()==0) {
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
    public Result queryAccountByUname(String uname) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("uname",uname);
        List<Account> account = accountDao.queryAccount(map);
        if (account.size()==0) {
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
    public Result UpdateById(Integer account_id,Double accountMoney, String accountType,String payType, String assetsType, String remarks) {
        Result result = new Result();
        Account account = new Account();
        account.setAccount_id(account_id);
        account.setAccountMoney(accountMoney);
        account.setAccountType(accountType);
        account.setPayType(payType);
        account.setAssetsType(assetsType);
        account.setRemarks(remarks);
        accountDao.updateAccountById(account);
        result.setStatus(0);
        result.setMsg("修改成功");
        return result;
    }


    @Override
    public Result deleteAccountById(Integer account_id) {
        Result result = new Result();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("account_id",account_id);
        accountDao.deleteAccountByMap(map);
        result.setStatus(0);
        result.setMsg("删除成功");
        return result;
    }

    @Override
    public Result queryAccSum(String payType, String uname) {
        Result result = new Result();
        Account account = new Account();
        Double accountsum = accountDao.queryAccSum(payType, uname);
        if (accountsum==null) {
            result.setStatus(1);
            result.setMsg("查询收支总额失败");
            return result;
        }
        account.setSum(accountsum);
        ArrayList<Account> list = new ArrayList<>();
        list.add(account);
        result.setStatus(0);
        result.setMsg("查询收支总额成功");
        result.setData(list);
        return result;
    }


}
