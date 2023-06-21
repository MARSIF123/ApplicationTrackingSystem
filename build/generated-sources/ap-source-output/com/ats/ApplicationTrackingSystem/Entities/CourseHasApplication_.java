package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.Application;
import com.ats.ApplicationTrackingSystem.Entities.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(CourseHasApplication.class)
public class CourseHasApplication_ { 

    public static volatile SingularAttribute<CourseHasApplication, String> grade;
    public static volatile SingularAttribute<CourseHasApplication, Character> courseHasApplicationcol;
    public static volatile SingularAttribute<CourseHasApplication, Short> courseAddOrDrop;
    public static volatile SingularAttribute<CourseHasApplication, Integer> id;
    public static volatile SingularAttribute<CourseHasApplication, Application> applicationId;
    public static volatile SingularAttribute<CourseHasApplication, Course> courseId;

}