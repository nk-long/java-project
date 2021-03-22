package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.ApplicationDetailsDAOInterface;
import com.mindgate.recruitment.pojo.ApplicationDetails;

@Service
public class ApplicationDetailService implements ApplicationDetailServiceInterface {

	@Autowired
	private ApplicationDetailsDAOInterface applicationDetailsDAOInterface;

	public boolean addApplication(ApplicationDetails applicationDetails) {
		
		if(applicationDetails.getSscMarks()>=60 && applicationDetails.getHhcMarks()>60 && applicationDetails.getDegree()>=60)
		{
			applicationDetailsDAOInterface.addApplication(applicationDetails);
		}
        
		return applicationDetailsDAOInterface.addApplication(applicationDetails);
		 
	}

	public boolean updateApplication(int applicationId, ApplicationDetails applicationDetails) {

		return applicationDetailsDAOInterface.updateApplication(applicationId, applicationDetails);
	}

	public boolean deleteApplication(int applicationId) {
		return applicationDetailsDAOInterface.deleteApplication(applicationId);
	}

	public ApplicationDetails getApplicationDetailsByapplicationId(int applicationId) {

		return applicationDetailsDAOInterface.getApplicationDetailsByapplicationId(applicationId);
	}

	public List<ApplicationDetails> getAllApplicationDetails() {

		return applicationDetailsDAOInterface.getAllApplicationDetails();
	}

}
