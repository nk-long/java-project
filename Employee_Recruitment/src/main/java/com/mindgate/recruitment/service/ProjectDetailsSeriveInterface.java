package com.mindgate.recruitment.service;

import java.util.List;

import com.mindgate.recruitment.pojo.ProjectDetails;

public interface ProjectDetailsSeriveInterface {
	public boolean addProject(ProjectDetails projectDetails);

	public boolean updateProject(String projectId, ProjectDetails projectDetails);

	public boolean deleteProject(String projectId);

	public ProjectDetails getProjectDetailsByprojectId(String projectId);

	public List<ProjectDetails> getAllProjectDetails();

}
