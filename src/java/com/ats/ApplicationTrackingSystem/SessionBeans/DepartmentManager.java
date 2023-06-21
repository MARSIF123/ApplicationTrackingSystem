package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Department;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class DepartmentManager implements DepartmentManagerRemote {

    @PersistenceContext(unitName = "ApplicationTrackingSystem-ejbPU")
    EntityManager em;

    @Override
    public Department addDepartment(String title) throws WrongParameterException {
        Department department = new Department();
        if (title.isEmpty()) {
            throw new WrongParameterException("Title can not be empty");

        } else {
            department.setTitle(title);

        }
       
        em.persist(department);
        return department;
    }

    @Override
    public Department getDepartmentById(int id) throws NotFoundException, WrongParameterException {
        if (id <= 0) {
            throw new WrongParameterException("Id is not valid.");
        }
        Department department = em.find(Department.class, id);

        if (department == null) {
            throw new NotFoundException("The required id is not found. " + id);
        } else {
            return department;
        }
    }

    @Override
    public void deleteDepartment(int id) throws NotFoundException {
        try {
            Department department;
            department = this.getDepartmentById(id);
            em.remove(department);
            System.out.println("Department with id " + id + " is removed successfully");

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Department with id " + id + " could'nt be removed. " + ex.getMessage());

        }
    }

    @Override
    public List<Department> getAllDepartments() throws NotFoundException {
        Query qry = em.createNamedQuery("Department.findAll");
        List<Department> allDepartmentList = qry.getResultList();
        if (allDepartmentList == null || allDepartmentList.isEmpty()) {
            throw new NotFoundException("No Department is found.");
        }
        return allDepartmentList;
    }

    @Override
    public Department updateDepartment(int id, String title) throws NotFoundException, WrongParameterException {
        try {
            Department department;
            department = this.getDepartmentById(id);
            System.out.println("Department with id " + id + " is found successfully");
            if (title.isEmpty()) {
                throw new WrongParameterException("Title can not be empty");

            } else {
                department.setTitle(title);

            }
           
            em.persist(department);
            return department;

        } catch (WrongParameterException | NotFoundException ex) {
            System.out.println("Department with id " + id + " could'nt be updated. " + ex.getMessage());
            return null;
        }
    }
}
