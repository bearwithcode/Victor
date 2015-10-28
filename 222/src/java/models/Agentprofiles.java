/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "agentprofiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agentprofiles.findAll", query = "SELECT a FROM Agentprofiles a"),
    @NamedQuery(name = "Agentprofiles.findByAgentId", query = "SELECT a FROM Agentprofiles a WHERE a.agentId = :agentId"),
    @NamedQuery(name = "Agentprofiles.findByTravelAgent", query = "SELECT a FROM Agentprofiles a WHERE a.travelAgent = :travelAgent"),
    @NamedQuery(name = "Agentprofiles.findByPhone", query = "SELECT a FROM Agentprofiles a WHERE a.phone = :phone"),
    @NamedQuery(name = "Agentprofiles.findByEmail", query = "SELECT a FROM Agentprofiles a WHERE a.email = :email")})
public class Agentprofiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agent_id")
    private Integer agentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "travel_agent")
    private String travelAgent;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "travelAgent")
    private List<Customer> customerList;

    public Agentprofiles() {
    }

    public Agentprofiles(Integer agentId) {
        this.agentId = agentId;
    }

    public Agentprofiles(Integer agentId, String travelAgent, String phone, String email) {
        this.agentId = agentId;
        this.travelAgent = travelAgent;
        this.phone = phone;
        this.email = email;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(String travelAgent) {
        this.travelAgent = travelAgent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agentprofiles)) {
            return false;
        }
        Agentprofiles other = (Agentprofiles) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Agentprofiles[ agentId=" + agentId + " ]";
    }
    
}
