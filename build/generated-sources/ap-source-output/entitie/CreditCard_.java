package entitie;

import entitie.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T16:08:31")
@StaticMetamodel(CreditCard.class)
public class CreditCard_ { 

    public static volatile SingularAttribute<CreditCard, String> expiryDate;
    public static volatile SingularAttribute<CreditCard, String> number;
    public static volatile SingularAttribute<CreditCard, Long> id;
    public static volatile SingularAttribute<CreditCard, Integer> cn;
    public static volatile SingularAttribute<CreditCard, String> type;
    public static volatile SingularAttribute<CreditCard, User> user;

}