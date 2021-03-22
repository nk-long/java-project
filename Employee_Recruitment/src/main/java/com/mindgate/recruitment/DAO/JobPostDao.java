package com.mindgate.recruitment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.recruitment.DAO.InterviewDeatailsDAO.InterViewerRowMapper;
import com.mindgate.recruitment.pojo.InterviewDetails;
import com.mindgate.recruitment.pojo.JobPostDetails;



@Repository
public class JobPostDao implements JobPostDaoInterface{
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private static String addPostSql = "insert into job_post_master(job_id,jobDescription,salary,qualification,specialization,jobLocation,experienced) values(job_post_seq.nextval,?,?,?,?,?,?)";
	
	private static String getOneJobPost = "select * from job_post_master where job_id=?";
	
	private static String updateJobPostSql = "update job_post_master set jobDescription=?,salary=?,qualification=?,specialization=?, jobLocation=?,experienced=? where job_id=?";

	private static String deleteJobPost = "delete from job_post_master where job_id=?";
	 
	private static String getAllJobPost = "select * from job_post_master";
	
	@Override
	public boolean addPost(JobPostDetails jobPostDetails) {
		System.out.println(jobPostDetails.toString());
		int result = jdbctemplate.update(addPostSql,jobPostDetails.getJobDescription(),jobPostDetails.getSalary(),
				jobPostDetails.getQualification(),jobPostDetails.getSpecialization(),jobPostDetails.getLocation(),jobPostDetails.getExperinece());
		if(result==1)
		{
			return true;
		}
		return false;
	}

	@Override
	public JobPostDetails getonepost(int jobId) {
		JobPostDetails details = jdbctemplate.queryForObject(getOneJobPost, new JobPostDetailMapper(), jobId);
		return details;
	}

	@Override
	public boolean updatePost(int jobId,JobPostDetails jobPostDetails) {
		int result = jdbctemplate.update(updateJobPostSql, jobPostDetails.getJobDescription(),jobPostDetails.getSalary(),jobPostDetails.getQualification(),jobPostDetails.getSpecialization(),jobPostDetails.getLocation(),jobPostDetails.getExperinece(),jobId);
		if(result==1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteJobPost(int jobId) {
		
		int result = jdbctemplate.update(deleteJobPost, jobId);
		if(result==1)
		{
			 return true;
		}
		
		return false;
	}
	
	class JobPostDetailMapper implements RowMapper<JobPostDetails>{

		@Override
		public JobPostDetails mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
			JobPostDetails jobPostDetails = new JobPostDetails();
			
			jobPostDetails.setJobId(rs.getInt("JOB_ID"));
			jobPostDetails.setJobDescription(rs.getString("JOBDESCRIPTION"));
			jobPostDetails.setSalary(rs.getInt("SALARY"));
			jobPostDetails.setQualification(rs.getString("QUALIFICATION"));
			jobPostDetails.setSpecialization(rs.getString("SPECIALIZATION"));
			jobPostDetails.setLocation(rs.getString("JOBLOCATION"));
			jobPostDetails.setExperinece(rs.getString("experienced"));
			
			// TODO Auto-generated method stub
			return jobPostDetails;
		}
		
	}

	@Override
	public List<JobPostDetails> getAllJobPosts() {
		List<JobPostDetails> jobPostDetails = jdbctemplate.query(getAllJobPost, new JobPostDetailMapper());

		return jobPostDetails;
	}

}
