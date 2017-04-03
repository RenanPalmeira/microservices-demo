package com.renanpalmeira.naivebayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.renanpalmeira.naivebayes.simple.service.SimpleNaivebayesService;

@SpringBootApplication
public class NaivebayesApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        SimpleNaivebayesService naivebayes = new SimpleNaivebayesService();
        naivebayes.trainModel();
        naivebayes.classify("Calça");
    }

	public static void main(String[] args) {
		SpringApplication.run(NaivebayesApplication.class, args);
	}
}
