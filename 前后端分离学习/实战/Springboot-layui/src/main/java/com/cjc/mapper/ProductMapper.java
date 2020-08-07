package com.cjc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjc.pojo.Product;
import com.cjc.vo.ProductBarVO;
import com.cjc.vo.ProductVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT p.`name`,SUM(quantity) count from order_detail od,product p WHERE od.product_id = p.id GROUP BY product_id")
    public List<ProductBarVO> findAllProductBarVO();
}
