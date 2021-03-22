package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.recruitment.pojo.ApplicationDetails;


public interface ApplicationDetailServiceInterface {
	public boolean addApplication(ApplicationDetails applicationDetails);

	public boolean updateApplication(int applicationId, ApplicationDetails applicationDetails);

	public boolean deleteApplication(int applicationId);

	public ApplicationDetails getApplicationDetailsByapplicationId(int applicationId);

	public List<ApplicationDetails> getAllApplicationDetails();

}
