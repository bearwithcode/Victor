/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleID", query = "SELECT s FROM Schedule s WHERE s.scheduleID = :scheduleID"),
    @NamedQuery(name = "Schedule.findByDepartDate", query = "SELECT s FROM Schedule s WHERE s.departDate = :departDate"),
    @NamedQuery(name = "Schedule.findByArriveDate", query = "SELECT s FROM Schedule s WHERE s.arriveDate = :arriveDate"),
    @NamedQuery(name = "Schedule.findByDepartTime", query = "SELECT s FROM Schedule s WHERE s.departTime = :departTime"),
    @NamedQuery(name = "Schedule.findByArriveTime", query = "SELECT s FROM Schedule s WHERE s.arriveTime = :arriveTime")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduleID")
    private Integer scheduleID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departDate")
    @Temporal(TemporalType.DATE)
    private Date departDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arriveDate")
    @Temporal(TemporalType.DATE)
    private Date arriveDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "departTime")
    private String departTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "arriveTime")
    private String arriveTime;
    @JoinColumn(name = "planeID", referencedColumnName = "PlaneID")
    @ManyToOne(optional = false)
    private Airplane planeID;
    @JoinColumn(name = "routeID", referencedColumnName = "routeID")
    @ManyToOne(optional = false)
    private Route routeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleID")
    private List<Ticket> ticketList;

    public Schedule() {
    }

    public Schedule(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Schedule(Integer scheduleID, Date departDate, Date arriveDate, String departTime, String arriveTime) {
        this.scheduleID = scheduleID;
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.departTime = departTime;
        this.arriveTime = arriveTime;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Airplane getPlaneID() {
        return planeID;
    }

    public void setPlaneID(Airplane planeID) {
        this.planeID = planeID;
    }

    public Route getRouteID() {
        return routeID;
    }

    public void setRouteID(Route routeID) {
        this.routeID = routeID;
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
        hash += (scheduleID != null ? scheduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleID == null && other.scheduleID != null) || (this.scheduleID != null && !this.scheduleID.equals(other.scheduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Schedule[ scheduleID=" + scheduleID + " ]";
    }
    
}
