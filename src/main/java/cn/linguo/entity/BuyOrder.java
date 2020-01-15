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
public class BuyOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String boId;

    private Integer supId;

    private String shId;

    private LocalDate boDate;

    private BigDecimal boPayable;

    private BigDecimal boPaid;

    private BigDecimal boArrears;

    private String boOriginal;

    private String boRemark;

    private String boAttn;

    private Integer boOperator;


}
