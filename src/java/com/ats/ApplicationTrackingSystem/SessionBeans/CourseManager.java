package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Course;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CourseManager implements CourseManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Course addCourse(String title, Character craditHours, String code) throws WrongParameterException {
        Course course = new Course();
        if (title.isEmpty()) {
            throw new WrongParameterException("Title can not be empty");

        } else {
            course.setTitle(title);

        }
        if (craditHours > 4) {
            throw new WrongParameterException("Cradit Hours can not be empty");

        } else {
            course.setTitle(title);

        }
        if (code.isEmpty()) {
            throw new WrongParameterException("Course Code can not be empty");

        } else {
            course.setTitle(title);

        }
        em.persist(course);
        return course;
    }

    @Override
    public Course getCourseById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Course course = em.find(Course.class, id);

        if (course == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return course;
        }
    }

    @Override
    public void deleteCourse(int id) throws NotFoundException {
        try {
            Course course;
            course = this.getCourseById(id);
            em.remove(course);
            System.out.println("Course with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Course with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Course> getAllCourses() throws NotFoundException {
        Query qry = em.createNamedQuery("Course.findAll");
        List<Course> allCourseList = qry.getResultList();
        if (allCourseList == null || allCourseList.isEmpty()) {
            throw new NotFoundException("No Course is found.");
        }
        return allCourseList;
    }

    @Override
    public Course updateCourse(int id, String title, Character craditHours, String code) throws NotFoundException, WrongParameterException {
        try {
            Course course;
            course = this.getCourseById(id);
            System.out.println("Course with id " + id + " is found successfully");
            if (title.isEmpty()) {
                throw new WrongParameterException("Title can not be empty");

            } else {
                course.setTitle(title);

            }
            if (craditHours > 4) {
                throw new WrongParameterException("Cradit Hours can not be empty");

            } else {
                course.setTitle(title);

            }
            if (code.isEmpty()) {
                throw new WrongParameterException("Course Code can not be empty");

            } else {
                course.setTitle(title);

            }
            em.persist(course);
            return course;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Course with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }

}
