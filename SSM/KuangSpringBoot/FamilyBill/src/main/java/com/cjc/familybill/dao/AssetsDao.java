package com.cjc.familybill.dao;

import com.cjc.familybill.entity.Account;
import com.cjc.familybill.entity.Assets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AssetsDao {
    //添加资金(银行卡/支付宝)
    public int saveAssets(Assets assets);
    //查询所有资金
    public List<Assets> findAllAssets();
    //根据map查询资金信息
    public Assets queryAssets(Map map);
    //根据id修改资金信息
    public int updateAssetsById(Assets assets);//update元素
    //根据id删除
    public int deleteAssetsByMap(Map map);
    //查询所有资金账户总额
    public Double queryAssSum(@Param("uname") String uname);

}
