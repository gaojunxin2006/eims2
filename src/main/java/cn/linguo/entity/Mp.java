package cn.linguo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：高俊欣
 * 日期：2020/1/16
 * 微信：15000952623
 **/

@Data
@TableName("lg_mp")
public class Mp {


    @TableId
    private Long userId;


    @TableField("user_name")
    private String studentName;


    private Integer age;


    private String email;


    private Long managerId;


    private LocalDateTime createTime;


    //隐私数据，不进数据库

    //方法1 加关键字 transient，不参加序列号
    //方法2 变成静态 static。将不会自动生成get set方法
    //方法3 使用注解@TableField(exist = false) 表示不是数据库中的字段
    @TableField(exist = false)
    private String remark;







}
