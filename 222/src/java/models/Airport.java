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
import javax.persistence.Id;
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
@Table(name = "airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a"),
    @NamedQuery(name = "Airport.findByAirportID", query = "SELECT a FROM Airport a WHERE a.airportID = :airportID"),
    @NamedQuery(name = "Airport.findByName", query = "SELECT a FROM Airport a WHERE a.name = :name"),
    @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city"),
    @NamedQuery(name = "Airport.findByCountry", query = "SELECT a FROM Airport a WHERE a.country = :country"),
    @NamedQuery(name = "Airport.findByIata", query = "SELECT a FROM Airport a WHERE a.iata = :iata"),
    @NamedQuery(name = "Airport.findByLatitude", query = "SELECT a FROM Airport a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "Airport.findByLongitude", query = "SELECT a FROM Airport a WHERE a.longitude = :longitude"),
    @NamedQuery(name = "Airport.findByAltitude", query = "SELECT a FROM Airport a WHERE a.altitude = :altitude"),
    @NamedQuery(name = "Airport.findByDst", query = "SELECT a FROM Airport a WHERE a.dst = :dst"),
    @NamedQuery(name = "Airport.findByTimeZone", query = "SELECT a FROM Airport a WHERE a.timeZone = :timeZone")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "airportID")
    private int airportID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "country")
    private String country;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "IATA")
    private String iata;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altitude")
    private int altitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DST")
    private String dst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "timeZone")
    private String timeZone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "airportITIA")
    private List<Fleet> fleetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationAirport")
    private List<Route> routeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceAirport")
    private List<Route> routeList1;

    public Airport() {
    }

    public Airport(String iata) {
        this.iata = iata;
    }

    public Airport(String iata, int airportID, String name, String city, String country, double latitude, double longitude, int altitude, String dst, String timeZone) {
        this.iata = iata;
        this.airportID = airportID;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.dst = dst;
        this.timeZone = timeZone;
    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @XmlTransient
    public List<Fleet> getFleetList() {
        return fleetList;
    }

    public void setFleetList(List<Fleet> fleetList) {
        this.fleetList = fleetList;
    }

    @XmlTransient
    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    @XmlTransient
    public List<Route> getRouteList1() {
        return routeList1;
    }

    public void setRouteList1(List<Route> routeList1) {
        this.routeList1 = routeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iata != null ? iata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.iata == null && other.iata != null) || (this.iata != null && !this.iata.equals(other.iata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Airport[ iata=" + iata + " ]";
    }
    
}
