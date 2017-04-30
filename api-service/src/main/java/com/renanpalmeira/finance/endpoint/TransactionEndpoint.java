package com.renanpalmeira.finance.endpoint;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renanpalmeira.finance.model.Transaction;
import com.renanpalmeira.finance.repository.TransactionRepository;
import com.renanpalmeira.finance.resource.TransactionResource;
import com.renanpalmeira.finance.resource.TransactionResourceAssembler;

@RestController
@RequestMapping("/api/transaction")
public class TransactionEndpoint {

    @Autowired
    private TransactionRepository repository;

    private TransactionResourceAssembler assembler = new TransactionResourceAssembler();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Resources<TransactionResource> getTransactions() {
        return new Resources(assembler.toResources(repository.findAll()));
    }

    @RequestMapping(value="/rx", method = RequestMethod.GET)
    @ResponseBody
    Resources<List> getItemsRx() {

        List<String> items = new ArrayList<>();
        items.add("Netflix");
        items.add("Spotify");

        return new Resources(items);
    }
}
