package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Fleet;
import models.Route;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Airport.class)
public class Airport_ { 

    public static volatile SingularAttribute<Airport, String> country;
    public static volatile SingularAttribute<Airport, Integer> altitude;
    public static volatile SingularAttribute<Airport, String> dst;
    public static volatile SingularAttribute<Airport, String> city;
    public static volatile SingularAttribute<Airport, Integer> airportID;
    public static volatile SingularAttribute<Airport, Double> latitude;
    public static volatile SingularAttribute<Airport, String> timeZone;
    public static volatile SingularAttribute<Airport, String> iata;
    public static volatile ListAttribute<Airport, Fleet> fleetList;
    public static volatile SingularAttribute<Airport, String> name;
    public static volatile ListAttribute<Airport, Route> routeList1;
    public static volatile ListAttribute<Airport, Route> routeList;
    public static volatile SingularAttribute<Airport, Double> longitude;

}