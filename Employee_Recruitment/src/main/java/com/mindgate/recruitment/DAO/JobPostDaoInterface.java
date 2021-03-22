package com.mindgate.recruitment.DAO;

import java.util.List;

import com.mindgate.recruitment.pojo.JobPostDetails;

public interface JobPostDaoInterface {
public boolean addPost(JobPostDetails jobPostDetails);
	
	public JobPostDetails getonepost(int jobId);
	
	public boolean updatePost(int jobId,JobPostDetails jobPostDetails);
	
	public boolean deleteJobPost(int jobId);
	public List<JobPostDetails> getAllJobPosts();

}
