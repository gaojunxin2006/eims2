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
public class ReturnOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roId;

    private Integer supId;

    private String shId;

    private LocalDate roDate;

    private BigDecimal roPayable;

    private BigDecimal roPaid;

    private String roRemark;

    private String roAttn;

    private Integer roOperator;


}
