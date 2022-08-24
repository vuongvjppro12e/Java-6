package com.example.j6store.controller;

import com.example.j6store.entity.Product;
import com.example.j6store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    public String list(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("items",list);
        return "product/list";
    }


    @RequestMapping("/product/detail/{id}")
    public String detail(){
        return "product/detail";
    }
}
