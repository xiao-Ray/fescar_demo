package com.demo.entity;

import lombok.Data;

@Data
public class Account extends BaseEntity{

    private String userName;

    private Double money;

}
