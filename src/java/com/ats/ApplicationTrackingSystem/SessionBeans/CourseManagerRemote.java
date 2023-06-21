package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Course;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CourseManagerRemote {

    Course addCourse(String title, Character craditHours, String code)throws WrongParameterException;

    Course getCourseById(int id) throws NotFoundException, WrongParameterException;

    void deleteCourse(int id)throws NotFoundException;

    List<Course> getAllCourses() throws NotFoundException;

    Course updateCourse(int id,String title, Character craditHours, String code) throws NotFoundException, WrongParameterException;
    
}
