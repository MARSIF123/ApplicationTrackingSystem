package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Short> q1;
    public static volatile SingularAttribute<Feedback, Short> q2;
    public static volatile SingularAttribute<Feedback, Short> q3;
    public static volatile SingularAttribute<Feedback, String> suggestion;
    public static volatile SingularAttribute<Feedback, Integer> rating;
    public static volatile SingularAttribute<Feedback, Integer> id;
    public static volatile SingularAttribute<Feedback, User> userId;

}