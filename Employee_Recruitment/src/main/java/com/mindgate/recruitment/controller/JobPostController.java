package com.mindgate.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.recruitment.pojo.JobPostDetails;
import com.mindgate.recruitment.service.JobPostServiceInterface;


@RestController
@CrossOrigin
@RequestMapping("/jobpost")
public class JobPostController {

	private  final Logger log= LoggerFactory.getLogger(this.getClass());

	@Autowired
	JobPostServiceInterface jobPostServiceInterface;

	//http://localhost:8084/jobpost/
	@RequestMapping(value="/addJobPost",method=RequestMethod.POST)
	public boolean addPost(@RequestBody JobPostDetails jobPostDetails) {
		log.info("addPost");
		return jobPostServiceInterface.addPost(jobPostDetails);
	}

	@RequestMapping(value="/{postId}",method=RequestMethod.GET)
	public JobPostDetails getOnePost(@PathVariable int postId) {
		log.info("addPost");

		return jobPostServiceInterface.getonepost(postId);

	}

	@RequestMapping(value="/updateJobPost/{postId}",method=RequestMethod.PUT)
	public boolean updatePost(@PathVariable int postId,@RequestBody JobPostDetails jobPostDetails) {
		log.info("updatePost");

		return jobPostServiceInterface.updatePost(postId,jobPostDetails);
	}

	@RequestMapping(value="/{posId}",method=RequestMethod.DELETE)
	public boolean deletePost(@PathVariable int posId) {
		log.info("deletePost");

		return jobPostServiceInterface.deleteJobPost(posId);
	}
	
	@RequestMapping(value="/getAllJobPost",method=RequestMethod.GET)
	public List<JobPostDetails> getAllJobPost() {
		log.info("in getAllJobPost" );
		return jobPostServiceInterface.getAllJobPost();
}


}