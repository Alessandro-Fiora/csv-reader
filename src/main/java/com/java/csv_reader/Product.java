package com.java.csv_reader;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CsvBindByName
    @NotBlank (message = "il campo name è obbligatorio")
    private String name;

    @CsvBindByName
    @NotBlank (message = "il campo barcode è obbligatorio")
    private String barcode;

    @CsvBindByName
    @NotBlank (message = "il campo brand è obbligatorio")
    private String brand;

    @CsvBindByName
    @NotBlank (message = "il campo category è obbligatorio")
    private String category;

    @CsvBindByName
    @NotNull (message = "il campo quantity è obbligatorio")
    private Integer quantity;

    @CsvBindByName
    @NotNull (message = "il campo weight è obbligatorio")
    private double weight;

    @CsvBindByName
    private BigDecimal price;

    

    // Getters e Setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
