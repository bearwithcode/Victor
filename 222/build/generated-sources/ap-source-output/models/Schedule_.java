package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Airplane;
import models.Route;
import models.Ticket;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, String> arriveTime;
    public static volatile ListAttribute<Schedule, Ticket> ticketList;
    public static volatile SingularAttribute<Schedule, String> departTime;
    public static volatile SingularAttribute<Schedule, Route> routeID;
    public static volatile SingularAttribute<Schedule, Date> arriveDate;
    public static volatile SingularAttribute<Schedule, Airplane> planeID;
    public static volatile SingularAttribute<Schedule, Date> departDate;
    public static volatile SingularAttribute<Schedule, Integer> scheduleID;

}