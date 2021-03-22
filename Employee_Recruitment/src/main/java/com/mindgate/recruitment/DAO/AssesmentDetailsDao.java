package com.mindgate.recruitment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.recruitment.pojo.ApplicationDetails;
import com.mindgate.recruitment.pojo.AssesmentDetails;
import com.mindgate.recruitment.pojo.InterviewDetails;

@Repository
public class AssesmentDetailsDao implements AssesmentDetailsDaoInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ApplicationDetailsDao applicationDetailsDAO;
	@Autowired
	private InterviewDeatailsDAO interviewDeatailsDAO;

	private static String SELECTALL = "select * from  assesment_report_master";
	private static String INSERT = "insert into assesment_report_master(assesment_id,application_id,interview_id,interview_status,remark) values(assesment_report_seq.nextval,?,?,?,?)";
	private static String UPDATE = "update assesment_report_master set application_id=?,interview_id=?,interview_status=?,remark=? where assesment_id=?";
	private static String DELETE = "delete from assesment_report_master where assesment_id=?";
	private static String GETASSESMENT = "select * from assesment_report_master where assesment_id=?";

	@Override
	public List<AssesmentDetails> getAllInterviewer() {
		List<AssesmentDetails> assesmentDetailsList = jdbcTemplate.query(SELECTALL, new AssesmentRowMapper());
		return assesmentDetailsList;
	}

	@Override
	public boolean updateAssement(int assesmentId,AssesmentDetails assesmentDetails)
	{
		jdbcTemplate.update(UPDATE, 
				assesmentDetails.getApplicationDetails().getApplicationId(),
				assesmentDetails.getInterviewerDetails().getInterviewId(), assesmentDetails.getInterviewStatus(),
				assesmentDetails.getRemark(),assesmentId);
		return true;
	}

	@Override
	public boolean addAssement(AssesmentDetails assesmentDetails)
	{
		jdbcTemplate.update(INSERT,
				assesmentDetails.getApplicationDetails().getApplicationId(),
				assesmentDetails.getInterviewerDetails().getInterviewId(), assesmentDetails.getInterviewStatus(),
				assesmentDetails.getRemark());

		return true;
	}

	@Override
	public boolean deleteAssement(int assesmentId) {
		jdbcTemplate.update(DELETE, assesmentId);
		return true;
	}

	@Override
	public AssesmentDetails getAssement(int assesmentId) {
		AssesmentDetails assesmentDetails = jdbcTemplate.queryForObject(GETASSESMENT, new AssesmentRowMapper(),
				assesmentId);
		return assesmentDetails;

	}
	class AssesmentRowMapper implements RowMapper<AssesmentDetails> {

		@Override
		public AssesmentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			AssesmentDetails assesmentDetails = new AssesmentDetails();
			assesmentDetails.setAssesmentId(rs.getInt("ASSESMENT_ID"));
			ApplicationDetails applicationDetails = applicationDetailsDAO.getApplicationDetailsByapplicationId(rs.getInt("Application_id"));
			assesmentDetails.setApplicationDetails(applicationDetails);

			InterviewDetails interviewDetails = interviewDeatailsDAO.getInterView(rs.getInt("INTERVIEW_ID"));
			assesmentDetails.setInterviewerDetails(interviewDetails);

			assesmentDetails.setInterviewStatus(rs.getString("interview_status"));
			assesmentDetails.setRemark(rs.getString("remark"));

			return assesmentDetails;
		}
	}
}
