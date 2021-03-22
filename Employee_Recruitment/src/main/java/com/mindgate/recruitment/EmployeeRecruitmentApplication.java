package com.mindgate.recruitment;

// import java.io.IOException;
// import javax.mail.MessagingException;
// import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;


@SpringBootApplication
public class EmployeeRecruitmentApplication {
	@Autowired
	//private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(EmployeeRecruitmentApplication.class, args);
		System.out.println("End");
	}
	
	// @Override
	// public void run(String... args) {
	// 	System.out.println("Sending email to the user..");

	// 	emailSend();

	// 	System.out.println("Email sent done please check your Email..");

	// }

	// void emailSend() {
	// 	SimpleMailMessage message = new SimpleMailMessage();

	// 	// receiver user mail here
	// 	message.setTo("devbst11@gmail.com");
	// 	message.setSubject("Testing of project email by springboot");
	// 	message.setText("Hello Please check your mail \n I have sent you email ");
	// 	javaMailSender.send(message);
	// }

	// void emailSendWithAttachement() throws MessagingException, IOException {
	// 	MimeMessage message1 = javaMailSender.createMimeMessage();
	// 	// true = multipart mesage

	// 	MimeMessageHelper helper = new MimeMessageHelper(message1, true);
	// 	helper.setTo("projectnotifecations@gmail.com");
	// 	helper.setSubject("Testing of email useing springboot");

	// 	helper.setText("<h1> Check attachement for image ! </h1>", true);
	// 	helper.addAttachment("hrpanel.png", new ClassPathResource("‪C:\\Users\\Asma Shaikh\\Desktop\\hrpanel.png"));

	// 	javaMailSender.send(message1);

	// }
}
