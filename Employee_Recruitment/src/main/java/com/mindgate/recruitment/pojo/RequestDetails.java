package com.mindgate.recruitment.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class RequestDetails {
	private int requestId;

	private String specialization;
	@Autowired
	private ProjectDetails projectdetails;
	private String qualification;
	private int  noOfRequiredEmployee;
	private String requestSatus;

	public RequestDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestDetails(int requestId, EmployeeDetails employeedetails, String specialization,
			ProjectDetails projectdetails, String qualification, int noOfRequiredEmployee, String requestSatus) {
		super();
		this.requestId = requestId;
		
		this.specialization = specialization;
		this.projectdetails = projectdetails;
		this.qualification = qualification;
		this.noOfRequiredEmployee = noOfRequiredEmployee;
		this.requestSatus = requestSatus;
	}

	
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ProjectDetails getProjectdetails() {
		return projectdetails;
	}

	public void setProjectdetails(ProjectDetails projectdetails) {
		this.projectdetails = projectdetails;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getNoOfRequiredEmployee() {
		return noOfRequiredEmployee;
	}

	public void setNoOfRequiredEmployee(int noOfRequiredEmployee) {
		this.noOfRequiredEmployee = noOfRequiredEmployee;
	}

	public String getRequestSatus() {
		return requestSatus;
	}

	public void setRequestSatus(String requestSatus) {
		this.requestSatus = requestSatus;
	}

	@Override
	public String toString() {
		return "RequestDetails [requestId=" + requestId +  ", specialization="
				+ specialization + ", projectdetails=" + projectdetails + ", qualification=" + qualification
				+ ", noOfRequiredEmployee=" + noOfRequiredEmployee + ", requestSatus=" + requestSatus + "]";
	}

	
	
	
	
	
}