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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "airplane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airplane.findAll", query = "SELECT a FROM Airplane a"),
    @NamedQuery(name = "Airplane.findByPlaneID", query = "SELECT a FROM Airplane a WHERE a.planeID = :planeID"),
    @NamedQuery(name = "Airplane.findByFirstClass", query = "SELECT a FROM Airplane a WHERE a.firstClass = :firstClass"),
    @NamedQuery(name = "Airplane.findByBusinessClass", query = "SELECT a FROM Airplane a WHERE a.businessClass = :businessClass"),
    @NamedQuery(name = "Airplane.findByPremiumClass", query = "SELECT a FROM Airplane a WHERE a.premiumClass = :premiumClass"),
    @NamedQuery(name = "Airplane.findByEconomyClass", query = "SELECT a FROM Airplane a WHERE a.economyClass = :economyClass"),
    @NamedQuery(name = "Airplane.findByTotal", query = "SELECT a FROM Airplane a WHERE a.total = :total")})
public class Airplane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlaneID")
    private Integer planeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "firstClass")
    private int firstClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "businessClass")
    private int businessClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "premiumClass")
    private int premiumClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "economyClass")
    private int economyClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planeID")
    private List<Schedule> scheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planeID")
    private List<Seat> seatList;
    @JoinColumn(name = "onefleet", referencedColumnName = "fleetID")
    @ManyToOne(optional = false)
    private Fleet onefleet;

    public Airplane() {
    }

    public Airplane(Integer planeID) {
        this.planeID = planeID;
    }

    public Airplane(Integer planeID, int firstClass, int businessClass, int premiumClass, int economyClass, int total) {
        this.planeID = planeID;
        this.firstClass = firstClass;
        this.businessClass = businessClass;
        this.premiumClass = premiumClass;
        this.economyClass = economyClass;
        this.total = total;
    }

    public Integer getPlaneID() {
        return planeID;
    }

    public void setPlaneID(Integer planeID) {
        this.planeID = planeID;
    }

    public int getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }

    public int getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(int businessClass) {
        this.businessClass = businessClass;
    }

    public int getPremiumClass() {
        return premiumClass;
    }

    public void setPremiumClass(int premiumClass) {
        this.premiumClass = premiumClass;
    }

    public int getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @XmlTransient
    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Fleet getOnefleet() {
        return onefleet;
    }

    public void setOnefleet(Fleet onefleet) {
        this.onefleet = onefleet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planeID != null ? planeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airplane)) {
            return false;
        }
        Airplane other = (Airplane) object;
        if ((this.planeID == null && other.planeID != null) || (this.planeID != null && !this.planeID.equals(other.planeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Airplane[ planeID=" + planeID + " ]";
    }
    
}
