package com.java.csv_reader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> saveAll(List<Product> products){
        return productRepository.saveAll(products);
    }
}
