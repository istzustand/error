/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.Facade;

import com.goldenapple.entity.UserEntity;
import com.goldenapple.service.UserService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author istzustand
 */

@Stateless
@Path("user")
public class UserFacade {
    
    @Inject
    UserService userService;
    
    @GET
    public List<UserEntity> getAll(){
        return userService.getAllUsers();
    }
    
    @GET
    @Path("{id}")
    public UserEntity getById(@PathParam("id") long id){
        return userService.getById(id);
    }
    
    @POST
    public void newUser(UserEntity user){
        userService.saveUser(user);
    }
    
    @DELETE
    @Path("{id}")
    public void remUserById(@PathParam("id") long id){
        UserEntity user = userService.getById(id);
        userService.removeUser(user);
    }
        
}
