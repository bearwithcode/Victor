/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "seat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
    @NamedQuery(name = "Seat.findBySeatId", query = "SELECT s FROM Seat s WHERE s.seatId = :seatId"),
    @NamedQuery(name = "Seat.findBySeatClass", query = "SELECT s FROM Seat s WHERE s.seatClass = :seatClass"),
    @NamedQuery(name = "Seat.findBySeatNumber", query = "SELECT s FROM Seat s WHERE s.seatNumber = :seatNumber"),
    @NamedQuery(name = "Seat.findByOccupied", query = "SELECT s FROM Seat s WHERE s.occupied = :occupied")})
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seat_id")
    private Integer seatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "seat_class")
    private String seatClass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "seat_number")
    private String seatNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "occupied")
    private boolean occupied;
    @JoinColumn(name = "PlaneID", referencedColumnName = "PlaneID")
    @ManyToOne(optional = false)
    private Airplane planeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatId")
    private List<Ticket> ticketList;

    public Seat() {
    }

    public Seat(Integer seatId) {
        this.seatId = seatId;
    }

    public Seat(Integer seatId, String seatClass, String seatNumber, boolean occupied) {
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.occupied = occupied;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Airplane getPlaneID() {
        return planeID;
    }

    public void setPlaneID(Airplane planeID) {
        this.planeID = planeID;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Seat[ seatId=" + seatId + " ]";
    }
    
}
