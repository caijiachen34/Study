package com.cjc.familybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetsRemian {
    private Integer remain_id;
    private String uname;
    private String assets_type;
    private Double remain_money;

}
