package com.example.j6store.service.impl;

import com.example.j6store.dao.ProductDAO;
import com.example.j6store.entity.Product;
import com.example.j6store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }
}
