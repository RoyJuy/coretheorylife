package com.coretheorylife.modules.payment.dao.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TransactionPO
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@Data
public class TransactionPO {
    private String id;

    private String transaction_number;

    private String client_id;

    private String transaction_status;

    private BigDecimal amount;

    private String order_id;

    private Date create_time;

    private Date update_time;

    private boolean is_deleted;
}
