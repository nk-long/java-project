package com.mindgate.recruitment.pojo;

import org.springframework.stereotype.Component;

@Component
public class AssesmentDetails {

	private int assesmentId;
	private ApplicationDetails applicationDetails;
	private InterviewDetails interviewerDetails;
	private String interviewStatus;
	private String remark;

	public AssesmentDetails() {
	}

	public AssesmentDetails(int assesmentId, ApplicationDetails applicationDetails, InterviewDetails interviewerDetails,
			String interviewStatus, String remark) {

		this.assesmentId = assesmentId;
		this.applicationDetails = applicationDetails;
		this.interviewerDetails = interviewerDetails;
		this.interviewStatus = interviewStatus;
		this.remark = remark;
	}

	public int getAssesmentId() {
		return assesmentId;
	}

	public void setAssesmentId(int assesmentId) {
		this.assesmentId = assesmentId;
	}

	public ApplicationDetails getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(ApplicationDetails applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public InterviewDetails getInterviewerDetails() {
		return interviewerDetails;
	}

	public void setInterviewerDetails(InterviewDetails interviewerDetails) {
		this.interviewerDetails = interviewerDetails;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AssesmentDetails [assesmentId=" + assesmentId + ", applicationDetails=" + applicationDetails
				+ ", interviewerDetails=" + interviewerDetails + ", interviewStatus=" + interviewStatus + ", remark="
				+ remark + ", toString()=" + super.toString() + "]";
	}

}
