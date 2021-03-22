package com.mindgate.recruitment.service;

import java.util.List;

import com.mindgate.recruitment.pojo.InterviewDetails;

public interface InterviewDetailsServiceInterface {

	public boolean addInterviewer(InterviewDetails interviewer);
	
	public boolean updaterequest(int interviewId,InterviewDetails interviewer);
	
	public boolean deleteInterViewer(int interviewId);
	
	public InterviewDetails getInterViewer(int interviewId);
	
	public List<InterviewDetails> getAllInterViewer();
	
}
