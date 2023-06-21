package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Feedback;
import com.ats.ApplicationTrackingSystem.Entities.User;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FeedbackManager implements FeedbackManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Feedback addFeedback(String suggestion, int rating, short q1, short q2, short q3, int userId) throws WrongParameterException {
        Feedback feedback = new Feedback();
        if (suggestion.isEmpty()) {
            throw new WrongParameterException("Title can not be empty");

        } else {
            feedback.setSuggestion(suggestion);

        }
        if (rating > 5 || rating < 1) {
            throw new WrongParameterException("Rating can not be empty");

        } else {
            feedback.setRating(rating);

        }
        if (q1 < 0) {
            throw new WrongParameterException("Feedback Code can not be empty");

        } else {
            feedback.setQ1(q1);

        }
        if (q2 < 0) {
            throw new WrongParameterException("Feedback Code can not be empty");

        } else {
            feedback.setQ2(q2);

        }
        if (q3 < 0) {
            throw new WrongParameterException("Feedback Code can not be empty");

        } else {
            feedback.setQ3(q3);

        }
       User u = em.find(User.class, userId);
       feedback.setUserId(u);
        em.persist(feedback);
        return feedback;
    }

    @Override
    public Feedback getFeedbackById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Feedback feedback = em.find(Feedback.class, id);

        if (feedback == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return feedback;
        }
    }

    @Override
    public void deleteFeedback(int id) throws NotFoundException {
        try {
            Feedback feedback;
            feedback = this.getFeedbackById(id);
            em.remove(feedback);
            System.out.println("Feedback with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Feedback with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Feedback> getAllFeedbacks() throws NotFoundException {
        Query qry = em.createNamedQuery("Feedback.findAll");
        List<Feedback> allFeedbackList = qry.getResultList();
        if (allFeedbackList == null || allFeedbackList.isEmpty()) {
            throw new NotFoundException("No Feedback is found.");
        }
        return allFeedbackList;
    }

    @Override
    public Feedback updateFeedback(int id, String suggestion, int rating, short q1, short q2, short q3, int userId) throws NotFoundException, WrongParameterException {
        try {
            Feedback feedback;
            feedback = this.getFeedbackById(id);
            System.out.println("Feedback with id " + id + " is found successfully");
            if (suggestion.isEmpty()) {
                throw new WrongParameterException("Title can not be empty");

            } else {
                feedback.setSuggestion(suggestion);

            }
            if (rating > 5 || rating < 1) {
                throw new WrongParameterException("Rating can not be empty");

            } else {
                feedback.setRating(rating);

            }
            if (q1 < 0) {
                throw new WrongParameterException("Feedback Code can not be empty");

            } else {
                feedback.setQ1(q1);

            }
            if (q2 < 0) {
                throw new WrongParameterException("Feedback Code can not be empty");

            } else {
                feedback.setQ2(q2);

            }
            if (q3 < 0) {
                throw new WrongParameterException("Feedback Code can not be empty");
            } else {
                feedback.setQ3(q3);

            }
            em.persist(feedback);
            return feedback;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Feedback with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }
}
