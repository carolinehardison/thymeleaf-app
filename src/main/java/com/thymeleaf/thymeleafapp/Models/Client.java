package com.thymeleaf.thymeleafapp.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @NotNull
    public String type;
    @NotNull
    @Email
    public String email;
    @NotNull
    @Length(min=8)
    public String password;

    public Client(){

    }

    public Client(String email, String password, String type){
        this.email= email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
