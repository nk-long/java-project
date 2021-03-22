package com.mindgate.recruitment.service;

import java.util.List;

import com.mindgate.recruitment.pojo.RequestDetails;

public interface RequestDetailsServiceInterface {
	public boolean addRequest(RequestDetails requestDetails);

	public boolean updateRequest(int requestId,RequestDetails requestDetails);
	
	public boolean deleteRequest(int requestId);
	
	public RequestDetails getRequest(int requestId);
	
	public List<RequestDetails> getAllRequest();
	
	public List<RequestDetails> getAllRequestToHr();

}
