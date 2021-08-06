package com.begin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 83456
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private  String configInfo;

    @Value("${server.port}")
    private  String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return "serverPort:"+serverPort+"\t\n\nconfigInfo:"+configInfo;
    }
}
