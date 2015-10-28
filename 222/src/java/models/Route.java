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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByRouteID", query = "SELECT r FROM Route r WHERE r.routeID = :routeID"),
    @NamedQuery(name = "Route.findByCodeShare", query = "SELECT r FROM Route r WHERE r.codeShare = :codeShare"),
    @NamedQuery(name = "Route.findByStops", query = "SELECT r FROM Route r WHERE r.stops = :stops"),
    @NamedQuery(name = "Route.findByInternationalFlight", query = "SELECT r FROM Route r WHERE r.internationalFlight = :internationalFlight")})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routeID")
    private Integer routeID;
    @Size(max = 1)
    @Column(name = "codeShare")
    private String codeShare;
    @Column(name = "stops")
    private Integer stops;
    @Column(name = "InternationalFlight")
    private Boolean internationalFlight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeID")
    private List<Schedule> scheduleList;
    @JoinColumn(name = "destinationAirport", referencedColumnName = "IATA")
    @ManyToOne(optional = false)
    private Airport destinationAirport;
    @JoinColumn(name = "sourceAirport", referencedColumnName = "IATA")
    @ManyToOne(optional = false)
    private Airport sourceAirport;

    public Route() {
    }

    public Route(Integer routeID) {
        this.routeID = routeID;
    }

    public Integer getRouteID() {
        return routeID;
    }

    public void setRouteID(Integer routeID) {
        this.routeID = routeID;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Boolean getInternationalFlight() {
        return internationalFlight;
    }

    public void setInternationalFlight(Boolean internationalFlight) {
        this.internationalFlight = internationalFlight;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeID != null ? routeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeID == null && other.routeID != null) || (this.routeID != null && !this.routeID.equals(other.routeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Route[ routeID=" + routeID + " ]";
    }
    
}
