package com.sandeepprabhakula.budgettracker.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Getter
@Setter
@Data
public class User {

    @Id
    private String id;

    private String email;

    private String password;

    private String roles;

    public User(String email,String password,String roles){
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(){}
}
