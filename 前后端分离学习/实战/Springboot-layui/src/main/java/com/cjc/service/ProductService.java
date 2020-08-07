package com.cjc.service;

import com.cjc.pojo.Product;
import com.cjc.vo.BarVO;
import com.cjc.vo.DataVO;
import com.cjc.vo.PieVO;
import com.cjc.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);

    public BarVO getBarVO();

    public List<PieVO> getPieVO1();
}
