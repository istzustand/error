/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.backer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author istzustand
 */
@ManagedBean
@SessionScoped
@Named
public class StringBean implements Serializable{
    
    private List<String> stringList;
    private String selectedString;

    public List<String> getStringList() {
        return stringList;
    }

    public String getSelectedString() {
        return selectedString;
    }

    public void setSelectedString(String selectedString) {
        this.selectedString = selectedString;
    }
    
    public void removeString(String string){
        stringList.remove(string);
    }
    
    public void removeSelectedString(){
        removeString(selectedString);
    }
    
    public void createFakeStrings(){
        stringList.add("First");
        stringList.add("Second");
        stringList.add("REEEEEEEEEEEEEEEEE");
    }

    public StringBean() {
        stringList = new ArrayList<>();
    }
    
}
