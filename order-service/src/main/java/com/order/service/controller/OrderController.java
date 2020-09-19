package com.order.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/order")
  @HystrixCommand(fallbackMethod = "getFallBackMessage")
  public  String getOrder(){
    String url = "http://SHOPPING-CART-SERVICE/shopping";

    String result = restTemplate.getForObject(url, String.class);

    return result;
  }

  public  String getFallBackMessage(){
    return "<H1>Work in Progress</h1>";
  }
}
