package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.ProjectDetailsDAOInterface;
import com.mindgate.recruitment.pojo.ProjectDetails;

@Service
public class ProjectDetailsService implements ProjectDetailsSeriveInterface {

	@Autowired
	private ProjectDetailsDAOInterface projectDetailsDaoInterface;

	@Override
	public boolean addProject(ProjectDetails projectDetails) {
		return projectDetailsDaoInterface.addProject(projectDetails);
	}

	@Override
	public boolean updateProject(String projectId, ProjectDetails projectDetails) {
		return projectDetailsDaoInterface.updateProject(projectId, projectDetails);
	}

	@Override
	public boolean deleteProject(String projectId) {

		return projectDetailsDaoInterface.deleteProject(projectId);
	}

	@Override
	public ProjectDetails getProjectDetailsByprojectId(String projectId) {
		return projectDetailsDaoInterface.getProjectDetailsByprojectId(projectId);

	}

	@Override
	public List<ProjectDetails> getAllProjectDetails() {
		return projectDetailsDaoInterface.getAllProjectDetails();

	}

}
