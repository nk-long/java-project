package com.mindgate.recruitment.DAO;

import java.util.List;

import com.mindgate.recruitment.pojo.InterviewDetails;

public interface InterviewDetailsDAOInterface {
	public boolean addInterview(InterviewDetails interviewer);

	public boolean updateInterview(int interviewId, InterviewDetails interviewer);

	public boolean deleteInterview(int interviewId);

	public InterviewDetails getInterView(int interviewId);

	public List<InterviewDetails> getAllInterView();
}
