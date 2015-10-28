/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "ecperformances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecperformances.findAll", query = "SELECT e FROM Ecperformances e"),
    @NamedQuery(name = "Ecperformances.findByPid", query = "SELECT e FROM Ecperformances e WHERE e.pid = :pid"),
    @NamedQuery(name = "Ecperformances.findByShowtime", query = "SELECT e FROM Ecperformances e WHERE e.showtime = :showtime"),
    @NamedQuery(name = "Ecperformances.findByShowdate", query = "SELECT e FROM Ecperformances e WHERE e.showdate = :showdate")})
public class Ecperformances implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "showtime")
    private String showtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showdate")
    @Temporal(TemporalType.DATE)
    private Date showdate;
    @JoinColumn(name = "showid", referencedColumnName = "mykey")
    @ManyToOne(optional = false)
    private Ecpresentations showid;

    public Ecperformances() {
    }

    public Ecperformances(Integer pid) {
        this.pid = pid;
    } 
    
    public Ecperformances(Integer pid, String showtime, Date showdate) {
        this.pid = pid;
        this.showtime = showtime;
        this.showdate = showdate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public Date getShowdate() {
        return showdate;
    }

    public void setShowdate(Date showdate) {
        this.showdate = showdate;
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
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecperformances)) {
            return false;
        }
        Ecperformances other = (Ecperformances) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ecperformances[ pid=" + pid + " ]";
    }
    
}
