package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> password;
    public static volatile SingularAttribute<Login, String> role;
    public static volatile SingularAttribute<Login, String> username;
    public static volatile SingularAttribute<Login, Customer> customer;

}