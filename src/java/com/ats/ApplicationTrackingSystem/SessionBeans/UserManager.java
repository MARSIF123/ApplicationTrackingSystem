package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.User;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserManager implements UserManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public User addUser(String firstName, String lastName, String fatherName, String registrationNumber, String uogEmail, String personalEmail, String phoneNo, String userType, byte[] profile, Short gender, Date dateOfBirth) throws WrongParameterException {
        User user = new User();
        if (firstName == null) {
            System.out.println("First Name is not valid");
            throw new WrongParameterException("Wrong Name Exceptioooooooooon");
        } else {
            user.setFirstName(firstName);
        }
        if (lastName == null || lastName.isEmpty()) {
            System.out.println("Last Name is not valid");
        } else {
            user.setLastName(lastName);
        }
        if (fatherName == null || fatherName.isEmpty()) {
            System.out.println("Father Name is not valid");
        } else {
            user.setFatherName(fatherName);
        }
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            System.out.println("Registration Number is not valid");
        } else {
            user.setRegNo(registrationNumber);
        }
        if (uogEmail == null || uogEmail.isEmpty()) {
            System.out.println("UOG email is not valid");
        } else {
            user.setUogEmail(uogEmail);
        }
        if (personalEmail == null || personalEmail.isEmpty()) {
            System.out.println("Personal Email is not valid");
        } else {
            user.setPersonalEmail(personalEmail);
        }
        if (phoneNo == null || phoneNo.isEmpty()) {
            System.out.println("Phoneis not valid");
        } else {
            user.setPhoneNo(phoneNo);
        }
        if (userType == null || userType.isEmpty()) {
            System.out.println("User Type is not valid");
        } else {
            user.setUserType(userType);
        }
        if (profile == null) {
            System.out.println("Profile is not valid");
        } else {
            user.setProfile(profile);
        }
        if (gender == null) {
            System.out.println("Gender is not valid");
        } else {
            user.setGender(gender);
            System.out.println("Gender is  valid");

        }
        if (dateOfBirth == null) {
            System.out.println("Date is not valid ok");
        } else {
            user.setDateOfBirth(dateOfBirth);
            System.out.println("Date is  valid");

        } 

        em.persist(user);
        System.out.println("em.persist called");

        return user;
    }

    

    @Override
    public User getUserById(int id) throws NotFoundException, WrongParameterException {
        User user = em.find(User.class, id);
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        if (user == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return user;
        }
    }

    @Override
    public void deleteUser(int id) throws NotFoundException {
        try {
            User user;
            user = this.getUserById(id);
            em.remove(user);
            System.out.println("User with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("User with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<User> getAllUsers() throws NotFoundException {
        Query qry = em.createNamedQuery("User.findAll");
        List<User> allUserList = qry.getResultList();
        if (allUserList == null || allUserList.isEmpty()) {
            throw new NotFoundException("No User is found.");
        }
        return allUserList;
    }

    @Override
    public User updateUser(int id, String firstName, String lastName, String fatherName, String registrationNumber, String uogEmail, String personalEmail, String phoneNo, String userType, byte[] profile, Short gender, Date dateOfBirth ) throws NotFoundException, WrongParameterException {
        try {
            User user;
            user = this.getUserById(id);
            System.out.println("User with id " + id + " is found successfully");
            if (firstName == null) {
                System.out.println("First Name is not valid");
                throw new WrongParameterException("Wrong Name Exceptioooooooooon");
            } else {
                user.setFirstName(firstName);
            }
            if (lastName == null || lastName.isEmpty()) {
                System.out.println("Last Name is not valid");
            } else {
                user.setLastName(lastName);
            }
            if (fatherName == null || fatherName.isEmpty()) {
                System.out.println("Father Name is not valid");
            } else {
                user.setFatherName(fatherName);
            }
            if (registrationNumber == null || registrationNumber.isEmpty()) {
                System.out.println("Registration Number is not valid");
            } else {
                user.setRegNo(registrationNumber);
            }
            if (uogEmail == null || uogEmail.isEmpty()) {
                System.out.println("UOG email is not valid");
            } else {
                user.setUogEmail(uogEmail);
            }
            if (personalEmail == null || personalEmail.isEmpty()) {
                System.out.println("Personal Email is not valid");
            } else {
                user.setPersonalEmail(personalEmail);
            }
            if (phoneNo == null || phoneNo.isEmpty()) {
                System.out.println("Phoneis not valid");
            } else {
                user.setPhoneNo(phoneNo);
            }
            if (userType == null || userType.isEmpty()) {
                System.out.println("User Type is not valid");
            } else {
                user.setUserType(userType);
            }
            if (profile == null) {
                System.out.println("Profile is not valid");
            } else {
                user.setProfile(profile);
            }
            if (gender == null) {
                System.out.println("Gender is not valid");
            } else {
                user.setGender(gender);
                System.out.println("Gender is  valid");

            }
            if (dateOfBirth == null) {
                System.out.println("Date is not valid ok");
            } else {
                user.setDateOfBirth(dateOfBirth);
                System.out.println("Date is  valid");

            }
           
            em.persist(user);
            return user;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("User with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }

}
