/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ats.ApplicationTrackingSystem.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marya
 */
@Entity
@Table(name = "application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findById", query = "SELECT a FROM Application a WHERE a.id = :id"),
    @NamedQuery(name = "Application.findByType", query = "SELECT a FROM Application a WHERE a.type = :type"),
    @NamedQuery(name = "Application.findBySybject", query = "SELECT a FROM Application a WHERE a.sybject = :sybject"),
    @NamedQuery(name = "Application.findByContent", query = "SELECT a FROM Application a WHERE a.content = :content"),
    @NamedQuery(name = "Application.findByHodRemarks", query = "SELECT a FROM Application a WHERE a.hodRemarks = :hodRemarks"),
    @NamedQuery(name = "Application.findBySscRemarks", query = "SELECT a FROM Application a WHERE a.sscRemarks = :sscRemarks"),
    @NamedQuery(name = "Application.findBySemester", query = "SELECT a FROM Application a WHERE a.semester = :semester"),
    @NamedQuery(name = "Application.findByExtraSemester", query = "SELECT a FROM Application a WHERE a.extraSemester = :extraSemester"),
    @NamedQuery(name = "Application.findByProgram", query = "SELECT a FROM Application a WHERE a.program = :program"),
    @NamedQuery(name = "Application.findBySubmissionDate", query = "SELECT a FROM Application a WHERE a.submissionDate = :submissionDate"),
    @NamedQuery(name = "Application.findByCampusName", query = "SELECT a FROM Application a WHERE a.campusName = :campusName"),
    @NamedQuery(name = "Application.findByDegreeTitle", query = "SELECT a FROM Application a WHERE a.degreeTitle = :degreeTitle"),
    @NamedQuery(name = "Application.findByStatus", query = "SELECT a FROM Application a WHERE a.status = :status"),
    @NamedQuery(name = "Application.findByCgpa", query = "SELECT a FROM Application a WHERE a.cgpa = :cgpa"),
    @NamedQuery(name = "Application.findByExtraYear", query = "SELECT a FROM Application a WHERE a.extraYear = :extraYear")})
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "sybject")
    private String sybject;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 100)
    @Column(name = "hodRemarks")
    private String hodRemarks;
    @Size(max = 100)
    @Column(name = "sscRemarks")
    private String sscRemarks;
    @Column(name = "semester")
    private Character semester;
    @Column(name = "extraSemester")
    private Character extraSemester;
    @Column(name = "program")
    private Short program;
    @Column(name = "submissionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Size(max = 100)
    @Column(name = "CampusName")
    private String campusName;
    @Lob
    @Column(name = "transcript")
    private byte[] transcript;
    @Size(max = 100)
    @Column(name = "degreeTitle")
    private String degreeTitle;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cgpa")
    private Float cgpa;
    @Column(name = "extraYear")
    private Integer extraYear;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationId")
    private Collection<CourseHasApplication> courseHasApplicationCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "applicationId")
    private Onestopsolution onestopsolution;

    public Application() {
    }

    public Application(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSybject() {
        return sybject;
    }

    public void setSybject(String sybject) {
        this.sybject = sybject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHodRemarks() {
        return hodRemarks;
    }

    public void setHodRemarks(String hodRemarks) {
        this.hodRemarks = hodRemarks;
    }

    public String getSscRemarks() {
        return sscRemarks;
    }

    public void setSscRemarks(String sscRemarks) {
        this.sscRemarks = sscRemarks;
    }

    public Character getSemester() {
        return semester;
    }

    public void setSemester(Character semester) {
        this.semester = semester;
    }

    public Character getExtraSemester() {
        return extraSemester;
    }

    public void setExtraSemester(Character extraSemester) {
        this.extraSemester = extraSemester;
    }

    public Short getProgram() {
        return program;
    }

    public void setProgram(Short program) {
        this.program = program;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public byte[] getTranscript() {
        return transcript;
    }

    public void setTranscript(byte[] transcript) {
        this.transcript = transcript;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getExtraYear() {
        return extraYear;
    }

    public void setExtraYear(Integer extraYear) {
        this.extraYear = extraYear;
    }

    @XmlTransient
    public Collection<CourseHasApplication> getCourseHasApplicationCollection() {
        return courseHasApplicationCollection;
    }

    public void setCourseHasApplicationCollection(Collection<CourseHasApplication> courseHasApplicationCollection) {
        this.courseHasApplicationCollection = courseHasApplicationCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Onestopsolution getOnestopsolution() {
        return onestopsolution;
    }

    public void setOnestopsolution(Onestopsolution onestopsolution) {
        this.onestopsolution = onestopsolution;
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
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ats.ApplicationTrackingSystem.Entities.Application[ id=" + id + " ]";
    }
    
}
