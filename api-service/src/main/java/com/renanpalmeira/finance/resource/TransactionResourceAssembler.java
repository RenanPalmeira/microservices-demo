package com.renanpalmeira.finance.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.renanpalmeira.finance.model.Transaction;
import com.renanpalmeira.finance.resource.TransactionResource;
import com.renanpalmeira.finance.endpoint.TransactionEndpoint;

public class TransactionResourceAssembler extends ResourceAssemblerSupport<Transaction, TransactionResource> {

    public TransactionResourceAssembler() {
        super(TransactionEndpoint.class, TransactionResource.class);
    }

    @Override
    public TransactionResource toResource(Transaction transaction) {
        TransactionResource resource = instantiateResource(transaction);
        resource.setDescription(transaction.getDescription());
        return resource;
    }
}