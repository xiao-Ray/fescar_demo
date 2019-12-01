package com.demo.entity;

import lombok.Data;

@Data
public class Order extends BaseEntity {

    private String orderName;
    private Double money;
}
