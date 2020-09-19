package com.shopping.cart.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

  @GetMapping("/shopping")
  public String getShoppingController(){
    return "<h1>Shopping Service called</h1>";
  }
}
