package com.sandeepprabhakula.budgettracker.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

@JsonPropertyOrder({
        "expenseType",
        "amount"
})
@AllArgsConstructor
public class Expense {
    @JsonProperty("expenseType")
    private String expenseType;
    @JsonProperty("amount")
    private long amount;
}
