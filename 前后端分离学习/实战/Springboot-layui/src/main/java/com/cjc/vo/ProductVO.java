package com.cjc.vo;

import lombok.Data;

@Data
public class ProductVO {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String categorylevelone;
    private String categoryleveltwo;
    private String categorylevelthree;
    private String fileName;
}
