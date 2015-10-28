package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Airplane;
import models.Airport;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Fleet.class)
public class Fleet_ { 

    public static volatile ListAttribute<Fleet, Airplane> airplaneList;
    public static volatile SingularAttribute<Fleet, Airport> airportITIA;
    public static volatile SingularAttribute<Fleet, Integer> fleetID;
    public static volatile SingularAttribute<Fleet, Integer> inService;

}