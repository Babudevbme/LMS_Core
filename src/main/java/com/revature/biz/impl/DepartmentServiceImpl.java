package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.DepartmentDAOImpl;
import com.revature.model.Department;

@Service
public class DepartmentServiceImpl {
	private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentDAOImpl departmentDAO;

	public List<Department> getAllDepartment() throws DataServiceException {
		List<Department> department = null;
		department = departmentDAO.getAllDepartment();
		logger.info("retrived successfully");
		return department;
	}

	public Department getDepartmentById(int id) throws DataServiceException {
		Department department = new Department();
		department = departmentDAO.getDepartmentById(id);
		logger.info("retrived successfully");
		return department;
	}

	public Integer updateDepartment(Department department) throws DataServiceException {
		int rows = departmentDAO.updateDepartment(department);
		logger.info("Added department");
		return rows;
	}
}
