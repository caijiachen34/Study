package com.cjc.familybill.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer account_id;
    private String uname;
    private Double accountMoney;
    private String accountType;
    private String payType;
    private String assetsType;
    @JsonFormat(timezone = "GMT+8")
    private Timestamp time;
    private String remarks;
    private Double sum;
}
