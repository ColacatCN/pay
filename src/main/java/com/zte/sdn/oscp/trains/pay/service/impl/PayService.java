package com.zte.sdn.oscp.trains.pay.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.zte.sdn.oscp.trains.pay.service.IPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class PayService implements IPayService {

    @Autowired
    private BestPayService bestPayService;

    @Override
    public PayResponse create(String orderId, BigDecimal amount) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("A");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);
        return bestPayService.pay(payRequest);
    }

    @Override
    public String asyncNotify(String notifyData) {
        // 1. 签名校验
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("payResponse = {}", payResponse);

        // 2. 金额校验（ 从数据库中查订单 ）

        // 3. 修改订单的支付状态

        // 4. 告知微信不要再次通知
        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }
}
