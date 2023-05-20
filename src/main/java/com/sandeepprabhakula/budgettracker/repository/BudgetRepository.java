package com.sandeepprabhakula.budgettracker.repository;

import com.sandeepprabhakula.budgettracker.data.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends MongoRepository<Budget,String> {
    List<Budget> findBudgetByEmail(String email);
}
