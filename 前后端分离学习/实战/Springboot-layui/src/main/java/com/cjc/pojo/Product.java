package com.cjc.pojo;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private Integer categorylevelthreeId;
    private String fileName;


}
