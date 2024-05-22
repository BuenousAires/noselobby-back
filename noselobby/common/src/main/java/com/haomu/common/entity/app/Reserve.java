package com.haomu.common.entity.app;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Reserve {
    @TableId(type = IdType.INPUT)
    private String id;
    private String wxOpenid;
    private Date reserveTime;
}
