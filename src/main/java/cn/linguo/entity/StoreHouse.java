package cn.linguo.entity;

import java.io.Serializable;
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
public class StoreHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String shId;

    private String shName;

    private String shResponsible;

    private String shPhone;

    private String shAddress;

    private String shType;

    private String shRemark;


}
