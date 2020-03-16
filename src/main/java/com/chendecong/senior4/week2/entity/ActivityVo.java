package com.chendecong.senior4.week2.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActivityVo extends Activity {

    private String good_name;
    private BigDecimal price;
    private String s;
    private String e;

}
