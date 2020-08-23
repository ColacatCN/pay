package com.zte.sdn.oscp.trains.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.zte.sdn.oscp.trains.pay.pojo.PayInfo;

import java.math.BigDecimal;

public interface IPayService {

    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    String asyncNotify(String notifyData);

    PayInfo queryByOrderId(String orderId);
}
