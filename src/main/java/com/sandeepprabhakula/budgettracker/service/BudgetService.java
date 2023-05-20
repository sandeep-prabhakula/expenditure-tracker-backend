package com.sandeepprabhakula.budgettracker.service;

import com.sandeepprabhakula.budgettracker.data.Budget;
import com.sandeepprabhakula.budgettracker.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;

    public void addNewExpense(Budget budget) {
        budgetRepository.save(budget);
    }

    public List<Budget> getAllExpenses(String email) {
        return budgetRepository.findBudgetByEmail(email);
    }

    public void updateExpense(Budget budget) {
        Budget currentBudget = budgetRepository.findById(budget.getId())
                .orElseThrow(() -> new RuntimeException(String.format("No expense found by id " + budget.getId())));
        currentBudget.setDateOfExpense(budget.getDateOfExpense());
        currentBudget.setExpenses(budget.getExpenses());
        currentBudget.setEmail(budget.getEmail());
        budgetRepository.save(currentBudget);
    }

    public void deleteExpense(String id) {
        budgetRepository.deleteById(id);
    }
}
