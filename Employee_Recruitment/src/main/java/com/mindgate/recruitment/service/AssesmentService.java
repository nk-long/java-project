package com.mindgate.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.recruitment.DAO.AssesmentDetailsDao;
import com.mindgate.recruitment.pojo.AssesmentDetails;

@Service
public class AssesmentService implements AssesmentServiceInterface {

	@Autowired
	private AssesmentDetailsDao assesmentDetailsDao;

	@Override
	public List<AssesmentDetails> getAllInterviewer() {

		return assesmentDetailsDao.getAllInterviewer();
	}

	@Override
	public boolean updateAssement(int assesmentId,AssesmentDetails assesmentDetails) {

		return assesmentDetailsDao.updateAssement(assesmentId,assesmentDetails);
	}

	@Override
	public boolean addAssement(AssesmentDetails assesmentDetails) {
		return assesmentDetailsDao.addAssement(assesmentDetails);
	}

	@Override
	public boolean deleteAssement(int assesmentId) {
		return assesmentDetailsDao.deleteAssement(assesmentId);
	}

	@Override
	public AssesmentDetails getAssement(int assesmentId) {

		return assesmentDetailsDao.getAssement(assesmentId);
	}

}
