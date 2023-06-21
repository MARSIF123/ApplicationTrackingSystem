package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.User;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UserManagerRemote {

    User addUser(String firstName, String lastName, String fatherName, String registrationNumber, String uogEmail, String personalEmail, String phoneNo,String userType, byte[] profile, Short gender, Date dateOfBirth) throws WrongParameterException;

    void deleteUser(int id)throws NotFoundException;

    User updateUser(int id,String firstName, String lastName, String fatherName, String registrationNumber, String uogEmail, String personalEmail, String phoneNo, String userType, byte[] profile, Short gender, Date dateOfBirth)throws NotFoundException, WrongParameterException ;

    User getUserById(int id) throws NotFoundException, WrongParameterException;

    List<User> getAllUsers()throws NotFoundException ;

}
