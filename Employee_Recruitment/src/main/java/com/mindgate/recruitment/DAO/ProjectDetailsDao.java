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

import com.mindgate.recruitment.pojo.ProjectDetails;

@Repository
public class ProjectDetailsDao implements ProjectDetailsDAOInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static String Add_Project = "insert into project_master values (?,?,?,?,?)";
	private static String Select_All_Projects = "select * from project_master";
	private static String Select_Project_ById = "select * from project_master where project_Id=?";
	private static String Delete_Project = "delete from project_master where project_Id=?";
	private static String update_ProjectDetails = "update project_master set project_Name = ? , max_Strength = ? , assigned_Strength = ? , specialization = ? where project_Id=?";

	@Override
	public boolean addProject(ProjectDetails projectDetails)
	{
		jdbcTemplate.update(Add_Project, projectDetails.getProjectId(), projectDetails.getProjectName(),
				projectDetails.getMaxStrength(), projectDetails.getAssignedStrength(),
				projectDetails.getSpecialization());

		return true;
	}

	@Override
	public boolean updateProject(String projectId, ProjectDetails projectDetails) 
	{
		jdbcTemplate.update(update_ProjectDetails,  projectDetails.getProjectName(),
				projectDetails.getMaxStrength(), projectDetails.getAssignedStrength(),
				projectDetails.getSpecialization() ,projectDetails.getProjectId());
		return true;
	}

	@Override
	public boolean deleteProject(String projectId) {
		jdbcTemplate.update(Delete_Project, projectId);

		return true;
	}

	@Override
	public ProjectDetails getProjectDetailsByprojectId(String projectId) {
		System.out.println("ProjectDetails :: " + projectId);
		System.out.println("in getProjectDetailsByprojectId");
		ProjectDetails projectDetails = jdbcTemplate.queryForObject(Select_Project_ById, new ProjectRowMapper(),
				projectId);
		return projectDetails;
	}

	@Override
	public List<ProjectDetails> getAllProjectDetails() {
		return jdbcTemplate.query(Select_All_Projects, new ProjectRowMapper());

	}

	private final static class ProjectRowMapper implements RowMapper<ProjectDetails> {

		@Override
		public ProjectDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			ProjectDetails projectDetails = new ProjectDetails();
			projectDetails.setProjectId(rs.getString("project_Id"));
			projectDetails.setProjectName(rs.getString("project_Name"));
			projectDetails.setMaxStrength(rs.getInt("max_Strength"));
			projectDetails.setAssignedStrength(rs.getInt("assigned_Strength"));
			projectDetails.setSpecialization(rs.getString("specialization"));

			System.out.println(projectDetails);

			return projectDetails;
		}

	}

}
