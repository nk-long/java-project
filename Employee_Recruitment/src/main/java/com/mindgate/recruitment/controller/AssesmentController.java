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

import com.mindgate.recruitment.pojo.AssesmentDetails;
import com.mindgate.recruitment.service.AssesmentServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "/AssesmentCRUD")
public class AssesmentController {
	
	private  final Logger log= LoggerFactory.getLogger(this.getClass());


	@Autowired
	private AssesmentServiceInterface assesmentServiceInterface;

	@RequestMapping(value = "/getAllAssesment", method = RequestMethod.GET)
	public List<AssesmentDetails> getAllInterviewer() {
		
		log.info("getAllAssesment");
		return assesmentServiceInterface.getAllInterviewer();
	}

	@RequestMapping(value = "/updateAssesment/{assesmentId}", method = RequestMethod.PUT)

	public boolean updateAssement(@PathVariable int assesmentId,@RequestBody AssesmentDetails assesmentDetails) {

		log.info("updateAssement");
		return assesmentServiceInterface.updateAssement(assesmentId,assesmentDetails);
	}

	@RequestMapping(value = "/addAssesment", method = RequestMethod.POST)

	public boolean addAssement(@RequestBody AssesmentDetails assesmentDetails) {
		log.info("AssesmentDetails");
		return assesmentServiceInterface.addAssement(assesmentDetails);
	}

	@RequestMapping(value = "/{assesmentId}", method = RequestMethod.DELETE)
	public boolean deleteAssement(@PathVariable int assesmentId) {
		log.info("deleteAssement");

		return assesmentServiceInterface.deleteAssement(assesmentId);
	}

	@RequestMapping(value = "/{assesmentId}", method = RequestMethod.GET)
	public AssesmentDetails getAssement(@PathVariable int assesmentId) {
		log.info("getAssement");

		return assesmentServiceInterface.getAssement(assesmentId);
	}

}
