package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;
import models.Schedule;
import models.Seat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Customer> customerId;
    public static volatile SingularAttribute<Ticket, Seat> seatId;
    public static volatile SingularAttribute<Ticket, Integer> ticketID;
    public static volatile SingularAttribute<Ticket, Schedule> scheduleID;
    public static volatile SingularAttribute<Ticket, Boolean> payed;

}