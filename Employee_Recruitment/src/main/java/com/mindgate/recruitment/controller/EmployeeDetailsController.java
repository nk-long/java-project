package com.mindgate.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.recruitment.pojo.EmployeeDetails;
import com.mindgate.recruitment.service.EmployeeDetailsServiceInterface;
@RestController
@CrossOrigin
@RequestMapping("/employeedetail")
public class EmployeeDetailsController {
	
	private  final Logger log= LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private EmployeeDetailsServiceInterface empDetailserviceInterface;
	
	@RequestMapping(value="/addemployee",method=RequestMethod.POST)
	public boolean addemployeee(@RequestBody EmployeeDetails employeeDetails)
	{
		log.info("addemployeee");
		return empDetailserviceInterface.addEmployee(employeeDetails);
	}
	
	@RequestMapping(value="/updateEmp/{employeeId}",method=RequestMethod.PUT)
	public boolean updateEmployee(@PathVariable int employeeId,@RequestBody EmployeeDetails employeeDetails){
		log.info("updateEmployee");
		return empDetailserviceInterface.UpdateEmployee(employeeDetails);
	}
	
	@RequestMapping(value="/{employeeId}",method=RequestMethod.GET)
	public EmployeeDetails getEmployee(@PathVariable int employeeId)
	{
		log.info("getEmployee");
		return empDetailserviceInterface.getOneEmployee(employeeId);
	}
	
	@RequestMapping(value="/getallemployee",method=RequestMethod.GET)
	public List<EmployeeDetails> getallEmployee()
	{
		log.info("getallEmployee");
		return empDetailserviceInterface.getAllEmployee();
	}
	
	@RequestMapping(value="{employeeId}",method=RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int employeeId)
	{
		log.info("deleteEmployee");
		return empDetailserviceInterface.deleteEmployee(employeeId);
	}
	
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	public EmployeeDetails userLogin(@RequestBody EmployeeDetails employeeDetails)
	{
		log.info("userlogin");

		return empDetailserviceInterface.userLogin(employeeDetails);
	}
	
}
