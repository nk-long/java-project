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

import com.mindgate.recruitment.pojo.RequestDetails;
import com.mindgate.recruitment.service.RequestDetailsServiceInterface;


@RestController
@CrossOrigin
@RequestMapping(value="requestDetails")
public class RequestDetailsController {
	
	private  final Logger log= LoggerFactory.getLogger(this.getClass());


	@Autowired
	private RequestDetailsServiceInterface serviceInterface;
	
	@RequestMapping(value="/addrequest" , method=RequestMethod.POST)
	public boolean addRequest(@RequestBody RequestDetails requestDetails) {
		log.info("addRequest");	
		return serviceInterface.addRequest(requestDetails);
	}
	
	@RequestMapping(value="/update/{requestId}" , method=RequestMethod.PUT)
	public boolean updaterequest(@PathVariable int requestId, @RequestBody RequestDetails requestDetails) {
		log.info("updaterequest");	
		return serviceInterface.updateRequest(requestId,requestDetails);
	}
	
	@RequestMapping(value="{requestId}" , method=RequestMethod.DELETE)
	public boolean deleteRequest(@PathVariable int requestId) {
		log.info("deleteRequest");	

		return serviceInterface.deleteRequest(requestId);
	}
	
	@RequestMapping(value="{requestId}" , method=RequestMethod.GET)
	public RequestDetails getRequest(@PathVariable int requestId) {
		log.info("getRequest");	

		return serviceInterface.getRequest(requestId);
	}
	
	
	@RequestMapping(value="/getAllRequest" , method=RequestMethod.GET)
	public List<RequestDetails> getAllRequest(RequestDetails requestDetails) {
		log.info("getAllRequest");	

		return serviceInterface.getAllRequest();
	}
	
	@RequestMapping(value="/getAllRequestToHr", method = RequestMethod.GET)
	public List<RequestDetails> getAllRequestToHr(RequestDetails requestDetails) {
		log.info("in  getAllRequestToHr ");
		return serviceInterface.getAllRequestToHr();
		
	}


}
