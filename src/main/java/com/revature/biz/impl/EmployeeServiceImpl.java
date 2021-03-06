package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.EmployeeDAOImpl;
import com.revature.model.Employee;

@Service
public class EmployeeServiceImpl {
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDAOImpl employeeDAO;

	public List<Employee> getAllEmployee() throws DataServiceException {
		List<Employee> employee = null;
		employee = employeeDAO.getAllEmployees();
		logger.info("retrived successfully");
		return employee;
	}

	public List<Employee> getEmpListByManagerId(Integer managerId) throws DataServiceException {
		List<Employee> employee = employeeDAO.getEmpByManagerId(managerId);
		logger.info("retrived successfully");
		return employee;
	}

	public List<Employee> getEmpListById(Integer empId) throws DataServiceException {
		List<Employee> employee = employeeDAO.getEmpById(empId);
		logger.info("retrived successfully");
		return employee;
	}

	public Integer releaveEmployee(Employee employee) throws DataServiceException {
		int rows = employeeDAO.releaveEmployee(employee);
		logger.info("Releave Employee");
		return rows;
	}

	public Integer updateRoleForEmployee(Employee employee) throws DataServiceException {
		int rows = employeeDAO.updateRoleForEmployee(employee);
		logger.info("Updated Role for employee");
		return rows;
	}
	public Integer updateDeptForEmployee(Employee employee) throws DataServiceException {
        int rows = employeeDAO.updateDeptForEmployee(employee);
        logger.info("Updated Role for employee");
        return rows;
    }
	public List<Employee> getRemainingLeaves(Employee emp) throws DataServiceException {
        List<Employee> employee=null;
        employee=employeeDAO.getRemainingLeave(emp);
        logger.info("retrived successfully");
        return employee;
    }
}
