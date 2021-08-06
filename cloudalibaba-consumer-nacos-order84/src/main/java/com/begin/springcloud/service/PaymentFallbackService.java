package com.begin.springcloud.service;

import com.begin.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 83456
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
