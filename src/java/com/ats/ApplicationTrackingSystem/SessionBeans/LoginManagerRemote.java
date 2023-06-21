package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Login;
import com.ats.ApplicationTrackingSystem.Exceptions.DatabaseInconsistentStateException;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface LoginManagerRemote {

    Login addLogin(String username, String password,int userId) throws WrongParameterException;

    Login getLoginById(int id) throws NotFoundException, WrongParameterException;

    void deleteLogin(int id) throws NotFoundException;

    List<Login> getAllLogins() throws NotFoundException;

    Login updateLogin(int id, String username, String password,int userId) throws NotFoundException, WrongParameterException;

    int validate(String username, String password) throws NotFoundException, DatabaseInconsistentStateException;

}
