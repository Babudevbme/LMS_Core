package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.RoleDAOImpl;
import com.revature.model.Department;
import com.revature.model.Role;

@Service
public class RoleServiceImpl {
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	private  RoleDAOImpl RoleDAO;
	
	public List<Role> getAllRoles() throws DataServiceException {
		List<Role> role=null;
		role=RoleDAO.getAllRoles();
		logger.info("retrived successfully");
		return role;
	}
	public Integer addRole(Role role) throws DataServiceException {
		int rows=RoleDAO.addRole(role);
		logger.info("Added department");
		return rows;
	}
}
