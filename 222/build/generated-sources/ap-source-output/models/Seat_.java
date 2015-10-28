package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Airplane;
import models.Ticket;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-17T16:02:47")
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile ListAttribute<Seat, Ticket> ticketList;
    public static volatile SingularAttribute<Seat, String> seatClass;
    public static volatile SingularAttribute<Seat, Airplane> planeID;
    public static volatile SingularAttribute<Seat, Integer> seatId;
    public static volatile SingularAttribute<Seat, String> seatNumber;
    public static volatile SingularAttribute<Seat, Boolean> occupied;

}