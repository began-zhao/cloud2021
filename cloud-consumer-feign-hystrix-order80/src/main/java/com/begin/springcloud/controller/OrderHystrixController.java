package com.begin.springcloud.controller;

import com.begin.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 83456
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_OK(id);
        return result;
    };


//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
@GetMapping("/consumer/payment/hystrix/timeout/{id}")
@HystrixCommand
    String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    };
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试或者检查自己运行出现问题！";

    }

    //下面是全局fallback方法
    public  String payment_Global_FallbackMethod(){
        return "Global异常处理异常信息，请稍后再试！";
    }
}
