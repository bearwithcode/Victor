package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Airport;
import models.Schedule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Integer> routeID;
    public static volatile ListAttribute<Route, Schedule> scheduleList;
    public static volatile SingularAttribute<Route, String> codeShare;
    public static volatile SingularAttribute<Route, Airport> sourceAirport;
    public static volatile SingularAttribute<Route, Integer> stops;
    public static volatile SingularAttribute<Route, Boolean> internationalFlight;
    public static volatile SingularAttribute<Route, Airport> destinationAirport;

}