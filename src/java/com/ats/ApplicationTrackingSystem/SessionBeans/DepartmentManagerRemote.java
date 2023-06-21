package com.ats.ApplicationTrackingSystem.SessionBeans;

import com.ats.ApplicationTrackingSystem.Entities.Department;
import com.ats.ApplicationTrackingSystem.Exceptions.NotFoundException;
import com.ats.ApplicationTrackingSystem.Exceptions.WrongParameterException;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DepartmentManagerRemote {

    Department addDepartment(String title) throws WrongParameterException;

    Department getDepartmentById(int id) throws NotFoundException, WrongParameterException;

    void deleteDepartment(int id) throws NotFoundException;

    List<Department> getAllDepartments() throws NotFoundException;

    Department updateDepartment(int id, String title) throws NotFoundException, WrongParameterException;
}
