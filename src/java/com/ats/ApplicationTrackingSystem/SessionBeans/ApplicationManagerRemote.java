package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Application;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

@Remote

public interface ApplicationManagerRemote {

    Application AddApplication(String type, String subject, String content, String hodRemarks, String sscRemarks, String status, Date submissionDate, Character semester, Character extraSemester, int extraYear, String degreeTitle, byte[] transcript, float cgpa, String campusName, int userId)throws WrongParameterException;

    Application getApplicationById(int id) throws  WrongParameterException, NotFoundException;

    void deleteApplicaion(int id) throws NotFoundException;

    List<Application> getAllApplication() throws NotFoundException;

    Application updateApplication(int id, String type, String subject, String content, String hodRemarks, String sscRemarks, String status, Date submissionDate, Character semester, Character extraSemester, int extraYear, String degreeTitle, byte[] transcript, float cgpa, String campusName, int userId) throws NotFoundException, WrongParameterException;
    
}
