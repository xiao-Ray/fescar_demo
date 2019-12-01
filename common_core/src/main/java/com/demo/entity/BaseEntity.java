package com.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基本类
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * mybatis-plus会自动插入一个id到实体对象, 不管你封装与否, 所以有时候导致一些意外的情况发生
     * 其他type类型:
     * AUTO : AUTO(0, “数据库ID自增”),
     * INPUT : INPUT(1, “用户输入ID”),
     * ID_WORKER : ID_WORKER(2, “全局唯一ID”),
     * UUID : UUID(3, “全局唯一ID”),
     * NONE : NONE(4, “该类型为未设置主键类型”),
     * ID_WORKER_STR : ID_WORKER_STR(5, “字符串全局唯一ID”);
     */
    @TableId(value = "id",type = IdType.AUTO )
    private Long id;
    private Date createTime;
    private Date modifyTime;
    private Integer state;  //0-删除, 1-正常

}
