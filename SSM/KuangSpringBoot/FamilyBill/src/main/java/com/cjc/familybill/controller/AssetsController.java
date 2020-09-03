package com.cjc.familybill.controller;

import com.cjc.familybill.service.AssetsService;
import com.cjc.familybill.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/assets")
public class AssetsController {
    @Resource
    private AssetsService assetsService;

    @ResponseBody
    @PostMapping
    public Result saveAssets(String uname, String assetsType, Double assetsMoney, String remarks){
        Result result = assetsService.saveAssets(uname, assetsType, assetsMoney, remarks);
        return result;
    }

    @ResponseBody
    @PostMapping("findAll")
    public Result findAllAssets(){
        Result result = assetsService.findAllAssets();
        return result;
    }

    @ResponseBody
    @PostMapping("findAllByUname")
    public Result findAllAssetsByUname(String uname){
        Result result = assetsService.findAllAssetsByUname(uname);
        return result;
    }

    @ResponseBody
    @PostMapping("queryAssById")
    public Result queryAssetsById(Integer assets_id){
        Result result = assetsService.queryAssetsById(assets_id);
        return result;
    }

    @ResponseBody
    @PostMapping("updateAssById")
    public Result updateAssetsById(Integer assets_id, String assetsType, Double assetsMoney, String remarks){
        Result result = assetsService.updateAssetsById(assets_id, assetsType, assetsMoney, remarks);
        return result;
    }

    @ResponseBody
    @PostMapping("deleteAssById")
    public Result deleteAssetsById(Integer assets_id){
        Result result = assetsService.deleteAssetsById(assets_id);
        return result;
    }

    @ResponseBody
    @PostMapping("queryAssSum")
    public Result queryAssSum(String uname){
        Result result = assetsService.queryAssSum(uname);
        return result;
    }

    @ResponseBody
    @PostMapping(" ")
    public Result queryByAssType(String assetsType){
        Result result = assetsService.queryByAssType(assetsType);
        return result;
    }

}
