package com.mindgate.recruitment.service;

import java.util.List;

import com.mindgate.recruitment.pojo.JobPostDetails;

public interface JobPostServiceInterface {
	
	public boolean addPost(JobPostDetails jobPostDetails);
	
	public JobPostDetails getonepost(int jobId);
	
	public boolean updatePost(int jobId,JobPostDetails jobPostDetails);
	
	public boolean deleteJobPost(int jobId);

	public List<JobPostDetails> getAllJobPost();

}
