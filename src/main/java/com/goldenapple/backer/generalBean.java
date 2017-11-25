/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenapple.backer;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author istzustand
 */

@Named
@RequestScoped
public class generalBean {
    
    private final String jsfVersion;

    public String getJsfVersion() {
        return jsfVersion;
    }

    public generalBean() {
        jsfVersion = FacesContext.class.getPackage().getImplementationVersion();
    }
    
    
    
    
}
