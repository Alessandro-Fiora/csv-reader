package com.java.csv_reader;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class UploadController {

    @Autowired
    private ProductService productService;

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            List<Product> beans = new CsvToBeanBuilder<Product>(new InputStreamReader(file.getInputStream()))
                .withType(Product.class)
                .build()
                .parse();
            productService.saveAll(beans);
            model.addAttribute("message", "Importazione completata: " + beans.size() + " prodotti salvati.");
            model.addAttribute("prodotti", beans);
        } catch (Exception e) {
            model.addAttribute("message", "Errore durante l'importazione: " + e.getMessage());
        }
        return "upload";
    }
}