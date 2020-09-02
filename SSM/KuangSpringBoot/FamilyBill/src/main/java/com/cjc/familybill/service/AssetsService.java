package com.cjc.familybill.service;

import com.cjc.familybill.util.Result;

public interface AssetsService {

    public Result saveAssets(String uname, String assetsType, Double assetsMoney, String remarks);

    public Result findAllAssets();

    public Result queryAssetsById(Integer assets_id);

    public Result updateAssetsById(Integer assets_id,String assetsType,Double assetsMoney,String remarks);

    public Result deleteAssetsById(Integer assets_id);

    public Result queryAssSum(String uname);

    public Result queryByAssType(String assetsType);
}
