package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Login;
import com.ats.ApplicationTrackingSystem.Entities.User;
import com.ats.ApplicationTrackingSystem.Exceptions.DatabaseInconsistentStateException;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginManager implements LoginManagerRemote {
    
    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;
    
    @Override
    public Login addLogin(String username, String password, int userId) throws WrongParameterException {
        Login login = new Login();
        if (username.isEmpty()) {
            throw new WrongParameterException("Username can not be empty");
            
        } else {
            login.setUsername(username);
            
        }
        if (password.isEmpty()) {
            throw new WrongParameterException("Password can not be empty");
            
        } else {
            login.setPassword(password);
            
        }
        
        User u = em.find(User.class, userId);
        login.setUserId(u);
        
        em.persist(login);
        return login;
    }
    
    @Override
    public Login getLoginById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Login login = em.find(Login.class, id);
        
        if (login == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return login;
        }
    }
    
    @Override
    public void deleteLogin(int id) throws NotFoundException {
        try {
            Login login;
            login = this.getLoginById(id);
            em.remove(login);
            System.out.println("Login with id " + id + " is removed successfully");
            
        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Login with id " + id + " could'nt be removed. " + ex.getMessage());
            
        }
    }
    
    @Override
    public List<Login> getAllLogins() throws NotFoundException {
        Query qry = em.createNamedQuery("Login.findAll");
        List<Login> allLoginList = qry.getResultList();
        if (allLoginList == null || allLoginList.isEmpty()) {
            throw new NotFoundException("No Login is found.");
        }
        return allLoginList;
    }
    
    @Override
    public Login updateLogin(int id, String username, String password, int userId) throws NotFoundException, WrongParameterException {
        try {
            Login login;
            login = this.getLoginById(id);
            System.out.println("Login with id " + id + " is found successfully");
            if (username.isEmpty()) {
                throw new WrongParameterException("Username can not be empty");
                
            } else {
                login.setUsername(username);
                
            }
            if (password.isEmpty()) {
                throw new WrongParameterException("Password can not be empty");
                
            } else {
                login.setPassword(password);
                
            }
            em.persist(login);
            return login;
            
        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Login with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public int validate(String username, String password) throws NotFoundException, DatabaseInconsistentStateException {
        
        Query qry = em.createNamedQuery("LoginEntity.findUser");
        qry.setParameter("username", username);
        qry.setParameter("password", password);
        try {
            Login login;
            login = (Login) qry.getSingleResult();
            //return login.getUserId();
            return login.getId();
            
        } catch (NoResultException ne) {
            throw new NotFoundException("Login with this Name or password is not found");
        } catch (NonUniqueResultException nue) {
            throw new DatabaseInconsistentStateException("Multiple records found for the username : " + username + " . Please check DB for consistency.");
            
        }
    }
    
}
