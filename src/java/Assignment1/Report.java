/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author haofangliu
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByReportid", query = "SELECT r FROM Report r WHERE r.reportid = :reportid")
    , @NamedQuery(name = "Report.findByDate", query = "SELECT r FROM Report r WHERE r.date = :date")
    , @NamedQuery(name = "Report.findByUserid", query = "SELECT r FROM Report r WHERE r.userid.userid = :userid")
    , @NamedQuery(name = "Report.findByTotalcalorieconsumed", query = "SELECT r FROM Report r WHERE r.totalcalorieconsumed = :totalcalorieconsumed")
    , @NamedQuery(name = "Report.findByTotalcalorieburned", query = "SELECT r FROM Report r WHERE r.totalcalorieburned = :totalcalorieburned")
    , @NamedQuery(name = "Report.findByTotalsteptaken", query = "SELECT r FROM Report r WHERE r.totalsteptaken = :totalsteptaken")
    , @NamedQuery(name = "Report.findBySetcaloriegoalthatday", query = "SELECT r FROM Report r WHERE r.setcaloriegoalthatday = :setcaloriegoalthatday")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORTID")
    private Integer reportid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALCALORIECONSUMED")
    private int totalcalorieconsumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALCALORIEBURNED")
    private int totalcalorieburned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALSTEPTAKEN")
    private int totalsteptaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SETCALORIEGOALTHATDAY")
    private int setcaloriegoalthatday;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Userapp userid;

    public Report() {
    }

    public Report(Integer reportid) {
        this.reportid = reportid;
    }

    public Report(Integer reportid, Date date, int totalcalorieconsumed, int totalcalorieburned, int totalsteptaken, int setcaloriegoalthatday) {
        this.reportid = reportid;
        this.date = date;
        this.totalcalorieconsumed = totalcalorieconsumed;
        this.totalcalorieburned = totalcalorieburned;
        this.totalsteptaken = totalsteptaken;
        this.setcaloriegoalthatday = setcaloriegoalthatday;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalcalorieconsumed() {
        return totalcalorieconsumed;
    }

    public void setTotalcalorieconsumed(int totalcalorieconsumed) {
        this.totalcalorieconsumed = totalcalorieconsumed;
    }

    public int getTotalcalorieburned() {
        return totalcalorieburned;
    }

    public void setTotalcalorieburned(int totalcalorieburned) {
        this.totalcalorieburned = totalcalorieburned;
    }

    public int getTotalsteptaken() {
        return totalsteptaken;
    }

    public void setTotalsteptaken(int totalsteptaken) {
        this.totalsteptaken = totalsteptaken;
    }

    public int getSetcaloriegoalthatday() {
        return setcaloriegoalthatday;
    }

    public void setSetcaloriegoalthatday(int setcaloriegoalthatday) {
        this.setcaloriegoalthatday = setcaloriegoalthatday;
    }

    public Userapp getUserid() {
        return userid;
    }

    public void setUserid(Userapp userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportid != null ? reportid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportid == null && other.reportid != null) || (this.reportid != null && !this.reportid.equals(other.reportid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Assignment1.Report[ reportid=" + reportid + " ]";
    }
    
}
