package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.EmployeeDetailsDAOInterface;
import com.mindgate.recruitment.pojo.EmployeeDetails;

@Service
public class EmployeeDetailsService implements EmployeeDetailsServiceInterface {

	@Autowired
	private EmployeeDetailsDAOInterface empDetailDaoServ;

	@Override
	public boolean addEmployee(EmployeeDetails employeeMaster) {

		return empDetailDaoServ.addEmployee(employeeMaster);
	}

	@Override
	public boolean UpdateEmployee(EmployeeDetails employeeMaster) {
		// TODO Auto-generated method stub
		return empDetailDaoServ.UpdateEmployee(employeeMaster);
	}

	@Override
	public EmployeeDetails getOneEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return empDetailDaoServ.getOneEmployee(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDetailDaoServ.getAllEmployee();
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return empDetailDaoServ.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDetails userLogin(EmployeeDetails employeeDetails) {
		return empDetailDaoServ.userLogin(employeeDetails);

}
}
