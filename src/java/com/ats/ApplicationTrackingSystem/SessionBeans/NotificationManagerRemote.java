package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Notification;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface NotificationManagerRemote {

    Notification addNotification(int senderId, String message, Date timeSent, String link, String type, Short isRead,int userId) throws WrongParameterException;

    Notification getNotificationById(int id) throws NotFoundException, WrongParameterException;

    void deleteNotification(int id) throws NotFoundException;

    List<Notification> getAllNotifications() throws NotFoundException;

    Notification updateNotification(int id,int senderId, String message, Date timeSent, String link, String type, Short isRead,int userId) throws NotFoundException, WrongParameterException;
}
