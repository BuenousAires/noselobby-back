package com.haomu.common.entity.app.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReserveVO {
    private String id;
    private String nickName;
    private String telNumber;
    private Date reserveTime;
}
