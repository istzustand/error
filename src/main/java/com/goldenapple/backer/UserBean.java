/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.backer;

import com.goldenapple.entity.UserEntity;
import com.goldenapple.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author istzustand
 */
@ManagedBean
@SessionScoped
@Named
public class UserBean implements Serializable {

    @Inject
    UserService userService;

    UserEntity selectedUser;

    private List<UserEntity> userList;

    public UserEntity getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserEntity selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<UserEntity> getUserList() {
        userList = userService.getAllUsers();
        return userList;
    }
    
    public void removeUser(UserEntity user){
        userService.removeUser(user);
    }
    
    public void removeSelectedUser(){
        removeUser(selectedUser);
    }
}
