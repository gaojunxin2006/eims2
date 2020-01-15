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
public class BuyOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bodId;

    private String goodsId;

    private String goodsName;

    private String goodsUnit;

    private String goodsType;

    private String goodsColor;

    private Integer bodAmount;

    private BigDecimal bodBuyPrice;

    private BigDecimal bodTotalPrice;

    private String boId;

    private String bodImeiList;


}
