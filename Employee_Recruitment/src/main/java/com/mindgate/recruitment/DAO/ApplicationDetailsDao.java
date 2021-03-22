package com.mindgate.recruitment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.recruitment.pojo.ApplicationDetails;
import com.mindgate.recruitment.pojo.ProjectDetails;
import com.mindgate.recruitment.pojo.RequestDetails;

@Repository
public class ApplicationDetailsDao implements ApplicationDetailsDAOInterface {

	@Autowired
	RequestDetailsDAO requestDetailsDAO;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static String Add_Application = "insert into application_master values (application_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static String Select_All_Applications = "select * from application_master";
	private static String Select_Application_ById = "select * from application_master where APPLICATION_ID=?";
	private static String Delete_Application = "delete from application_master where application_Id=?";
	private static String update_ApplicationDetails = "update application_master set firstName = ? , lastName = ? , dateOfBirth = ? , gender = ?, city = ?, state = ? ,  pincode = ? , country = ?,  emailId = ? ,  phoneNo = ? , sscMarks = ? ,hhcMarks = ? ,  degree = ? ,  degreeSpecialization = ?, specialization = ?  ,  expectedSalary = ? ,  experience = ? where applicationId=?";

	@Override
	public boolean addApplication(ApplicationDetails applicationDetails) 
	{
		jdbcTemplate.update(Add_Application, applicationDetails.getFirstName(),
				applicationDetails.getLastName(), applicationDetails.getDateOfBirth(), applicationDetails.getGender(),
				applicationDetails.getCity(), applicationDetails.getState(), applicationDetails.getPincode(),
				applicationDetails.getCountry(), applicationDetails.getEmailId(), applicationDetails.getPhoneNo(),
				applicationDetails.getSscMarks(), applicationDetails.getHhcMarks(), applicationDetails.getDegree(),
				applicationDetails.getDegreeSpecialization(), applicationDetails.getSpecialization(),
				applicationDetails.getExpectedSalary(),
				applicationDetails.getExperience());

		return true;
	}

	@Override
	public boolean updateApplication(int applicationId, ApplicationDetails applicationDetails)
	{
		jdbcTemplate.update(update_ApplicationDetails, 
				applicationDetails.getFirstName(), applicationDetails.getLastName(),
				applicationDetails.getDateOfBirth(), applicationDetails.getGender(), applicationDetails.getCity(),
				applicationDetails.getState(), applicationDetails.getPincode(), applicationDetails.getCountry(),
				applicationDetails.getEmailId(), applicationDetails.getPhoneNo(), applicationDetails.getSscMarks(),
				applicationDetails.getHhcMarks(), applicationDetails.getDegree(),
				applicationDetails.getDegreeSpecialization(), applicationDetails.getSpecialization(),
				 applicationDetails.getExpectedSalary(),
				applicationDetails.getExperience(),applicationId);
		return true;
	}

	@Override
	public boolean deleteApplication(int applicationId) {
		jdbcTemplate.update(Delete_Application, applicationId);
		return true;
	}

	@Override
	public ApplicationDetails getApplicationDetailsByapplicationId(int applicationId) {
		logger.info("in getApplicationDetailsByapplicationId :: " + applicationId);
		ApplicationDetails applicationDetails = jdbcTemplate.queryForObject(Select_Application_ById,
				new ApplicationRowMapper(), applicationId);
		return applicationDetails;
	}

	@Override
	public List<ApplicationDetails> getAllApplicationDetails() {
		logger.info("in getAllApplicationDetails");
		List<ApplicationDetails> applicationdetails = jdbcTemplate.query(Select_All_Applications,
				new ApplicationRowMapper());

		return applicationdetails;
	}

	class ApplicationRowMapper implements RowMapper<ApplicationDetails> {



		@Override
		public ApplicationDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			ApplicationDetails applicationDetails = new ApplicationDetails();
			
			applicationDetails.setApplicationId(rs.getInt("APPLICATION_ID"));
			applicationDetails.setFirstName(rs.getString("first_name"));
			applicationDetails.setLastName(rs.getString("last_name"));
			applicationDetails.setDateOfBirth(rs.getDate("Date_Of_Birth"));
			applicationDetails.setGender(rs.getString("gender"));
			applicationDetails.setCity(rs.getString("city"));
			applicationDetails.setState(rs.getString("state"));
			applicationDetails.setPincode(rs.getInt("pincode"));
			applicationDetails.setCountry(rs.getString("country"));
			applicationDetails.setEmailId(rs.getString("email_id"));
			applicationDetails.setPhoneNo(rs.getDouble("phone_no"));
			applicationDetails.setSscMarks(rs.getInt("SSC_Marks"));
			applicationDetails.setHhcMarks(rs.getInt("HSC_marks"));
			applicationDetails.setDegree(rs.getDouble("Degree"));
			applicationDetails.setDegreeSpecialization(rs.getString("Degree_specialization"));
			applicationDetails.setSpecialization(rs.getString("specialization"));
			applicationDetails.setExpectedSalary(rs.getInt("expected_salary"));
			applicationDetails.setExperience(rs.getString("experience"));

			logger.info(applicationDetails.toString());
			return applicationDetails;
		}

	}

}
