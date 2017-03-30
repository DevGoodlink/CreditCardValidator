/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitie.CreditCard;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.CreditCardFacade;

/**
 *
 * @author YASSALIE
 */
@Named(value = "creditCardMB")
@SessionScoped
public class CreditCardMB implements Serializable {

    @EJB
    private CreditCardFacade creditCardFacade;
   
    private CreditCard creditCard;
    
    private String token;
    
    public CreditCardMB() {
    }

    public CreditCardFacade getCreditCardFacade() {
        return creditCardFacade;
    }

    public void setCreditCardFacade(CreditCardFacade creditCardFacade) {
        this.creditCardFacade = creditCardFacade;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    
    
    
}
