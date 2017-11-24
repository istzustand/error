/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.service;

import com.goldenapple.entity.UserEntity;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author istzustand
 */

@ManagedBean
@Stateless
@Named
public class UserService {
    
    @PersistenceContext(unitName = "primary")
    EntityManager em;
    
    public UserEntity getById(long id){
        return em.find(UserEntity.class, id);
    }
    
    public void saveUser(UserEntity user){
        em.persist(user);
    }
    
    public void removeUser(UserEntity user){
        em.remove(user);
    }
    
    public List<UserEntity> getAllUsers(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> rootEntry = cq.from(UserEntity.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        CriteriaQuery<UserEntity> my = cq.select(rootEntry);
        TypedQuery<UserEntity> myQuery = em.createQuery(my);
        return myQuery.getResultList();
    }
    
    public void createFakeUsers(){
        UserEntity user = new UserEntity("Hans Wurst", 20);
        em.persist(user);
        user = new UserEntity("Dulli Kanulli", 25);
        em.persist(user);
        user = new UserEntity("Fnord", 23);
        em.persist(user);
        user = new UserEntity("Ford", 42);
        em.persist(user);
    }
}
