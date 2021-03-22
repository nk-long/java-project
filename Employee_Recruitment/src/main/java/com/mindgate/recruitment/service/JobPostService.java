package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.JobPostDaoInterface;
import com.mindgate.recruitment.pojo.InterviewDetails;
import com.mindgate.recruitment.pojo.JobPostDetails;



@Service
public class JobPostService implements JobPostServiceInterface {

	@Autowired
	 private JobPostDaoInterface jobpostdao;
	
	@Override
	public boolean addPost(JobPostDetails jobPostDetails) {
		// TODO Auto-generated method stub
		return jobpostdao.addPost(jobPostDetails);
	}

	@Override
	public JobPostDetails getonepost(int jobId) {
		// TODO Auto-generated method stub
		return jobpostdao.getonepost(jobId);
	}

	@Override
	public boolean updatePost(int jobId, JobPostDetails jobPostDetails) {
		// TODO Auto-generated method stub
		return jobpostdao.updatePost(jobId,jobPostDetails);
	}

	@Override
	public boolean deleteJobPost(int postId) {
		// TODO Auto-generated method stub
		return jobpostdao.deleteJobPost(postId);
	}

	@Override
	public List<JobPostDetails> getAllJobPost() {
				return jobpostdao.getAllJobPosts();
	}

	

}