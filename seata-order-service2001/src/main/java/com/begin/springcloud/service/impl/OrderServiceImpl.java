package com.begin.springcloud.service.impl;

import com.begin.springcloud.dao.OrderDao;
import com.begin.springcloud.domain.Order;
import com.begin.springcloud.service.AccountService;
import com.begin.springcloud.service.OrderService;
import com.begin.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountService accountService;
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "fsp_create_order",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("---------》开始新建订单");
        orderDao.create(order);


        log.info("------------>订单微服务开始调用减库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------------>订单微服务开始调用账户，做扣减end");


        log.info("------------>订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------------>订单微服务开始调用账户，做扣减end");



        log.info("---------》修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("---------》修改订单状态结束");

        log.info("---------》下订单结束了");

    }
}
