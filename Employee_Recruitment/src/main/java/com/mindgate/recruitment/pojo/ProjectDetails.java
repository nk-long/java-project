package com.mindgate.recruitment.pojo;

import org.springframework.stereotype.Component;

@Component
public class ProjectDetails {
	
	private String  projectId ;
	private String projectName ;
	private int  maxStrength ;
	private int assignedStrength;
	private String specialization;
	
	public ProjectDetails() {
		// TODO Auto-generated constructor stub
	}

	public ProjectDetails(String projectId, String projectName, int maxStrength, int assignedStrength,
			String specialization) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.maxStrength = maxStrength;
		this.assignedStrength = assignedStrength;
		this.specialization = specialization;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getMaxStrength() {
		return maxStrength;
	}

	public void setMaxStrength(int maxStrength) {
		this.maxStrength = maxStrength;
	}

	public int getAssignedStrength() {
		return assignedStrength;
	}

	public void setAssignedStrength(int assignedStrength) {
		this.assignedStrength = assignedStrength;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", projectName=" + projectName + ", maxStrength=" + maxStrength
				+ ", assignedStrength=" + assignedStrength + ", Specialization=" + specialization + "]";
	}
	
}