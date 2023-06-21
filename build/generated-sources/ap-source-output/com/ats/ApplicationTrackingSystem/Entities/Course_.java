package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.CourseHasApplication;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> code;
    public static volatile CollectionAttribute<Course, CourseHasApplication> courseHasApplicationCollection;
    public static volatile SingularAttribute<Course, Character> craditHours;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, String> title;

}