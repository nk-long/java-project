package com.mindgate.recruitment.pojo;

import org.springframework.stereotype.Component;


@Component
public class JobPostDetails {
	
	private int jobId;
	private String jobDescription;
	private int salary;
	private String qualification;
	private String specialization;
	private String location;
	private String experinece;
	
	
	public JobPostDetails() {
		// TODO Auto-generated constructor stub
	}


	public JobPostDetails(int jobId, String jobDescription, int salary, String qualification, String specialization,
			String location, String experinece) {
		super();
		this.jobId = jobId;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.qualification = qualification;
		this.specialization = specialization;
		this.location = location;
		this.experinece = experinece;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getExperinece() {
		return experinece;
	}


	public void setExperinece(String experinece) {
		this.experinece = experinece;
	}


	@Override
	public String toString() {
		return "JobPostDetails [jobId=" + jobId + ", jobDescription=" + jobDescription + ", salary=" + salary
				+ ", qualification=" + qualification + ", specialization=" + specialization + ", location=" + location
				+ ", experinece=" + experinece + "]";
	}
	
	

	

	
}