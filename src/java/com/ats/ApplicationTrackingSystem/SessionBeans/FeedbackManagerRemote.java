package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Feedback;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FeedbackManagerRemote {

    Feedback addFeedback(String suggestion, int rating, short q1, short q2, short q3, int userId) throws WrongParameterException;

    Feedback getFeedbackById(int id) throws NotFoundException, WrongParameterException;

    void deleteFeedback(int id) throws NotFoundException;

    List<Feedback> getAllFeedbacks() throws NotFoundException;

    Feedback updateFeedback(int id, String suggestion, int rating, short q1, short q2, short q3, int userId) throws NotFoundException, WrongParameterException;
}
