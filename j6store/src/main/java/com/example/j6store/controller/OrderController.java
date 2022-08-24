package com.example.j6store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping("/order/checkout")
    public String checkout(){
      return "order/checkout";
    };
    @RequestMapping("/order/list")
    public String list(){
        return "order/checkout";
    };
    @RequestMapping("/order/detail/{id}")
    public String detail(){
        return "order/detail";
    };
}
