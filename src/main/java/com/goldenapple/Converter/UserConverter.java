/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.Converter;

import com.goldenapple.entity.UserEntity;
import com.goldenapple.service.UserService;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author istzustand
 */
//@FacesConverter(forClass = UserEntity.class, managed = true)
@Named
@RequestScoped
public class UserConverter implements Converter {

    @Inject
    UserService userService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof UserEntity) {
            return String.valueOf(((UserEntity) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid User"));
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        System.out.println("submitted: " + Long.valueOf(submittedValue));

        if (submittedValue == null || submittedValue.isEmpty()) {
            System.out.println("submitted = nil");
            return null;
        }

        try {
            return userService.getById(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid User ID"), e);
        }
    }

}
