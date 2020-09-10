package com.cjc.familybill.service;

import com.cjc.familybill.util.Result;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Map;

public interface AssetsService {

    public Result saveAssets(String uname, String assetsType, Double assetsMoney, String remarks);

    public Result findAllAssets();

    public Result findAllAssetsByUname(String uname);

    public Result queryAssetsById(Integer assets_id);

    public Result updateAssetsById(Integer assets_id,String assetsType,Double assetsMoney,String remarks);

    public Result deleteAssetsById(Integer assets_id);

    public Result queryAssSum(String uname);

    public Result queryByAssType(String assetsType);

    public Result queryAssRemain(String uname1,String assetsType1);

    public Result queryRemainByUname(String uname);
}
