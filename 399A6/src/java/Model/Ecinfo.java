/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "ecinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecinfo.findAll", query = "SELECT e FROM Ecinfo e"),
    @NamedQuery(name = "Ecinfo.findByIdECInfo", query = "SELECT e FROM Ecinfo e WHERE e.idECInfo = :idECInfo")})
public class Ecinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idECInfo")
    private Integer idECInfo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "details")
    private String details;
    @Lob
    @Size(max = 16777215)
    @Column(name = "picy")
    private String picy;
    @JoinColumn(name = "showid", referencedColumnName = "mykey")
    @ManyToOne(optional = false)
    private Ecpresentations showid;

    public Ecinfo() {
    }

    public Ecinfo(Integer idECInfo) {
        this.idECInfo = idECInfo;
    }

    public Ecinfo(Integer idECInfo, String details) {
        this.idECInfo = idECInfo;
        this.details = details;
    }

    public Integer getIdECInfo() {
        return idECInfo;
    }

    public void setIdECInfo(Integer idECInfo) {
        this.idECInfo = idECInfo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPicy() {
        return picy;
    }

    public void setPicy(String picy) {
        this.picy = picy;
    }

    public Ecpresentations getShowid() {
        return showid;
    }

    public void setShowid(Ecpresentations showid) {
        this.showid = showid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idECInfo != null ? idECInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecinfo)) {
            return false;
        }
        Ecinfo other = (Ecinfo) object;
        if ((this.idECInfo == null && other.idECInfo != null) || (this.idECInfo != null && !this.idECInfo.equals(other.idECInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ecinfo[ idECInfo=" + idECInfo + " ]";
    }
    
}
