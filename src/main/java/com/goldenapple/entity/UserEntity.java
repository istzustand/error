/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author istzustand
 */

@Entity
public class UserEntity implements Serializable{
    
    private String name;
    private int age;
    
    @Id
    @GeneratedValue
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserEntity() {
    }
    
    
    
    
    
}
