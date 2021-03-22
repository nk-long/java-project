package com.mindgate.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.recruitment.pojo.InterviewDetails;
import com.mindgate.recruitment.service.InterviewDetailsServiceInterface;

@RestController
@CrossOrigin
@RequestMapping(value="/interviewerDetails")
public class InterviewDetailsController {

	
	private  final Logger log= LoggerFactory.getLogger(this.getClass());

	@Autowired
	InterviewDetailsServiceInterface interviewerDetails;
	
	//http://localhost:8082/requestDetails/addrequest
		@RequestMapping(value="/addinterviewer" , method=RequestMethod.POST)
		
		public boolean addInterviewer(@RequestBody InterviewDetails interviewer)
		{
			log.info("addInterviewer");	
			return interviewerDetails.addInterviewer(interviewer);
		}
		
		
		@RequestMapping(value="/updateinterviewer/{interviewId}" , method=RequestMethod.PUT)

		public boolean updaterequest(@PathVariable int interviewId,@RequestBody InterviewDetails interviewer) {
			
			log.info("updaterequest");	
			return interviewerDetails.updaterequest(interviewId,interviewer);
		}
		
		@RequestMapping(value="{interviewId}" , method=RequestMethod.DELETE)

		public boolean deleteInterViewer(@PathVariable int interviewId) {
			
			log.info("deleteInterViewer");	
			return interviewerDetails.deleteInterViewer(interviewId);

		}
		@RequestMapping(value="{interviewId}" , method=RequestMethod.GET)

		public InterviewDetails getInterViewer(@PathVariable int interviewId) {
			
			log.info("getInterViewer");	
			return interviewerDetails.getInterViewer(interviewId);

		}
		
		@RequestMapping(value="/getAllInterviewer" , method=RequestMethod.GET)

		public List<InterviewDetails> getAllInterViewer() {
			
			log.info("getAllInterViewer");	
			return interviewerDetails.getAllInterViewer();

		}
		
		
}