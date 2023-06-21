package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.CourseHasApplication;
import com.ats.ApplicationTrackingSystem.Entities.Onestopsolution;
import com.ats.ApplicationTrackingSystem.Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(Application.class)
public class Application_ { 

    public static volatile SingularAttribute<Application, Integer> extraYear;
    public static volatile CollectionAttribute<Application, CourseHasApplication> courseHasApplicationCollection;
    public static volatile SingularAttribute<Application, Onestopsolution> onestopsolution;
    public static volatile SingularAttribute<Application, String> campusName;
    public static volatile SingularAttribute<Application, String> sscRemarks;
    public static volatile SingularAttribute<Application, Date> submissionDate;
    public static volatile SingularAttribute<Application, String> hodRemarks;
    public static volatile SingularAttribute<Application, Short> program;
    public static volatile SingularAttribute<Application, String> type;
    public static volatile SingularAttribute<Application, User> userId;
    public static volatile SingularAttribute<Application, String> content;
    public static volatile SingularAttribute<Application, String> degreeTitle;
    public static volatile SingularAttribute<Application, byte[]> transcript;
    public static volatile SingularAttribute<Application, String> sybject;
    public static volatile SingularAttribute<Application, Character> semester;
    public static volatile SingularAttribute<Application, Integer> id;
    public static volatile SingularAttribute<Application, Float> cgpa;
    public static volatile SingularAttribute<Application, Character> extraSemester;
    public static volatile SingularAttribute<Application, String> status;

}