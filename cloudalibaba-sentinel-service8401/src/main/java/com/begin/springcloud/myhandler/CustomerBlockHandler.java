package com.begin.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import entities.CommonResult;

/**
 * @author 83456
 */
public class CustomerBlockHandler {
    public static CommonResult handlerExeption(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerExeption");
    }
    public static CommonResult handlerExeption2(BlockException exception){
        return new CommonResult(4444,"按客户自定义2，global handlerExeption");
    }
}
