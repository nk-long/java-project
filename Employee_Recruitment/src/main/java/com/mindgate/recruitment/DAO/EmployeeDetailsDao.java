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

@Repository
public class EmployeeDetailsDao implements EmployeeDetailsDAOInterface {

	@Autowired
	ProjectDetailsDao projectDetailsDao;
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	private static String addEmployeeSql = "insert into Employee_Master(EMPLOYEE_ID,employee_Name,designation,SPECIALIZATION,salary,username,user_password,project_Id,contact_No,email_Id,address,gender) values(employee_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";

	private static String getOneEmployeeSql = "select * FROM Employee_Master where EMPLOYEE_ID=?";

	private static String updateEmployeeSql = "update Employee_Master set employee_Name=?,designation=?,SPECIALIZATION=?,salary=?,username=?,user_password=?,project_Id=?,contact_No=?,email_Id=?,address=?,gender=? where employee_id=?";

	private static String deleteEmployeeSql = "delete from Employee_Master where employee_Id=?";

	private static String getAllEmployeeSql = "select * from Employee_Master";

	private static String login="select * from Employee_Master where username=? and user_password=?";
	@Override
	public boolean addEmployee(EmployeeDetails employeeMaster) {
		int result = jdbctemplate.update(addEmployeeSql, employeeMaster.getEmployeeName(),
				employeeMaster.getDesignation(), employeeMaster.getSpecilization(), employeeMaster.getSalary(),
				employeeMaster.getUserName(), employeeMaster.getUserPassword(),
				employeeMaster.getProjectDetails().getProjectId(), employeeMaster.getContactNo(),
				employeeMaster.getEmailId(), employeeMaster.getAddress(), employeeMaster.getGender());
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateEmployee(EmployeeDetails employeeMaster) {
		int result = jdbctemplate.update(updateEmployeeSql, employeeMaster.getEmployeeName(),
				employeeMaster.getDesignation(), employeeMaster.getSpecilization(), employeeMaster.getSalary(),
				employeeMaster.getUserName(), employeeMaster.getUserPassword(),
				employeeMaster.getProjectDetails().getProjectId(), employeeMaster.getContactNo(),
				employeeMaster.getEmailId(), employeeMaster.getAddress(), employeeMaster.getGender(),
				employeeMaster.getEmployeeId());

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public EmployeeDetails getOneEmployee(int employeeId) {
		System.out.println("getOneEmployee()");
		System.out.println(employeeId);
		EmployeeDetails employeeMaster = jdbctemplate.queryForObject(getOneEmployeeSql, new EmployeeMasterMapper(),
				employeeId);
		return employeeMaster;
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> empmaster = jdbctemplate.query(getAllEmployeeSql, new EmployeeMasterMapper());
		return empmaster;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		int ressult = jdbctemplate.update(deleteEmployeeSql, employeeId);
		if (ressult == 1) {
			return true;
		}

		return false;
	}

	class EmployeeMasterMapper implements RowMapper<EmployeeDetails> {

		@Override
		public EmployeeDetails mapRow(ResultSet rs, int arg1) throws SQLException {
			

			ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsByprojectId(rs.getString("PROJECT_ID"));
			System.out.println(projectDetails);
			
			EmployeeDetails em = new EmployeeDetails();
			em.setEmployeeId(rs.getDouble("EMPLOYEE_ID"));
			em.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
			em.setDesignation(rs.getString("DESIGNATION"));
			em.setSpecilization(rs.getString("SPECIALIZATION"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setUserName(rs.getString("username"));
			em.setUserPassword(rs.getString("USER_PASSWORD"));
			em.setProjectDetails(projectDetails);
			em.setContactNo(rs.getDouble("CONTACT_NO"));
			em.setEmailId(rs.getString("EMAIL_ID"));
			em.setAddress(rs.getString("ADDRESS"));
			em.setGender(rs.getString("GENDER"));
			
			System.out.println(em);
			return em;
		}

	}

	@Override
	public EmployeeDetails userLogin(EmployeeDetails employeeDetails) {

		System.out.println("in dao login method");
		
		EmployeeDetails employee= jdbctemplate.queryForObject(login, new EmployeeMasterMapper(), employeeDetails.getUserName(),employeeDetails.getUserPassword());
		
		return employee;
	}

}