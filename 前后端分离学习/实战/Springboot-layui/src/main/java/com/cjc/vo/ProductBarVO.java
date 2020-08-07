package com.cjc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductBarVO {
    private String name;
    @JsonProperty("value") //设定返回json数据时字段count改为value
    private Integer count;
}
