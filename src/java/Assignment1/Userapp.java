/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author haofangliu
 */
@Entity
@Table(name = "USERAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userapp.findAll", query = "SELECT u FROM Userapp u")
    , @NamedQuery(name = "Userapp.findByUserid", query = "SELECT u FROM Userapp u WHERE u.userid = :userid")
    , @NamedQuery(name = "Userapp.findByFirstname", query = "SELECT u FROM Userapp u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Userapp.findBySurname", query = "SELECT u FROM Userapp u WHERE u.surname = :surname")
    , @NamedQuery(name = "Userapp.findByEmail", query = "SELECT u FROM Userapp u WHERE u.email = :email")
    , @NamedQuery(name = "Userapp.findByDob", query = "SELECT u FROM Userapp u WHERE u.dob = :dob")
    , @NamedQuery(name = "Userapp.findByHeight", query = "SELECT u FROM Userapp u WHERE u.height = :height")
    , @NamedQuery(name = "Userapp.findByWeight", query = "SELECT u FROM Userapp u WHERE u.weight = :weight")
    , @NamedQuery(name = "Userapp.findByGender", query = "SELECT u FROM Userapp u WHERE u.gender = :gender")
    , @NamedQuery(name = "Userapp.findByAddress", query = "SELECT u FROM Userapp u WHERE u.address = :address")
    , @NamedQuery(name = "Userapp.findByPostcode", query = "SELECT u FROM Userapp u WHERE u.postcode = :postcode")
    , @NamedQuery(name = "Userapp.findByLevelofactivityonetofive", query = "SELECT u FROM Userapp u WHERE u.levelofactivityonetofive = :levelofactivityonetofive")
    , @NamedQuery(name = "Userapp.findBySteppermile", query = "SELECT u FROM Userapp u WHERE u.steppermile = :steppermile")})
public class Userapp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 10)
    @Column(name = "SURNAME")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEIGHT")
    private int height;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 500)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "POSTCODE")
    private Short postcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEVELOFACTIVITYONETOFIVE")
    private short levelofactivityonetofive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPPERMILE")
    private int steppermile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Credential> credentialCollection;
    //private Credential credential;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Report> reportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Consumption> consumptionCollection;

    public Userapp() {
    }

    public Userapp(Integer userid) {
        this.userid = userid;
    }

    public Userapp(Integer userid, String firstname, String email, int height, BigDecimal weight, String gender, short levelofactivityonetofive, int steppermile) {
        this.userid = userid;
        this.firstname = firstname;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.levelofactivityonetofive = levelofactivityonetofive;
        this.steppermile = steppermile;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getPostcode() {
        return postcode;
    }

    public void setPostcode(Short postcode) {
        this.postcode = postcode;
    }

    public short getLevelofactivityonetofive() {
        return levelofactivityonetofive;
    }

    public void setLevelofactivityonetofive(short levelofactivityonetofive) {
        this.levelofactivityonetofive = levelofactivityonetofive;
    }

    public int getSteppermile() {
        return steppermile;
    }

    public void setSteppermile(int steppermile) {
        this.steppermile = steppermile;
    }
    
    @XmlTransient
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @XmlTransient
    public Collection<Consumption> getConsumptionCollection() {
        return consumptionCollection;
    }

    public void setConsumptionCollection(Collection<Consumption> consumptionCollection) {
        this.consumptionCollection = consumptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userapp)) {
            return false;
        }
        Userapp other = (Userapp) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Assignment1.Userapp[ userid=" + userid + " ]";
    }
    
}
