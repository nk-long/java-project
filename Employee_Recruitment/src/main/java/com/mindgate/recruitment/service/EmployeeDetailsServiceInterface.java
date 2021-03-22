package com.mindgate.recruitment.service;

import java.util.List;

import com.mindgate.recruitment.pojo.EmployeeDetails;

public interface EmployeeDetailsServiceInterface {
	public boolean addEmployee(EmployeeDetails employeeMaster);
	
	public boolean UpdateEmployee(EmployeeDetails employeeMaster);
	public EmployeeDetails getOneEmployee(int employeeId);
	public List<EmployeeDetails> getAllEmployee( );
	public boolean deleteEmployee(int employeeId);
	public EmployeeDetails userLogin(EmployeeDetails employeeDetails);

	

}
