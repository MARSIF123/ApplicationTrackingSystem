/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ats.ApplicationTrackingSystem.Entities;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marya
 */
@Entity
@Table(name = "onestopsolution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onestopsolution.findAll", query = "SELECT o FROM Onestopsolution o"),
    @NamedQuery(name = "Onestopsolution.findById", query = "SELECT o FROM Onestopsolution o WHERE o.id = :id"),
    @NamedQuery(name = "Onestopsolution.findByBloodGroup", query = "SELECT o FROM Onestopsolution o WHERE o.bloodGroup = :bloodGroup"),
    @NamedQuery(name = "Onestopsolution.findByDegreeProgram", query = "SELECT o FROM Onestopsolution o WHERE o.degreeProgram = :degreeProgram"),
    @NamedQuery(name = "Onestopsolution.findByMaritalStatus", query = "SELECT o FROM Onestopsolution o WHERE o.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Onestopsolution.findBySession", query = "SELECT o FROM Onestopsolution o WHERE o.session = :session"),
    @NamedQuery(name = "Onestopsolution.findByReligion", query = "SELECT o FROM Onestopsolution o WHERE o.religion = :religion"),
    @NamedQuery(name = "Onestopsolution.findByCnic", query = "SELECT o FROM Onestopsolution o WHERE o.cnic = :cnic"),
    @NamedQuery(name = "Onestopsolution.findByAddress", query = "SELECT o FROM Onestopsolution o WHERE o.address = :address"),
    @NamedQuery(name = "Onestopsolution.findByPtcl", query = "SELECT o FROM Onestopsolution o WHERE o.ptcl = :ptcl"),
    @NamedQuery(name = "Onestopsolution.findByFaculty", query = "SELECT o FROM Onestopsolution o WHERE o.faculty = :faculty"),
    @NamedQuery(name = "Onestopsolution.findByChallanDate", query = "SELECT o FROM Onestopsolution o WHERE o.challanDate = :challanDate"),
    @NamedQuery(name = "Onestopsolution.findByChallanNumber", query = "SELECT o FROM Onestopsolution o WHERE o.challanNumber = :challanNumber"),
    @NamedQuery(name = "Onestopsolution.findByDegreeStstus", query = "SELECT o FROM Onestopsolution o WHERE o.degreeStstus = :degreeStstus")})
public class Onestopsolution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bloodGroup")
    private Character bloodGroup;
    @Column(name = "degreeProgram")
    private Character degreeProgram;
    @Column(name = "maritalStatus")
    private Short maritalStatus;
    @Column(name = "session")
    private Integer session;
    @Size(max = 45)
    @Column(name = "religion")
    private String religion;
    @Size(max = 13)
    @Column(name = "cnic")
    private String cnic;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 10)
    @Column(name = "ptcl")
    private String ptcl;
    @Size(max = 100)
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "challanDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date challanDate;
    @Size(max = 45)
    @Column(name = "challanNumber")
    private String challanNumber;
    @Lob
    @Column(name = "challan")
    private byte[] challan;
    @Column(name = "degreeStstus")
    private Short degreeStstus;
    @Lob
    @Column(name = "transcripts")
    private byte[] transcripts;
    @Lob
    @Column(name = "cnicCopy")
    private byte[] cnicCopy;
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Application applicationId;

    public Onestopsolution() {
    }

    public Onestopsolution(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Character bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Character getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(Character degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    public Short getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Short maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPtcl() {
        return ptcl;
    }

    public void setPtcl(String ptcl) {
        this.ptcl = ptcl;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getChallanDate() {
        return challanDate;
    }

    public void setChallanDate(Date challanDate) {
        this.challanDate = challanDate;
    }

    public String getChallanNumber() {
        return challanNumber;
    }

    public void setChallanNumber(String challanNumber) {
        this.challanNumber = challanNumber;
    }

    public byte[] getChallan() {
        return challan;
    }

    public void setChallan(byte[] challan) {
        this.challan = challan;
    }

    public Short getDegreeStstus() {
        return degreeStstus;
    }

    public void setDegreeStstus(Short degreeStstus) {
        this.degreeStstus = degreeStstus;
    }

    public byte[] getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(byte[] transcripts) {
        this.transcripts = transcripts;
    }

    public byte[] getCnicCopy() {
        return cnicCopy;
    }

    public void setCnicCopy(byte[] cnicCopy) {
        this.cnicCopy = cnicCopy;
    }

    public Application getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Application applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onestopsolution)) {
            return false;
        }
        Onestopsolution other = (Onestopsolution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ats.ApplicationTrackingSystem.Entities.Onestopsolution[ id=" + id + " ]";
    }
    
}
