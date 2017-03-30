package entitie;

import entitie.CreditCard;
import entitie.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T16:08:31")
@StaticMetamodel(Mouchard.class)
public class Mouchard_ { 

    public static volatile SingularAttribute<Mouchard, Boolean> result;
    public static volatile SingularAttribute<Mouchard, Long> id;
    public static volatile SingularAttribute<Mouchard, CreditCard> creditCard;
    public static volatile SingularAttribute<Mouchard, Date> dateOperation;
    public static volatile SingularAttribute<Mouchard, User> user;

}