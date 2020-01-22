package cn.linguo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author linguo
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "goods_Id",type = IdType.ID_WORKER)
    //type = IdType.AUTO 通过注解自增.IdType.ID_WORKER雪花算法
    private Integer goodsId;

//    @TableField(value ="goods_name")
    //注解指定属性对应的列名
    private String goodsName;

    private String goodsUnit;

    private String goodsType;

    private String goodsColor;

    private Integer goodsStore;

    private Integer goodsLimit;

    private BigDecimal goodsCommission;

    private String goodsProducer;

    private String goodsRemark;

    private BigDecimal goodsSelPrice;

    private BigDecimal goodsBuyPrice;

    //工资，数据库无此字段
    @TableField(exist = false)
    private double salary;

    //创建时自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    private Integer manager;



    //版本控制。乐观锁
    @Version
    private Integer version;

    @TableLogic()
    //删除  版本 （0未删除，1已删除）
    private Integer deleted;










}
