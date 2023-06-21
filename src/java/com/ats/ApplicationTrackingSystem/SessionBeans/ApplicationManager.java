package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Application;
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
public class ApplicationManager implements ApplicationManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Application AddApplication(String type, String subject, String content, String hodRemarks, String sscRemarks, String status, Date submissionDate, Character semester, Character extraSemester, int extraYear, String degreeTitle, byte[] transcript, float cgpa, String campusName, int userId) throws WrongParameterException {
        Application app = new Application();
        if (type.isEmpty()) {
            throw new WrongParameterException("An application should must have a type.");
        } else {
            app.setType(type);
        }
        if (subject.isEmpty()) {
            throw new WrongParameterException("An application should must have a subject.");
        } else {
            app.setSybject(subject);
        }
        if (content.isEmpty()) {
            throw new WrongParameterException("An application should must have content.");
        } else {
            app.setContent(content);
        }
        if (hodRemarks.isEmpty()) {
            // throw new WrongParameterException("An application should must have a type.");
            System.out.println("Hod Remarksa is null...");

        } else {
            app.setHodRemarks(hodRemarks);
        }
        if (sscRemarks.isEmpty()) {
            // throw new WrongParameterException("An application should must have a type.");
            System.out.println("SSC remarks is null...");

        } else {
            app.setSscRemarks(sscRemarks);
        }
        if (status.isEmpty()) {
            throw new WrongParameterException("An application should must have status.");
        } else {
            app.setStatus(status);
        }
        if (submissionDate == null) {
            Instant instant = Instant.now();
            submissionDate = Date.from(instant);
            System.out.println("Date = " + submissionDate.toString());

        }
        app.setSubmissionDate(submissionDate);
        System.out.println("Date after = " + submissionDate.toString());

        if (semester == null || semester >= 49) {
            throw new WrongParameterException("An applicant should must have semester.");

        } else {
            app.setSemester(semester);
        }
        if (extraSemester == null) {
            System.out.println("Extra Semester is null...");

        } else {
            app.setExtraSemester(extraSemester);
        }
        if (extraYear <= 2000 || extraYear >= submissionDate.getYear()) {
            throw new WrongParameterException("Invalid Year");
        } else {
            app.setExtraYear(extraYear);
        }
        if (degreeTitle.isEmpty()) {
//            throw new WrongParameterException("An application should must have a degree Title.");
            System.out.println("Degree Title is null...");

        } else {
            app.setDegreeTitle(degreeTitle);
        }
        if (transcript == null) {
//            throw new WrongParameterException("An application should must have a type.");
            System.out.println("Transcript is null...");

        } else {
            app.setTranscript(transcript);
        }
        if (cgpa > 4.0 || cgpa < 1) {
//            throw new WrongParameterException("An application should must have a type.");
            System.out.println("CGPA is null...");

        } else {
            app.setCgpa(cgpa);
        }
        if (campusName.isEmpty()) {
            throw new WrongParameterException("An application should must have a type.");
        } else {
            app.setCampusName(campusName);
        }
        if (type.isEmpty()) {
            throw new WrongParameterException("An application should must have a type.");
        } else {
            app.setType(type);
        }
        User u = em.find(User.class, userId);
        app.setUserId(u);
        em.persist(app);
        return app;
    }

    @Override
    public Application getApplicationById(int id) throws WrongParameterException, NotFoundException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Application app = em.find(Application.class, id);

        if (app == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return app;
        }
    }

    @Override
    public void deleteApplicaion(int id) throws NotFoundException {

        try {
            Application app;
            app = this.getApplicationById(id);
            em.remove(app);
            System.out.println("Application with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Application with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Application> getAllApplication() throws NotFoundException {
        Query qry = em.createNamedQuery("Application.findAll");
        List<Application> allApplicationList = qry.getResultList();
        if (allApplicationList == null || allApplicationList.isEmpty()) {
            throw new NotFoundException("No Application is found.");
        }
        return allApplicationList;
    }

    @Override
    public Application updateApplication(int id, String type, String subject, String content, String hodRemarks, String sscRemarks, String status, Date submissionDate, Character semester, Character extraSemester, int extraYear, String degreeTitle, byte[] transcript, float cgpa, String campusName, int userId) throws NotFoundException, WrongParameterException {
        try {
            Application app;
            app = this.getApplicationById(id);
            System.out.println("Application with id " + id + " is found successfully");
            if (type.isEmpty()) {
                throw new WrongParameterException("An application should must have a type.");
            } else {
                app.setType(type);
            }
            if (subject.isEmpty()) {
                throw new WrongParameterException("An application should must have a subject.");
            } else {
                app.setSybject(subject);
            }
            if (content.isEmpty()) {
                throw new WrongParameterException("An application should must have content.");
            } else {
                app.setContent(content);
            }
            if (hodRemarks.isEmpty()) {
                // throw new WrongParameterException("An application should must have a type.");
                System.out.println("Hod Remarksa is null...");

            } else {
                app.setHodRemarks(hodRemarks);
            }
            if (sscRemarks.isEmpty()) {
                // throw new WrongParameterException("An application should must have a type.");
                System.out.println("SSC remarks is null...");

            } else {
                app.setSscRemarks(sscRemarks);
            }
            if (status.isEmpty()) {
                throw new WrongParameterException("An application should must have status.");
            } else {
                app.setStatus(status);
            }
            if (submissionDate == null) {
                Instant instant = Instant.now();
                submissionDate = Date.from(instant);
                System.out.println("Date = " + submissionDate.toString());

            }
            app.setSubmissionDate(submissionDate);
            System.out.println("Date after = " + submissionDate.toString());

            if (semester == null || semester >= 49) {
                throw new WrongParameterException("An applicant should must have semester.");

            } else {
                app.setSemester(semester);
            }
            if (extraSemester == null) {
                System.out.println("Extra Semester is null...");

            } else {
                app.setExtraSemester(extraSemester);
            }
            if (extraYear <= 2000 || extraYear >= submissionDate.getYear()) {
                throw new WrongParameterException("Invalid Year");
            } else {
                app.setExtraYear(extraYear);
            }
            if (degreeTitle.isEmpty()) {
//            throw new WrongParameterException("An application should must have a degree Title.");
                System.out.println("Degree Title is null...");

            } else {
                app.setDegreeTitle(degreeTitle);
            }
            if (transcript == null) {
//            throw new WrongParameterException("An application should must have a type.");
                System.out.println("Transcript is null...");

            } else {
                app.setTranscript(transcript);
            }
            if (cgpa > 4.0 || cgpa < 1) {
//            throw new WrongParameterException("An application should must have a type.");
                System.out.println("CGPA is null...");

            } else {
                app.setCgpa(cgpa);
            }
            if (campusName.isEmpty()) {
                throw new WrongParameterException("An application should must have a type.");
            } else {
                app.setCampusName(campusName);
            }
            if (type.isEmpty()) {
                throw new WrongParameterException("An application should must have a type.");
            } else {
                app.setType(type);
            }
            em.persist(app);
            return app;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Application with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }

}
