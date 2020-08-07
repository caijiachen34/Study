package com.cjc.controller;

import com.cjc.mapper.ProductMapper;
import com.cjc.service.ProductService;
import com.cjc.vo.BarVO;
import com.cjc.vo.DataVO;
import com.cjc.vo.PieVO;
import com.cjc.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @ResponseBody
    @RequestMapping("/list")
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page,limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }

    @RequestMapping("/pieVO1")
    @ResponseBody
    public List<PieVO> getPieVO1(){
        return productService.getPieVO1();
    }

    @RequestMapping("/pieVO2")
    @ResponseBody
    public List<ProductBarVO> getPieVO2(){
        return productMapper.findAllProductBarVO();
    }



}
