package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Fleet;
import models.Schedule;
import models.Seat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Airplane.class)
public class Airplane_ { 

    public static volatile SingularAttribute<Airplane, Fleet> onefleet;
    public static volatile SingularAttribute<Airplane, Integer> total;
    public static volatile SingularAttribute<Airplane, Integer> firstClass;
    public static volatile ListAttribute<Airplane, Schedule> scheduleList;
    public static volatile SingularAttribute<Airplane, Integer> premiumClass;
    public static volatile SingularAttribute<Airplane, Integer> businessClass;
    public static volatile SingularAttribute<Airplane, Integer> economyClass;
    public static volatile SingularAttribute<Airplane, Integer> planeID;
    public static volatile ListAttribute<Airplane, Seat> seatList;

}