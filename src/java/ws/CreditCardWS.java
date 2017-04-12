package ws;

import entitie.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import model.CreditCardFacade;
import model.MouchardFacade;
import model.UserFacade;

@WebService(serviceName = "CreditCardWS")
public class CreditCardWS {
    
    @Resource
    WebServiceContext wsContext;
    
    @EJB
    private UserFacade userFacade;

    @EJB
    private MouchardFacade mouchardFacade;


    @EJB
    private CreditCardFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    /*
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
*/
    @WebMethod(operationName = "validate")
    public boolean validate(@WebParam(name = "entity") CreditCard entity, @WebParam(name = "token") String token) {
        Mouchard mouchard = new Mouchard();
        mouchard.setDateOperation(new Date());
        mouchard.setCreditCard(entity);
        MessageContext mc = wsContext.getMessageContext();
        HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
        mouchard.setIp(req.getRemoteAddr()); 
        ejbRef.create(entity);
        ArrayList<User> lstu = (ArrayList<User>)userFacade.findAll();
        for(User u : lstu){
            if(u.getToken().equals(token))
                if(entity.getCn()%2==0){
                    mouchard.setResult(true);
                    this.mouchardFacade.create(mouchard);
                    return true;
                }
            mouchard.setDescription("token inconnu");
        }
        mouchard.setResult(false);
        mouchard.setDescription("carte invalide");
        this.mouchardFacade.create(mouchard);
        return false;
    }
    
}
