package com.mindgate.recruitment.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {
	
	private double employeeId;
	private String employeeName;
	private String designation;
	private String specilization;
	private double salary;
	private String userName;
	private String userPassword;
	@Autowired
	private ProjectDetails projectDetails;
	private double contactNo;
	private String emailId;
	private String address;
	private String gender;
	
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(int employeeId, String employeeName,
			String designation, String specilization, double salary,
			String userName, String userPassword,
			ProjectDetails projectDetails, double contactNo, String emailId,
			String address, String gender) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.specilization = specilization;
		this.salary = salary;
		this.userName = userName;
		this.userPassword = userPassword;
		this.projectDetails = projectDetails;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.address = address;
		this.gender = gender;
	}





	
	public double getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(double employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSpecilization() {
		return specilization;
	}

	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	

	public double getContactNo() {
		return contactNo;
	}


	public void setContactNo(double contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", designation=" + designation
				+ ", specilization=" + specilization + ", salary=" + salary
				+ ", userName=" + userName + ", userPassword=" + userPassword
				+ ", projectDetails=" + projectDetails + ", contactNo="
				+ contactNo + ", emailId=" + emailId + ", address=" + address
				+ ", gender=" + gender + ", toString()=" + super.toString()
				+ "]";
}
	
}

