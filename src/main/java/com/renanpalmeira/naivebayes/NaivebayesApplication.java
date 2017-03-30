package com.renanpalmeira.naivebayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.renanpalmeira.naivebayes.simple.service.SimpleNaivebayesService;

@SpringBootApplication
public class NaivebayesApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        SimpleNaivebayesService twitterCategorizer = new SimpleNaivebayesService();
        twitterCategorizer.trainModel();
        twitterCategorizer.classifyNewTweet("Calça");
    }

	public static void main(String[] args) {
		SpringApplication.run(NaivebayesApplication.class, args);
	}
}
