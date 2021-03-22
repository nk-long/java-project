package com.mindgate.recruitment.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ApplicationDetails {
	private int applicationId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String city;
	private String state;
	private int pincode;
	private String country;
	private String emailId;
	private double phoneNo;
	private double sscMarks;
	private double hhcMarks;
	private double degree;
	private String degreeSpecialization;
	private String specialization;
	private int expectedSalary;
	private String experience;

	public ApplicationDetails() {
		// TODO Auto-generated constructor stub
	}

		public ApplicationDetails(int applicationId, String firstName, String lastName, Date dateOfBirth, String gender,
			String city, String state, int pincode, String country, String emailId, double phoneNo, double sscMarks,
			double hhcMarks, double degree, String degreeSpecialization, String specialization, int expectedSalary,
			String experience) {
		super();
		this.applicationId = applicationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.sscMarks = sscMarks;
		this.hhcMarks = hhcMarks;
		this.degree = degree;
		this.degreeSpecialization = degreeSpecialization;
		this.specialization = specialization;
		this.expectedSalary = expectedSalary;
		this.experience = experience;
	}

		
	public int getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(int applicationId) {
			this.applicationId = applicationId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public double getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(double phoneNo) {
			this.phoneNo = phoneNo;
		}

		public double getSscMarks() {
			return sscMarks;
		}

		public void setSscMarks(double sscMarks) {
			this.sscMarks = sscMarks;
		}

		public double getHhcMarks() {
			return hhcMarks;
		}

		public void setHhcMarks(double hhcMarks) {
			this.hhcMarks = hhcMarks;
		}

		public double getDegree() {
			return degree;
		}

		public void setDegree(double degree) {
			this.degree = degree;
		}

		public String getDegreeSpecialization() {
			return degreeSpecialization;
		}

		public void setDegreeSpecialization(String degreeSpecialization) {
			this.degreeSpecialization = degreeSpecialization;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public int getExpectedSalary() {
			return expectedSalary;
		}

		public void setExpectedSalary(int expectedSalary) {
			this.expectedSalary = expectedSalary;
		}

		public String getExperience() {
			return experience;
		}

		public void setExperience(String experience) {
			this.experience = experience;
		}

		@Override
		public String toString() {
			return "ApplicationDetails [applicationId=" + applicationId + ", firstName=" + firstName + ", lastName="
					+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", city=" + city + ", state="
					+ state + ", pincode=" + pincode + ", country=" + country + ", emailId=" + emailId + ", phoneNo="
					+ phoneNo + ", sscMarks=" + sscMarks + ", hhcMarks=" + hhcMarks + ", degree=" + degree
					+ ", degreeSpecialization=" + degreeSpecialization + ", specialization=" + specialization
					+ ", expectedSalary=" + expectedSalary + ", experience=" + experience + "]";
		}

	
	


}