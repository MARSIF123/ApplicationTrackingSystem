package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Notification;
import com.ats.ApplicationTrackingSystem.Entities.User;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class NotificationManager implements NotificationManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Notification addNotification(int senderId, String message, Date timeSent, String link, String type, Short isRead, int userId) throws WrongParameterException {
        Notification notification = new Notification();
        if (senderId < 1) {
            throw new WrongParameterException("Sender Id  can not be empty");

        } else {
            notification.setSenderId(senderId);

        }
        if (message.isEmpty()) {
            throw new WrongParameterException("Message can not be empty");

        } else {
            notification.setMessage(message);

        }
        if (timeSent == null) {
            Instant instant = Instant.now();
            timeSent = Date.from(instant);
            System.out.println("Date = " + timeSent.toString());
//            throw new WrongParameterException("Notification Code can not be empty");

        }
        notification.setTimeSent(timeSent);
        if (link.isEmpty()) {
            throw new WrongParameterException("Link can not be empty");

        } else {
            notification.setLink(link);

        }
        if (type.isEmpty()) {
            throw new WrongParameterException("Type can not be empty");

        } else {
            notification.setType(type);
        }
        if (isRead < 0) {
            throw new WrongParameterException("IsRead can not be empty");

        } else {
            notification.setIsRead(isRead);
        }
       User u = em.find(User.class, userId);
       notification.setUserId(u);
        

        em.persist(notification);
        return notification;
    }

    @Override
    public Notification getNotificationById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Notification notification = em.find(Notification.class, id);

        if (notification == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return notification;
        }
    }

    @Override
    public void deleteNotification(int id) throws NotFoundException {
        try {
            Notification notification;
            notification = this.getNotificationById(id);
            em.remove(notification);
            System.out.println("Notification with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Notification with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Notification> getAllNotifications() throws NotFoundException {
        Query qry = em.createNamedQuery("Notification.findAll");
        List<Notification> allNotificationList = qry.getResultList();
        if (allNotificationList == null || allNotificationList.isEmpty()) {
            throw new NotFoundException("No Notification is found.");
        }
        return allNotificationList;
    }

    @Override
    public Notification updateNotification(int id, int senderId, String message, Date timeSent, String link, String type, Short isRead, int userId) throws NotFoundException, WrongParameterException {
        try {
            Notification notification;
            notification = this.getNotificationById(id);
            System.out.println("Notification with id " + id + " is found successfully");
            if (senderId < 1) {
                throw new WrongParameterException("Sender Id  can not be empty");

            } else {
                notification.setSenderId(senderId);

            }
            if (message.isEmpty()) {
                throw new WrongParameterException("Message can not be empty");

            } else {
                notification.setMessage(message);

            }
            if (timeSent == null) {
                Instant instant = Instant.now();
                timeSent = Date.from(instant);
                System.out.println("Date = " + timeSent.toString());
//            throw new WrongParameterException("Notification Code can not be empty");

            }
            notification.setTimeSent(timeSent);
            if (link.isEmpty()) {
                throw new WrongParameterException("Link can not be empty");

            } else {
                notification.setLink(link);

            }
            if (type.isEmpty()) {
                throw new WrongParameterException("Type can not be empty");

            } else {
                notification.setType(type);
            }
            if (isRead < 0) {
                throw new WrongParameterException("IsRead can not be empty");

            } else {
                notification.setIsRead(isRead);
            }
            

            em.persist(notification);
            return notification;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Notification with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }
}
