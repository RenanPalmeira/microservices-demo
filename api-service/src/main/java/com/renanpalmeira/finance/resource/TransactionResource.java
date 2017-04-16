package com.renanpalmeira.finance.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "transaction")
public class TransactionResource extends ResourceSupport {
    @Getter
    @Setter
    private String description;
}