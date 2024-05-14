package com.haomu.app.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Reserve {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String wxOpenid;
    private Date reserve_time;
}
