package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.LeaveType;
@Transactional
@Repository
public class LeaveTypeDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<LeaveType> getAllLeaveTypes(String gender) throws DataServiceException{
		List<LeaveType> leaveType = null;
		StringBuilder sb;
		try {
			if(gender.equals("M")){
			sb = new StringBuilder("SELECT * FROM leave_types WHERE NAME!='Maternity Leave'");}
			else{
			sb = new StringBuilder("SELECT * FROM leave_types WHERE NAME!='Paternity Leave'");
			}
			leaveType = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveType;
	}
	public Integer updateLeaveType(LeaveType lt) throws DataServiceException {
				StringBuilder stringBuilder = new StringBuilder("update leave_types set name='"+lt.getName()+"',code='"+lt.getCode()+"' where id='"+lt.getId()+"");
				
				Integer rows = null;
				try {
					rows = dataRetriver.update(stringBuilder.toString());
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				logger.info("Department data retrieval success..");
				return rows;
			}
}
