package com.renanpalmeira.finance.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renanpalmeira.finance.model.Transaction;
import com.renanpalmeira.finance.repository.TransactionRepository;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        List<Transaction> transactions = repository.findAll();
        model.put("transactions", transactions);
        return "index";
    }
}
