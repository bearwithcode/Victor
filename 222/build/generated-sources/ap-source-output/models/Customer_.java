package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Agentprofiles;
import models.Login;
import models.Ticket;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> country;
    public static volatile ListAttribute<Customer, Ticket> ticketList;
    public static volatile SingularAttribute<Customer, String> gender;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, Integer> frequentFlierPts;
    public static volatile SingularAttribute<Customer, String> flightStatus;
    public static volatile SingularAttribute<Customer, String> creditCardType;
    public static volatile SingularAttribute<Customer, String> title;
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> streetAddress;
    public static volatile SingularAttribute<Customer, String> creditCardNum;
    public static volatile SingularAttribute<Customer, Date> dob;
    public static volatile SingularAttribute<Customer, Boolean> passportHolder;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, Agentprofiles> travelAgent;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Login> username;

}