package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.RequestDetailsDAOInterface;
import com.mindgate.recruitment.pojo.RequestDetails;

@Service
public class RequestDetailsService implements RequestDetailsServiceInterface{

	@Autowired
	private RequestDetailsDAOInterface requestmasterInterface;

	@Override
	public boolean addRequest(RequestDetails requestDetails) {

		return requestmasterInterface.addRequest(requestDetails);
		
		
	}

	@Override
	public boolean updateRequest(int requestId,RequestDetails requestDetails) {

		
		return requestmasterInterface.updateRequest(requestId,requestDetails);
	}

	@Override
	public boolean deleteRequest(int requestId) {
		

		return requestmasterInterface.deleteRequest(requestId);
	}

	@Override
	public RequestDetails getRequest(int requestId) {
		

		return requestmasterInterface.getRequest(requestId);
	}

	@Override
	public List<RequestDetails> getAllRequest() {
		
		return requestmasterInterface.getAllRequest();
	}

	@Override
	public List<RequestDetails> getAllRequestToHr() {
		return requestmasterInterface.getAllRequestToHr();
	}

}
