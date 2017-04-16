package com.renanpalmeira.finance.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.renanpalmeira.finance.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}