package cn.linguo.entity;

import java.math.BigDecimal;
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
public class ReturnOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rodId;

    private String goodsId;

    private String goodsUnit;

    private String goodsName;

    private String goodsType;

    private String goodsColor;

    private Integer rodAmount;

    private BigDecimal rodReturnPrice;

    private BigDecimal rodTotalPrice;

    private String rodImeiList;

    private String roId;


}
