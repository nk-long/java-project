package com.mindgate.recruitment.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class InterviewDetails {
	private int interviewId;
	private EmployeeDetails employeeDetails;
	private ApplicationDetails applicationDetails;
	private ProjectDetails projectDetails;
	private Date interviewDate;
	private String modeOfInterview;

	public InterviewDetails() {
		// TODO Auto-generated constructor stub
	}

	public InterviewDetails(int interviewId, EmployeeDetails employeeDetails, ApplicationDetails applicationDetails,
			ProjectDetails projectDetails, Date interviewDate,String modeOfInterview) {
		super();
		this.interviewId = interviewId;
		this.employeeDetails = employeeDetails;
		this.applicationDetails = applicationDetails;
		this.projectDetails = projectDetails;
		this.interviewDate = interviewDate;
		this.modeOfInterview = modeOfInterview;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public ApplicationDetails getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(ApplicationDetails applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	

	public String getModeOfInterview() {
		return modeOfInterview;
	}

	public void setModeOfInterview(String modeOfInterview) {
		this.modeOfInterview = modeOfInterview;
	}

	@Override
	public String toString() {
		return "InterviewerDetails [interviewId=" + interviewId + ", employeeDetails=" + employeeDetails
				+ ", applicationDetails=" + applicationDetails + ", projectDetails=" + projectDetails
				+ ", interviewDate=" + interviewDate + ", modeOfInterview="
				+ modeOfInterview + ", toString()=" + super.toString() + "]";
	}

}
