package com.thymeleaf.thymeleafapp.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer Id;
    @NotNull
    public String name;
    @NotNull
    public String department;
    @NotNull
    public String updatedBy;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String updatedOn;

    public Student(){};

    public Student(String name, String department, String updatedBy, String updatedOn) {
        this.name = name;
        this.department = department;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }

    public Student(String name, String department, String updatedBy){
        this.name = name;
        this.department = department;
        this.updatedBy = updatedBy;



    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        this.updatedOn = formatter.format(date);
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
