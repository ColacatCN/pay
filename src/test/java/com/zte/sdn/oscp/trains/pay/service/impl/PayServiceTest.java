package com.zte.sdn.oscp.trains.pay.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.zte.sdn.oscp.trains.pay.PayApplicationTests;
import com.zte.sdn.oscp.trains.pay.service.IPayService;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private IPayService payService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void create() {
        payService.create("123456789038255", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }

    @Test
    public void testRabbitMQ() {
        amqpTemplate.convertAndSend("payNotify", "goodbye");
    }
}
