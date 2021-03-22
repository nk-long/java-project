package com.mindgate.recruitment.DAO;

import java.util.List;

import com.mindgate.recruitment.pojo.AssesmentDetails;

public interface AssesmentDetailsDaoInterface {

	public List<AssesmentDetails> getAllInterviewer();

	public boolean updateAssement(int assesmentId,AssesmentDetails assesmentDetails);

	public boolean addAssement(AssesmentDetails assesmentDetails);

	public boolean deleteAssement(int assesmentId);

	public AssesmentDetails getAssement(int assesmentId);

}
