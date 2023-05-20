package com.sandeepprabhakula.budgettracker;

import com.sandeepprabhakula.budgettracker.data.Budget;
import com.sandeepprabhakula.budgettracker.data.Expense;
import com.sandeepprabhakula.budgettracker.data.User;
import com.sandeepprabhakula.budgettracker.repository.BudgetRepository;
import com.sandeepprabhakula.budgettracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BudgetTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetTrackerApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(BudgetRepository budgets, UserRepository users, PasswordEncoder encoder) {
//        return args -> {
//            users.save(new User("sandeepprabhakula10@gmail.com", encoder.encode("password"), "ROLE_USER"));
//            users.save(new User("sandeep45.200.100@gmail.com", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
//            List<Expense> expense = new ArrayList<>();
//            expense.add(new Expense("food", 500));
//            expense.add(new Expense("Fuel", 1500));
//
//            budgets.save(new Budget("2023-05-20",
//                    "sandeep45.200.100@gmail.com",
//                    expense));
//            budgets.save(new Budget("2023-05-21",
//                    "sandeep45.200.100@gmail.com",
//                    expense));
//        };
//    }
}
