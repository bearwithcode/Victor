/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "diary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diary.findAll", query = "SELECT d FROM Diary d"),
    @NamedQuery(name = "Diary.findByDiaryId", query = "SELECT d FROM Diary d WHERE d.diaryId = :diaryId"),
    @NamedQuery(name = "Diary.findByDiaryDate", query = "SELECT d FROM Diary d WHERE d.diaryDate = :diaryDate")})
public class Diary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diary_id")
    private Integer diaryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diary_date")
    @Temporal(TemporalType.DATE)
    private Date diaryDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "info")
    private String info;
    @Lob
    @Size(max = 16777215)
    @Column(name = "picy")
    private String picy;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Login username;

    public Diary() {
    }

    public Diary(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Diary(Integer diaryId, Date diaryDate, String info) {
        this.diaryId = diaryId;
        this.diaryDate = diaryDate;
        this.info = info;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Date getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(Date diaryDate) {
        this.diaryDate = diaryDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicy() {
        return picy;
    }

    public void setPicy(String picy) {
        this.picy = picy;
    }

    public Login getUsername() {
        return username;
    }

    public void setUsername(Login username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaryId != null ? diaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diary)) {
            return false;
        }
        Diary other = (Diary) object;
        if ((this.diaryId == null && other.diaryId != null) || (this.diaryId != null && !this.diaryId.equals(other.diaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diary[ diaryId=" + diaryId + " ]";
    }
    
}
