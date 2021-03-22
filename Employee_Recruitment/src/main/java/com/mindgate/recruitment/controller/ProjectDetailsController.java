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

import com.mindgate.recruitment.pojo.ProjectDetails;
import com.mindgate.recruitment.service.ProjectDetailsSeriveInterface;

@CrossOrigin
@RestController
@RequestMapping("/ProjectDetails")
public class ProjectDetailsController {

	@Autowired
	private ProjectDetailsSeriveInterface projectDetailsSeriveInterface;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public boolean addProject(@RequestBody ProjectDetails projectDetails) {
		logger.info("addProject");
		logger.info(projectDetails.toString());
		return projectDetailsSeriveInterface.addProject(projectDetails);
	}

	@RequestMapping(value = "/updateProject/{projectId}", method = RequestMethod.PUT)
	public boolean updateProject(@PathVariable("projectId") String projectId,
			@RequestBody ProjectDetails projectDetails) {
		logger.info("updateProject");
		logger.info("project id" + projectId);
		return projectDetailsSeriveInterface.updateProject(projectId, projectDetails);

	}

	@RequestMapping(value = "{projectId}", method = RequestMethod.DELETE)
	public boolean deleteProject(@PathVariable("projectId") String projectId) {
		logger.info("deleteProject");
		logger.info("project id" + projectId);
		return projectDetailsSeriveInterface.deleteProject(projectId);

	}

	@RequestMapping(value = "{projectId}", method = RequestMethod.GET)
	public ProjectDetails getProjectDetailsByprojectId(@PathVariable("projectId") String projectId) {
		logger.info("getProjectDetailsByprojectId");

		return projectDetailsSeriveInterface.getProjectDetailsByprojectId(projectId);

	}

	@RequestMapping(value = "/getAllProjectDetails", method = RequestMethod.GET)
	public List<ProjectDetails> getAllProjectDetails() {
		logger.info("getAllAddresss");

		return projectDetailsSeriveInterface.getAllProjectDetails();

	}

}
