/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ats.ApplicationTrackingSystem.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marya
 */
@Entity
@Table(name = "course_has_application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseHasApplication.findAll", query = "SELECT c FROM CourseHasApplication c"),
    @NamedQuery(name = "CourseHasApplication.findById", query = "SELECT c FROM CourseHasApplication c WHERE c.id = :id"),
    @NamedQuery(name = "CourseHasApplication.findByCourseAddOrDrop", query = "SELECT c FROM CourseHasApplication c WHERE c.courseAddOrDrop = :courseAddOrDrop"),
    @NamedQuery(name = "CourseHasApplication.findByGrade", query = "SELECT c FROM CourseHasApplication c WHERE c.grade = :grade"),
    @NamedQuery(name = "CourseHasApplication.findByCourseHasApplicationcol", query = "SELECT c FROM CourseHasApplication c WHERE c.courseHasApplicationcol = :courseHasApplicationcol")})
public class CourseHasApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "courseAddOrDrop")
    private Short courseAddOrDrop;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Column(name = "course_has_applicationcol")
    private Character courseHasApplicationcol;
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Application applicationId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseHasApplication() {
    }

    public CourseHasApplication(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCourseAddOrDrop() {
        return courseAddOrDrop;
    }

    public void setCourseAddOrDrop(Short courseAddOrDrop) {
        this.courseAddOrDrop = courseAddOrDrop;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Character getCourseHasApplicationcol() {
        return courseHasApplicationcol;
    }

    public void setCourseHasApplicationcol(Character courseHasApplicationcol) {
        this.courseHasApplicationcol = courseHasApplicationcol;
    }

    public Application getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Application applicationId) {
        this.applicationId = applicationId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof CourseHasApplication)) {
            return false;
        }
        CourseHasApplication other = (CourseHasApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ats.ApplicationTrackingSystem.Entities.CourseHasApplication[ id=" + id + " ]";
    }
    
}
