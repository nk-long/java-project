package com.mindgate.recruitment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.recruitment.pojo.ApplicationDetails;
import com.mindgate.recruitment.pojo.EmployeeDetails;
import com.mindgate.recruitment.pojo.InterviewDetails;
import com.mindgate.recruitment.pojo.ProjectDetails;
import com.mindgate.recruitment.pojo.RequestDetails;

@Repository
public class InterviewDeatailsDAO implements InterviewDetailsDAOInterface {

	@Autowired
	EmployeeDetailsDao employeeDetailsDao;
	@Autowired
	ProjectDetailsDao projectDetailsDao;
	@Autowired
	ApplicationDetailsDao applicationDetailsDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String ADD_INTERVIEWER = "INSERT INTO interviewer_master VALUES(interview_seq.nextval,?,?,?,?,?)";

	private static String UPDATE_INTERVIEWER = "UPDATE interviewer_master SET employeeId=?,Application_id=?,project_id=?,interview_date=?,mode_of_interview=? where interview_id";

	private static String DELETE_INTERVIEWER = "DELETE FROM interviewer_master WHERE interview_id=?";

	private static String GET_INTERVIEWER = "SELECT * FROM interviewer_master WHERE interview_id=?";

	private static String GET_ALL_INTERVIEWER = "SELECT * FROM interviewer_master";

	public boolean addInterview(InterviewDetails interviewer) {

		jdbcTemplate.update(ADD_INTERVIEWER,
				interviewer.getEmployeeDetails().getEmployeeId(),
				interviewer.getApplicationDetails().getApplicationId(), interviewer.getProjectDetails().getProjectId(),
				interviewer.getInterviewDate(), interviewer.getModeOfInterview());

		return true;
	}

	public boolean updateInterview(int interviewId,InterviewDetails interviewer) {
		jdbcTemplate.update(UPDATE_INTERVIEWER, interviewer.getEmployeeDetails().getEmployeeId(),
				interviewer.getApplicationDetails().getApplicationId(), interviewer.getProjectDetails().getProjectId(),
				interviewer.getInterviewDate(), interviewer.getModeOfInterview(),interviewId);
		return true;
	}

	public boolean deleteInterview(int interviewId) {

		jdbcTemplate.update(DELETE_INTERVIEWER, interviewId);

		return true;
	}

	public InterviewDetails getInterView(int interviewId) {

		InterviewDetails interviewdetail = jdbcTemplate.queryForObject(GET_INTERVIEWER, new InterViewerRowMapper(),
				interviewId);

		return interviewdetail;
	}

	public List<InterviewDetails> getAllInterView() {
		List<InterviewDetails> requestDetailslist = jdbcTemplate.query(GET_ALL_INTERVIEWER, new InterViewerRowMapper());
		return requestDetailslist;
	}

	class InterViewerRowMapper implements RowMapper<InterviewDetails> {

		@Override
		public InterviewDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			EmployeeDetails empdetails = employeeDetailsDao.getOneEmployee(rs.getInt("employee_Id"));

			ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsByprojectId(rs.getString("project_id"));

			ApplicationDetails applicationDetails = applicationDetailsDao
					.getApplicationDetailsByapplicationId(rs.getInt("APPLICATION_ID"));

			InterviewDetails interviewdetail = new InterviewDetails();
			interviewdetail.setInterviewId(rs.getInt("interview_id"));
			interviewdetail.setEmployeeDetails(empdetails);
			interviewdetail.setProjectDetails(projectDetails);
			interviewdetail.setApplicationDetails(applicationDetails);
			interviewdetail.setInterviewDate(rs.getDate("interview_date"));
			interviewdetail.setModeOfInterview(rs.getString("mode_of_interview"));

			return interviewdetail;
		}
	}

}
