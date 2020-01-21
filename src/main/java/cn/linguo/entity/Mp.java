package cn.linguo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：高俊欣
 * 日期：2020/1/16
 * 微信：15000952623
 **/

//开发AR模式


@Data   //通过他实现不写get set toString等方法
@TableName("lg_mp")
public class Mp extends Model<Mp> {

    //自定义id
    //@TableId(type = IdType.NONE)

    //IdType.Id_Auto是自增模式

    //雪花算法
    @TableId(type = IdType.ID_WORKER)
    private Long userId;


    @TableField("user_name")
    private String studentName;


    private Integer age;


    private String email;


    private Long managerId;

    //创建时间，在新增的时候自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    //隐私数据，不进数据库

    //方法1 加关键字 transient，不参加序列号
    //方法2 变成静态 static。将不会自动生成get set方法
    //方法3 使用注解@TableField(exist = false) 表示不是数据库中的字段
    @TableField(exist = false)
    private String remark;



    //修改时间.在更新时填充
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


    //版本 （0未删除，1已删除）
    @TableLogic()
    //sql语句不查询这个字段
    @TableField(select = false)
    private Integer deleted;


    @Version
    private Integer version;









}
