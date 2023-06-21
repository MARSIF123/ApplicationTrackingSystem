package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.Application;
import com.ats.ApplicationTrackingSystem.Entities.Department;
import com.ats.ApplicationTrackingSystem.Entities.Feedback;
import com.ats.ApplicationTrackingSystem.Entities.Login;
import com.ats.ApplicationTrackingSystem.Entities.Notification;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> regNo;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> fatherName;
    public static volatile CollectionAttribute<User, Notification> notificationCollection;
    public static volatile SingularAttribute<User, Short> gender;
    public static volatile SingularAttribute<User, byte[]> profile;
    public static volatile CollectionAttribute<User, Feedback> feedbackCollection;
    public static volatile SingularAttribute<User, Date> dateOfBirth;
    public static volatile SingularAttribute<User, Login> login;
    public static volatile SingularAttribute<User, String> phoneNo;
    public static volatile SingularAttribute<User, String> personalEmail;
    public static volatile CollectionAttribute<User, Department> departmentCollection;
    public static volatile CollectionAttribute<User, Application> applicationCollection;
    public static volatile SingularAttribute<User, String> uogEmail;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userType;

}