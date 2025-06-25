package com.java.csv_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

@SpringBootApplication
public class CsvReaderApplication {

	public static void main(String[] args) throws CsvValidationException, IOException {
		SpringApplication.run(CsvReaderApplication.class, args);

	try {
		CSVReader reader = new CSVReaderBuilder(new FileReader("prodotti.csv")).build();
		String [] nextLine;
		while ((nextLine = reader.readNext()) != null) {
		   // nextLine[] is an array of values from the line
		   System.out.println(nextLine[0] + nextLine[1] + "etc...");
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}

}
