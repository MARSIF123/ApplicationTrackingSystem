/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Onestopsolution;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface OneStopSolutionManagerRemote {

    Onestopsolution addOnestopsolution(Character bloodGroup,Character degreeProgram,Short maritalStatus,int session, String religion,String cnic,String address,String ptcl, String faculty,Date challanDate,String challanNumber,byte[] challan,Short degreeStstus,byte[] transcripts,byte[] cnicCopy, int applicationId) throws WrongParameterException;

    Onestopsolution getOnestopsolutionById(int id) throws NotFoundException, WrongParameterException;

    void deleteOnestopsolution(int id) throws NotFoundException;

    List<Onestopsolution> getAllOnestopsolutions() throws NotFoundException;

    Onestopsolution updateOnestopsolution(int id, Character bloodGroup,Character degreeProgram,Short maritalStatus,int session, String religion,String cnic,String address,String ptcl, String faculty,Date challanDate,String challanNumber,byte[] challan,Short degreeStstus,byte[] transcripts,byte[] cnicCopy, int applicationId) throws NotFoundException, WrongParameterException;
}
