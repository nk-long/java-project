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

import com.mindgate.recruitment.pojo.ApplicationDetails;
import com.mindgate.recruitment.service.ApplicationDetailServiceInterface;

@CrossOrigin
@RestController
@RequestMapping("/ApplicationDetails")
public class ApplicationDetailsController {

	@Autowired
	private ApplicationDetailServiceInterface applicationDetailServiceInterface;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/addApplication", method = RequestMethod.POST)
	public boolean addApplication(@RequestBody ApplicationDetails applicationDetails) {
		logger.info("addApplication");
		logger.info(applicationDetails.toString());
		return applicationDetailServiceInterface.addApplication(applicationDetails);

	}

	@RequestMapping(value = "/{applicationId}", method = RequestMethod.PUT)
	public boolean updateApplication(@PathVariable("applicationId") int applicationId,
			@RequestBody ApplicationDetails applicationDetails) {
		logger.info("updateApplication");
		logger.info("application Id" + applicationId);
		return applicationDetailServiceInterface.updateApplication(applicationId, applicationDetails);

	}

	@RequestMapping(value = "/{applicationId}", method = RequestMethod.DELETE)
	public boolean deleteApplication(@PathVariable int applicationId) {
		logger.info("deleteApplication");
		logger.info("application id" + applicationId);
		return applicationDetailServiceInterface.deleteApplication(applicationId);

	}

	@RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)

	public ApplicationDetails getApplicationDetailsByapplicationId(@PathVariable("applicationId") int applicationId) {
		logger.info("getApplicationDetailsByapplicationId");

		return applicationDetailServiceInterface.getApplicationDetailsByapplicationId(applicationId);

	}

	@RequestMapping(value = "/getAllApplicationDetails", method = RequestMethod.GET)
	public List<ApplicationDetails> getAllApplicationDetails() {
		logger.info("getAllApplicationDetails");

		return applicationDetailServiceInterface.getAllApplicationDetails();

	}

}
