package com.sandeepprabhakula.budgettracker.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("budget")
@Data
public class Budget {
    @Id
    private String id;

    private String dateOfExpense;

    public String email;

    private List<Expense>expenses;

    public Budget(String dateOfExpense,String email,List<Expense>expenses){
        this.dateOfExpense = dateOfExpense;
        this.email = email;
        this.expenses = expenses;
    }
}
