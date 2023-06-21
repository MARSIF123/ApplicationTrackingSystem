package com.ats.ApplicationTrackingSystem.Entities;

import com.ats.ApplicationTrackingSystem.Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-21T15:45:54")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Integer> senderId;
    public static volatile SingularAttribute<Notification, Date> timeSent;
    public static volatile SingularAttribute<Notification, String> link;
    public static volatile SingularAttribute<Notification, Short> isRead;
    public static volatile SingularAttribute<Notification, Integer> id;
    public static volatile SingularAttribute<Notification, String> message;
    public static volatile SingularAttribute<Notification, String> type;
    public static volatile SingularAttribute<Notification, User> userId;

}