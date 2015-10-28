package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Agentprofiles.class)
public class Agentprofiles_ { 

    public static volatile SingularAttribute<Agentprofiles, Integer> agentId;
    public static volatile SingularAttribute<Agentprofiles, String> phone;
    public static volatile SingularAttribute<Agentprofiles, String> travelAgent;
    public static volatile ListAttribute<Agentprofiles, Customer> customerList;
    public static volatile SingularAttribute<Agentprofiles, String> email;

}