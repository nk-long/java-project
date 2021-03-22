package com.mindgate.recruitment.DAO;

import java.util.List;

import com.mindgate.recruitment.pojo.ApplicationDetails;

public interface ApplicationDetailsDAOInterface {
	public boolean addApplication(ApplicationDetails applicationDetails);

	public boolean updateApplication(int applicationId, ApplicationDetails applicationDetails);

	public boolean deleteApplication(int applicationId);

	public ApplicationDetails getApplicationDetailsByapplicationId(int applicationId);

	public List<ApplicationDetails> getAllApplicationDetails();

}
