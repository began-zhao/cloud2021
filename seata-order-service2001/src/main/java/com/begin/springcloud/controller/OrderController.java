package com.begin.springcloud.controller;

import com.begin.springcloud.domain.CommonResult;
import com.begin.springcloud.domain.Order;
import com.begin.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 83456
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult creat(Order order){
        orderService.create(order);
        return  new CommonResult(200,"订单创建成功");
    }


}
