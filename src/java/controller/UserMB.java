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
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.UserFacade;
import tool.SHA;

/**
 *
 * @author YASSALIE
 */
@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {

    @EJB
    private UserFacade userFacade;
    private User user=new User();
    private String erreur;
    public UserMB() {
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String newUser(){
       Date d = new Date();
        try {
            user.setToken(SHA.sha1(user.getLogin()+user.getPassword()+d.getTime()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserMB.class.getName()).log(Level.SEVERE, null, ex);
        }
       userFacade.create(user);
       return "tohome";
    }
    public String isUser(){
        List<User> lstu = userFacade.findAll();
        for(User u:lstu){
            if(u.getLogin().equalsIgnoreCase(this.user.getLogin())){
                if(u.getPassword().equals(user.getPassword())){
                    this.user=u;
                    return "tohome";
                }
                this.erreur ="Password incorrect";
            }
        }
        this.erreur="login et password incorrects";
        return "toindex";
    }
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

}
