/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitie.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.UserFacade;

/**
 *
 * @author YASSALIE
 */
@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {

    @EJB
    private UserFacade userFacade;

    private User user;
    private String erreur="";
    
    public UserMB() {
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String isUser(){
        User user0= userFacade.find(this.user.getId());
        
        if(user0==null){
            this.erreur="Login ou mot de passe incorrect";
            return "toindex";
        }
        else{
            return "tohome";
        }
        
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }
    public String createUser(){
        this.user.setToken(this.user.getPassword(), this.user.getLogin());
        userFacade.create(this.user);
        return "tohome";
    }
}
