package com.cjc.familybill.service;

import com.cjc.familybill.dao.AssetsDao;
import com.cjc.familybill.entity.Assets;
import com.cjc.familybill.entity.AssetsRemian;
import com.cjc.familybill.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssetsServiceImpl implements AssetsService {

    @Resource
    private AssetsDao assetsDao;

    @Override
    public Result saveAssets(String uname, String assetsType, Double assetsMoney, String remarks) {
        Result result = new Result();
        Assets assets = new Assets();
        assets.setAssets_id(null);
        assets.setUname(uname);
        assets.setAssetsType(assetsType);
        assets.setAssetsMoney(assetsMoney);
        assets.setRemarks(remarks);
        assetsDao.saveAssets(assets);
        ArrayList<Assets> list = new ArrayList<>();
        list.add(assets);
        result.setStatus(0);
        result.setMsg("添加成功");
        result.setData(list);
        return result;
    }

    @Override
    public Result findAllAssets() {
        Result result = new Result();
        List<Assets> allAssets = assetsDao.findAllAssets();
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(allAssets);
        return result;
    }

    @Override
    public Result findAllAssetsByUname(String uname) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("uname",uname);
        List<Assets> assets = assetsDao.queryAssets(map);
        if (assets.size()==0) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(assets);
        return result;
    }

    @Override
    public Result queryAssetsById(Integer assets_id) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("assets_id",assets_id);
        List<Assets> assets = assetsDao.queryAssets(map);
        if (assets.size()==0) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(assets);
        return result;
    }

    @Override
    public Result updateAssetsById(Integer assets_id, String assetsType, Double assetsMoney, String remarks) {
        Result result = new Result();
        Assets assets = new Assets();
        assets.setAssets_id(assets_id);
        assets.setAssetsType(assetsType);
        assets.setAssetsMoney(assetsMoney);
        assets.setRemarks(remarks);
        int i = assetsDao.updateAssetsById(assets);
        if (i==0) {
            result.setStatus(1);
            result.setMsg("更新失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("更新成功");
        return result;

    }

    @Override
    public Result deleteAssetsById(Integer assets_id) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("assets_id",assets_id);
        int i = assetsDao.deleteAssetsByMap(map);
        if (i ==0) {
            result.setStatus(1);
            result.setMsg("删除失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("删除成功");
        return result;
    }

    @Override
    public Result queryAssSum(String uname) {
        Result result = new Result();
        Assets assets = new Assets();
        Double sum = assetsDao.queryAssSum(uname);
        if (sum==null) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        assets.setSum(sum);
        ArrayList<Assets> list = new ArrayList<>();
        list.add(assets);
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(list);
        return result;
    }

    @Override
    public Result queryByAssType(String assetsType) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("assetsType",assetsType);
        List<Assets> assets = assetsDao.queryAssets(map);
        if (assets == null) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(assets);
        return result;
    }

    //查询各资金余额
    @Override
    public Result queryAssRemain(String uname1, String assetsType1) {
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("uname1",uname1);
        map.put("assetsType1",assetsType1);
        Double remain = assetsDao.queryAssRemain(map);
        Assets assets = new Assets();
        assets.setMoneyRemain(remain);
        if (remain == null) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(assets);
        return result;
    }

    @Override
    public Result queryRemainByUname(String uname) {
        Result result = new Result();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("uname",uname);
        List<AssetsRemian> assetsRemians = assetsDao.queryRemainByMap(map);
        if (assetsRemians.size()==0) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(assetsRemians);
        return result;
    }
}
