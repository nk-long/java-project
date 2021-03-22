package com.mindgate.recruitment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.recruitment.pojo.EmployeeDetails;
import com.mindgate.recruitment.pojo.ProjectDetails;
import com.mindgate.recruitment.pojo.RequestDetails;

@Repository
public class RequestDetailsDAO implements RequestDetailsDAOInterface {

	@Autowired
	ProjectDetailsDao projectDetailsDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String ADD_REQUEST = "INSERT INTO Request_master(Request_Id,specialization,project_id,no_of_required_employee,qualification,request_status)VALUES(request_seq.nextval,?,?,?,?,?,?)";
	//private static String ADD_REQUEST = "INSERT INTO Request_master VALUES(request_seq.nextval,?,?,?,?,?)";
	private static String UPDATE_REQUEST = "UPDATE Request_master SET  specialization=?,project_Id=?,no_of_required_employee=?,qualification=?,request_status=? where request_Id=?";

	private static String DELETE_REQUEST = "DELETE FROM Request_master WHERE request_Id=?";

	private static String GET_REQUEST = "SELECT * FROM Request_master WHERE request_Id=?";

	private static String GET_ALL_REQUEST = "SELECT * FROM Request_master";
	
	private static String VIEW_REQ_FWD_HR="select * from Request_master where request_status='sent to hr'";

	@Override
	public boolean addRequest(RequestDetails requestDetails) {
		System.out.println("inside addrequest method");
		jdbcTemplate.update(ADD_REQUEST,
			requestDetails.getSpecialization(),
				requestDetails.getProjectdetails().getProjectId(),
				requestDetails.getNoOfRequiredEmployee(), requestDetails.getQualification(),
				requestDetails.getRequestSatus());
		return true;
	}

	public boolean updateRequest(int requestId,RequestDetails requestDetails) {
		jdbcTemplate.update(UPDATE_REQUEST, 
				requestDetails.getSpecialization(), requestDetails.getProjectdetails().getProjectId(),
				requestDetails.getQualification(), requestDetails.getNoOfRequiredEmployee(),requestDetails.getQualification(),requestDetails.getRequestSatus(), requestId);
		return true;
	}

	@Override
	public boolean deleteRequest(int requestId) {

		jdbcTemplate.update(DELETE_REQUEST, requestId);
		return true;
	}

	@Override
	public RequestDetails getRequest(int requestId) {

		RequestDetails requestDetails = jdbcTemplate.queryForObject(GET_REQUEST, new RequestRowMapper(), requestId);

		return requestDetails;
	}

	@Override
	public List<RequestDetails> getAllRequest() {
		List<RequestDetails> requestDetailslist = jdbcTemplate.query(GET_ALL_REQUEST, new RequestRowMapper());

		return requestDetailslist;
	}
	
	public List<RequestDetails> getAllRequestToHr()
	{
		List<RequestDetails> requestDetailslist = jdbcTemplate.query(VIEW_REQ_FWD_HR, new RequestRowMapper());

		return requestDetailslist;
		
	}

	class RequestRowMapper implements RowMapper<RequestDetails> {

		@Override
		public RequestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			RequestDetails requestDetails = new RequestDetails();


			ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsByprojectId(rs.getString("project_id"));
			requestDetails.setProjectdetails(projectDetails);
			requestDetails.setRequestId(rs.getInt("request_Id"));
			requestDetails.setSpecialization(rs.getString("specialization"));
			requestDetails.setNoOfRequiredEmployee(rs.getInt("no_of_required_employee"));
			requestDetails.setQualification(rs.getString("qualification"));
			requestDetails.setRequestSatus(rs.getString("request_status"));

			return requestDetails;
		}

	}
}
