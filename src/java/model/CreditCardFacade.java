/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entitie.CreditCard;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YASSALIE
 */
@Stateless
public class CreditCardFacade extends AbstractFacade<CreditCard> {

    @PersistenceContext(unitName = "ApplicationCreditCardValidatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreditCardFacade() {
        super(CreditCard.class);
    }
    
}
