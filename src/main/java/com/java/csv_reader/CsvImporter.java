package com.java.csv_reader;

import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class CsvImporter implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        List<Product> beans = new CsvToBeanBuilder<Product>(new FileReader("prodotti.csv"))
            .withType(Product.class)
            .build()
            .parse();

        productService.saveAll(beans);
        System.out.println("Importazione completata: " + beans.size() + " prodotti salvati.");
    }
}
