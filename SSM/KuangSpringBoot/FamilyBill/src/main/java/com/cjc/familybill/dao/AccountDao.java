package com.cjc.familybill.dao;

import com.cjc.familybill.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AccountDao {
    //添加消费
    public int saveAccount(Account account);
    //查询所有消费
    public List<Account> findAllAccount();
    //根据map查询账单
    public List<Account> queryAccount(Map map);
    //根据id修改账单
    public int updateAccountByMap(Account account);//update元素
    //根据id删除账单
    public int deleteAccountById(Map map);
    //根据支出/收入查询金额
    public Double queryAccSum(@Param("payType") String payType,@Param("uname") String uname);


}
