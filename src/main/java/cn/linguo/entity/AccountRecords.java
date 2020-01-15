package cn.linguo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class AccountRecords implements Serializable {

    private static final long serialVersionUID = 1L;

    private String arId;

    private Integer supId;

    private LocalDate arDate;

    private String arOrderId;

    private String arBusType;

    private BigDecimal arPayable;

    private BigDecimal arPaid;

    private BigDecimal arArrears;

    private BigDecimal arDiscount;

    private String arAttn;

    private Integer arOperator;

    private String arRemark;


}
