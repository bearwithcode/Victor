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
@Table(name = "fleet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fleet.findAll", query = "SELECT f FROM Fleet f"),
    @NamedQuery(name = "Fleet.findByFleetID", query = "SELECT f FROM Fleet f WHERE f.fleetID = :fleetID"),
    @NamedQuery(name = "Fleet.findByInService", query = "SELECT f FROM Fleet f WHERE f.inService = :inService")})
public class Fleet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fleetID")
    private Integer fleetID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inService")
    private int inService;
    @JoinColumn(name = "AirportITIA", referencedColumnName = "IATA")
    @ManyToOne(optional = false)
    private Airport airportITIA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onefleet")
    private List<Airplane> airplaneList;

    public Fleet() {
    }

    public Fleet(Integer fleetID) {
        this.fleetID = fleetID;
    }

    public Fleet(Integer fleetID, int inService) {
        this.fleetID = fleetID;
        this.inService = inService;
    }

    public Integer getFleetID() {
        return fleetID;
    }

    public void setFleetID(Integer fleetID) {
        this.fleetID = fleetID;
    }

    public int getInService() {
        return inService;
    }

    public void setInService(int inService) {
        this.inService = inService;
    }

    public Airport getAirportITIA() {
        return airportITIA;
    }

    public void setAirportITIA(Airport airportITIA) {
        this.airportITIA = airportITIA;
    }

    @XmlTransient
    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fleetID != null ? fleetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fleet)) {
            return false;
        }
        Fleet other = (Fleet) object;
        if ((this.fleetID == null && other.fleetID != null) || (this.fleetID != null && !this.fleetID.equals(other.fleetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Fleet[ fleetID=" + fleetID + " ]";
    }
    
}
