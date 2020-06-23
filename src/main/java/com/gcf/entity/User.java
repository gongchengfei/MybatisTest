package com.gcf.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {
    private String productId;
    private String serialNo;
    private String remark;
    private String inputUserId;
    private String inputOrgId;
    private LocalDate inputDate;
}
