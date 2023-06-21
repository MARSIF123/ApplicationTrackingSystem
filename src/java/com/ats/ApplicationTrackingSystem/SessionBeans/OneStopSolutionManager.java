package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Application;
import com.ats.ApplicationTrackingSystem.Entities.Onestopsolution;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class OneStopSolutionManager implements OneStopSolutionManagerRemote {

   @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Onestopsolution addOnestopsolution(Character bloodGroup,Character degreeProgram,Short maritalStatus,int session, String religion,String cnic,String address,String ptcl, String faculty,Date challanDate,String challanNumber,byte[] challan,Short degreeStstus,byte[] transcripts,byte[] cnicCopy, int applicationId) throws WrongParameterException {
        Onestopsolution onestopsolution = new Onestopsolution();
        if (bloodGroup<0) {
            throw new WrongParameterException("bloodGroup can not be empty");

        } else {
            onestopsolution.setBloodGroup(bloodGroup);

        }
        if (degreeProgram > 4) {
            throw new WrongParameterException("degreeProgram can not be empty");

        } else {
            onestopsolution.setDegreeProgram(degreeProgram);

        }
        if (maritalStatus<0) {
            throw new WrongParameterException("maritalStatus can not be empty");

        } else {
            onestopsolution.setMaritalStatus(maritalStatus);

        }
        if (session<0) {
            throw new WrongParameterException("session can not be empty");

        } else {
            onestopsolution.setSession(session);

        }
        if (religion.isEmpty()) {
            throw new WrongParameterException("religion can not be empty");

        } else {
            onestopsolution.setReligion(religion);

        }
        if (cnic.isEmpty()) {
            throw new WrongParameterException("cnic can not be empty");

        } else {
            onestopsolution.setCnic(cnic);

        }
        if (address.isEmpty()) {
            throw new WrongParameterException("address can not be empty");

        } else {
            onestopsolution.setAddress(address);

        }
        if (ptcl.isEmpty()) {
            throw new WrongParameterException("ptcl can not be empty");

        } else {
            onestopsolution.setPtcl(ptcl);

        }
        if (faculty.isEmpty()) {
            throw new WrongParameterException("faculty can not be empty");

        } else {
            onestopsolution.setFaculty(faculty);

        }
        if (challanDate==null) {
            throw new WrongParameterException("challanDate can not be empty");

        } else {
            onestopsolution.setChallanDate(challanDate);

        }
        if (challanNumber.isEmpty()) {
            throw new WrongParameterException("challanNumber can not be empty");

        } else {
            onestopsolution.setChallanNumber(challanNumber);

        }
        if (challan == null) {
            throw new WrongParameterException("challan can not be empty");

        } else {
            onestopsolution.setChallan(challan);

        }
        if (degreeStstus<0) {
            throw new WrongParameterException("degreeStstus can not be empty");

        } else {
            onestopsolution.setDegreeStstus(degreeStstus);

        }
          if (transcripts == null) {
            throw new WrongParameterException("transcripts can not be empty");

        } else {
            onestopsolution.setTranscripts(transcripts);

        }  if (cnicCopy == null) {
            throw new WrongParameterException("cnicCopy can not be empty");

        } else {
            onestopsolution.setCnicCopy(cnicCopy);

        }
        if (applicationId<0) {
            throw new WrongParameterException("applicationId can not be empty");

        } else {
           Application a = em.find(Application.class, applicationId);
           onestopsolution.setApplicationId(a);
      
            

        }
        em.persist(onestopsolution);
        return onestopsolution;
    }

    @Override
    public Onestopsolution getOnestopsolutionById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Onestopsolution onestopsolution = em.find(Onestopsolution.class, id);

        if (onestopsolution == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return onestopsolution;
        }   
    }

    @Override
    public void deleteOnestopsolution(int id) throws NotFoundException {
        try {
            Onestopsolution onestopsolution;
            onestopsolution = this.getOnestopsolutionById(id);
            em.remove(onestopsolution);
            System.out.println("Onestopsolution with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Onestopsolution with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Onestopsolution> getAllOnestopsolutions() throws NotFoundException {
        Query qry = em.createNamedQuery("Onestopsolution.findAll");
        List<Onestopsolution> allOnestopsolutionList = qry.getResultList();
        if (allOnestopsolutionList == null || allOnestopsolutionList.isEmpty()) {
            throw new NotFoundException("No Onestopsolution is found.");
        }
        return allOnestopsolutionList;
    }

    @Override
    public Onestopsolution updateOnestopsolution(int id,Character bloodGroup,Character degreeProgram,Short maritalStatus,int session, String religion,String cnic,String address,String ptcl, String faculty,Date challanDate,String challanNumber,byte[] challan,Short degreeStstus,byte[] transcripts,byte[] cnicCopy, int applicationId) throws NotFoundException, WrongParameterException {
        try {
            Onestopsolution onestopsolution;
            onestopsolution = this.getOnestopsolutionById(id);
            System.out.println("Onestopsolution with id " + id + " is found successfully");
             if (bloodGroup<0) {
            throw new WrongParameterException("bloodGroup can not be empty");

        } else {
            onestopsolution.setBloodGroup(bloodGroup);

        }
        if (degreeProgram > 4) {
            throw new WrongParameterException("degreeProgram can not be empty");

        } else {
            onestopsolution.setDegreeProgram(degreeProgram);

        }
        if (maritalStatus<0) {
            throw new WrongParameterException("maritalStatus can not be empty");

        } else {
            onestopsolution.setMaritalStatus(maritalStatus);

        }
        if (session<0) {
            throw new WrongParameterException("session can not be empty");

        } else {
            onestopsolution.setSession(session);

        }
        if (religion.isEmpty()) {
            throw new WrongParameterException("religion can not be empty");

        } else {
            onestopsolution.setReligion(religion);

        }
        if (cnic.isEmpty()) {
            throw new WrongParameterException("cnic can not be empty");

        } else {
            onestopsolution.setCnic(cnic);

        }
        if (address.isEmpty()) {
            throw new WrongParameterException("address can not be empty");

        } else {
            onestopsolution.setAddress(address);

        }
        if (ptcl.isEmpty()) {
            throw new WrongParameterException("ptcl can not be empty");

        } else {
            onestopsolution.setPtcl(ptcl);

        }
        if (faculty.isEmpty()) {
            throw new WrongParameterException("faculty can not be empty");

        } else {
            onestopsolution.setFaculty(faculty);

        }
        if (challanDate==null) {
            throw new WrongParameterException("challanDate can not be empty");

        } else {
            onestopsolution.setChallanDate(challanDate);

        }
        if (challanNumber.isEmpty()) {
            throw new WrongParameterException("challanNumber can not be empty");

        } else {
            onestopsolution.setChallanNumber(challanNumber);

        }
        if (challan == null) {
            throw new WrongParameterException("challan can not be empty");

        } else {
            onestopsolution.setChallan(challan);

        }
        if (degreeStstus<0) {
            throw new WrongParameterException("degreeStstus can not be empty");

        } else {
            onestopsolution.setDegreeStstus(degreeStstus);

        }
          if (transcripts == null) {
            throw new WrongParameterException("transcripts can not be empty");

        } else {
            onestopsolution.setTranscripts(transcripts);

        }  if (cnicCopy == null) {
            throw new WrongParameterException("cnicCopy can not be empty");

        } else {
            onestopsolution.setCnicCopy(cnicCopy);

        }
        if (applicationId<0) {
            throw new WrongParameterException("applicationId can not be empty");

        } else {
            

        }
            em.persist(onestopsolution);
            return onestopsolution;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Onestopsolution with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }
}
