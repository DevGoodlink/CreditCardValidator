/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entitie.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.CreditCardFacade;
import model.MouchardFacade;
import model.UserFacade;

/**
 *
 * @author YASSALIE
 */
@WebService(serviceName = "CreditCardWS")
public class CreditCardWS {

    @EJB
    private UserFacade userFacade;

    @EJB
    private MouchardFacade mouchardFacade;

    @EJB
    private CreditCardFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") CreditCard entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") CreditCard entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") CreditCard entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public CreditCard find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<CreditCard> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<CreditCard> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    @WebMethod(operationName = "validate")
    public boolean validate(@WebParam(name = "entity") CreditCard entity,@WebParam(name = "token") String token) {
        ArrayList<User> lstUser =  (ArrayList<User>) this.userFacade.findAll();
        int a=1;
        Mouchard m=null;
        for( User u : lstUser){
            if(u.getToken().equals(token))
                a = entity.getCn()%2;
             m= new Mouchard(u, entity, new Date() , a==0);
        }
        if(m!=null)  this.mouchardFacade.create(m);                
        return a==0;
    }
}
