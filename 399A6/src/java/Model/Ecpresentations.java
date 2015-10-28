/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ecpresentations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecpresentations.findAll", query = "SELECT e FROM Ecpresentations e"),
    @NamedQuery(name = "Ecpresentations.findByMykey", query = "SELECT e FROM Ecpresentations e WHERE e.mykey = :mykey"),
    @NamedQuery(name = "Ecpresentations.findByVenue", query = "SELECT e FROM Ecpresentations e WHERE e.venue = :venue"),
    @NamedQuery(name = "Ecpresentations.findByStartseason", query = "SELECT e FROM Ecpresentations e WHERE e.startseason = :startseason"),
    @NamedQuery(name = "Ecpresentations.findByEndseason", query = "SELECT e FROM Ecpresentations e WHERE e.endseason = :endseason"),
    @NamedQuery(name = "Ecpresentations.findByGenre", query = "SELECT e FROM Ecpresentations e WHERE e.genre = :genre"),
    @NamedQuery(name = "Ecpresentations.findByTitle", query = "SELECT e FROM Ecpresentations e WHERE e.title = :title"),
    @NamedQuery(name = "Ecpresentations.findByCompany", query = "SELECT e FROM Ecpresentations e WHERE e.company = :company")})
public class Ecpresentations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mykey")
    private String mykey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "venue")
    private String venue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startseason")
    @Temporal(TemporalType.DATE)
    private Date startseason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endseason")
    @Temporal(TemporalType.DATE)
    private Date endseason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "shortdescription")
    private String shortdescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showid")
    private List<Ecperformances> ecperformancesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showid")
    private List<Ecinfo> ecinfoList;

    public Ecpresentations() {
    }

    public Ecpresentations(String mykey) {
        this.mykey = mykey;
    }

    public Ecpresentations(String mykey, String venue, Date startseason, Date endseason, String genre, String title, String company, String shortdescription) {
        this.mykey = mykey;
        this.venue = venue;
        this.startseason = startseason;
        this.endseason = endseason;
        this.genre = genre;
        this.title = title;
        this.company = company;
        this.shortdescription = shortdescription;
    }

    public String getMykey() {
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getStartseason() {
        return startseason;
    }

    public void setStartseason(Date startseason) {
        this.startseason = startseason;
    }

    public Date getEndseason() {
        return endseason;
    }

    public void setEndseason(Date endseason) {
        this.endseason = endseason;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    @XmlTransient
    public List<Ecperformances> getEcperformancesList() {
        return ecperformancesList;
    }

    public void setEcperformancesList(List<Ecperformances> ecperformancesList) {
        this.ecperformancesList = ecperformancesList;
    }

    @XmlTransient
    public List<Ecinfo> getEcinfoList() {
        return ecinfoList;
    }

    public void setEcinfoList(List<Ecinfo> ecinfoList) {
        this.ecinfoList = ecinfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mykey != null ? mykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecpresentations)) {
            return false;
        }
        Ecpresentations other = (Ecpresentations) object;
        if ((this.mykey == null && other.mykey != null) || (this.mykey != null && !this.mykey.equals(other.mykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ecpresentations[ mykey=" + mykey + " ]";
    }
    
}
