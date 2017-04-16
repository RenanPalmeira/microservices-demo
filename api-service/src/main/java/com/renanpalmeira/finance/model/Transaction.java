package com.renanpalmeira.finance.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity(name="transactions")
@ToString(exclude="idTransaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_transaction")
    @Getter
    @Setter
    private Long idTransaction;

    @Getter
    @Setter
    private String description;
}