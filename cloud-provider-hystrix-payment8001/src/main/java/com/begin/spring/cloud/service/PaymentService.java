package com.begin.spring.cloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 83456
 */
public interface PaymentService {
    /**
     * 正常访问，一切OK
     *
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 超时访问，演示降级
     *
     * @param id
     * @return
     */
    String paymentInfo_TimeOut(Integer id);

    /**
     *服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}