package com.cjc.familybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assets {
    private Integer assets_id;
    private String uname;
    private String assetsType; //现金，银行卡
    private Double assetsMoney;
    private String remarks;
    private Double moneyRemain;
    private Double sum;
}
