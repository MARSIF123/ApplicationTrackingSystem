package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile CollectionAttribute<Department, User> userCollection;
    public static volatile SingularAttribute<Department, Integer> id;
    public static volatile SingularAttribute<Department, String> title;

}