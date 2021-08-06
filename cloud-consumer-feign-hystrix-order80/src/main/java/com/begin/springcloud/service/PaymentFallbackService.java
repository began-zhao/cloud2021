package com.begin.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentHystrixService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentHystrixService fall back-paymentInfo_TimeOut";
    }
}
