/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "serviceinventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceinventory.findAll", query = "SELECT s FROM Serviceinventory s"),
    @NamedQuery(name = "Serviceinventory.findByServiceId", query = "SELECT s FROM Serviceinventory s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Serviceinventory.findByItem", query = "SELECT s FROM Serviceinventory s WHERE s.item = :item"),
    @NamedQuery(name = "Serviceinventory.findByCost", query = "SELECT s FROM Serviceinventory s WHERE s.cost = :cost"),
    @NamedQuery(name = "Serviceinventory.findByAvaliablity", query = "SELECT s FROM Serviceinventory s WHERE s.avaliablity = :avaliablity")})
public class Serviceinventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "avaliablity")
    private String avaliablity;

    public Serviceinventory() {
    }

    public Serviceinventory(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Serviceinventory(Integer serviceId, String item, int cost, String avaliablity) {
        this.serviceId = serviceId;
        this.item = item;
        this.cost = cost;
        this.avaliablity = avaliablity;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAvaliablity() {
        return avaliablity;
    }

    public void setAvaliablity(String avaliablity) {
        this.avaliablity = avaliablity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceinventory)) {
            return false;
        }
        Serviceinventory other = (Serviceinventory) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Serviceinventory[ serviceId=" + serviceId + " ]";
    }
    
}
