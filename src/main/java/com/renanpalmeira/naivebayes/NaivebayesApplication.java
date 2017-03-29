package com.renanpalmeira.naivebayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.renanpalmeira.naivebayes.service.NaivebayesService;

@SpringBootApplication
public class NaivebayesApplication implements CommandLineRunner {

    @Autowired
    private NaivebayesService naivebayesService;

    @Override
    public void run(String... args) {
        System.out.println(this.naivebayesService.getHelloMessage());
        // if (args.length > 0 && args[0].equals("exitcode")) {
        // throw new ExitException();
        // }
    }

	public static void main(String[] args) {
		SpringApplication.run(NaivebayesApplication.class, args);
	}
}
