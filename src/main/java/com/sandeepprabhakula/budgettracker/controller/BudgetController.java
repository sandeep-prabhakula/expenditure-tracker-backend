package com.sandeepprabhakula.budgettracker.controller;

import com.sandeepprabhakula.budgettracker.data.Budget;
import com.sandeepprabhakula.budgettracker.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/budget")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/get-all-expenses/{email}")
    public List<Budget> getAllExpenses(@PathVariable("email") String email, Authentication authentication) {
        String userName = authentication.getName();
        List<Budget> budgetList = budgetService.getAllExpenses(email);
        List<Budget> filter = new ArrayList<>();
        for (Budget budget : budgetList) {

            if (userName.equals(budget.email)) {
                filter.add(budget);
            }
        }

        return filter;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @CrossOrigin(origins = "*")
    @PostMapping("/add-new-expense")
    public ResponseEntity<String> addNewExpense(@RequestBody Budget budget, Authentication auth) {
        if(budget.getEmail().equals(auth.getName()))budgetService.addNewExpense(budget);
        return ResponseEntity.status(401).body("Access Denied");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-expense/{id}")
    public void deleteExpense(@PathVariable("id") String id) {
        budgetService.deleteExpense(id);
    }


    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @CrossOrigin(origins = "*")
    @PutMapping("/update-expense")
    public ResponseEntity<String> updateExpense(@RequestBody Budget budget,Authentication auth) {
        if(auth.getName().equals(budget.getEmail()))budgetService.updateExpense(budget);
        return ResponseEntity.status(401).body("Access Denied");
    }
}
