package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.InterviewDetailsDAOInterface;
import com.mindgate.recruitment.pojo.InterviewDetails;

@Service
public class InterviewDetailsService implements InterviewDetailsServiceInterface{

	@Autowired
	InterviewDetailsDAOInterface interviewDetailsDAOInterface;
	
	@Override
	public boolean addInterviewer(InterviewDetails interviewer) {
		
		return interviewDetailsDAOInterface.addInterview(interviewer);
	}

	@Override
	public boolean updaterequest(int interviewId,InterviewDetails interviewer) {
		

		return interviewDetailsDAOInterface.updateInterview(interviewId,interviewer);

	}

	@Override
	public boolean deleteInterViewer(int interviewId) {
		

		return interviewDetailsDAOInterface.deleteInterview(interviewId);

	}

	@Override
	public InterviewDetails getInterViewer(int interviewId) {
		
		return interviewDetailsDAOInterface.getInterView(interviewId);

	}

	@Override
	public List<InterviewDetails> getAllInterViewer() {
		
		return interviewDetailsDAOInterface.getAllInterView();

	}

}


