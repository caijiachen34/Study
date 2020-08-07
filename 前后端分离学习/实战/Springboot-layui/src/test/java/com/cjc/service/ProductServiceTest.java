package com.cjc.service;

import com.cjc.vo.BarVO;
import com.cjc.vo.DataVO;
import com.cjc.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void findData() {
        //DataVO<ProductVO> data = service.findData();
        //int i =0;
    }

    @Test
    void test(){
        BarVO barVO = service.getBarVO();
        System.out.println(barVO);
    }
}