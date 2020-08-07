package com.cjc.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjc.mapper.ProductCategoryMapper;
import com.cjc.mapper.ProductMapper;
import com.cjc.pojo.Product;
import com.cjc.pojo.ProductCategory;
import com.cjc.service.ProductService;
import com.cjc.vo.*;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVO<ProductVO> findData(Integer page,Integer limit) {
        //设置头部信息
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        //分页操作
        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result = productMapper.selectPage(productIPage, null);
        //selectCount(null)：查询数据个数，null：不传值，查询全部
        dataVO.setCount(result.getTotal());

        List<Product> productList = result.getRecords();
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product : productList) {
            ProductVO productVO= new ProductVO();
            BeanUtils.copyProperties(product,productVO);

            QueryWrapper wrapper;
            ProductCategory productCategory;

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategorylevelone(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategoryleveltwo(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategorylevelthree(productCategory.getName());
            }


            productVOList.add(productVO);
        }

        dataVO.setData(productVOList);
        return dataVO;
    }

    @Override
    public BarVO getBarVO() {
        List<ProductBarVO> list = productMapper.findAllProductBarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (ProductBarVO productBarVO : list) {
            names.add(productBarVO.getName());
            values.add(productBarVO.getCount());
        }
        BarVO barVo = new BarVO();
        barVo.setName(names);
        barVo.setCounts(values);
        return barVo;
    }

    @Override
    public List<PieVO> getPieVO1() {
        List<ProductBarVO> list = productMapper.findAllProductBarVO();
        List<PieVO> pieVOList = new ArrayList<>();
        /*List<PieVO> pieVO = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());*/
        String name = list.get(1).getName();
        Integer count = list.get(1).getCount();
        for (int i = 0;i<list.size();i++){
            PieVO pieVO = new PieVO(35,"aa");
            pieVO.setName(list.get(i).getName());
            pieVO.setValue(list.get(i).getCount());
            pieVOList.add(i,pieVO);
        }
            return pieVOList;
    }
}
