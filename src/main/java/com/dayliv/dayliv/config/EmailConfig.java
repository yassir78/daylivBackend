package com.dayliv.dayliv.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig 
{
	@Bean
	public SimpleMailMessage emailTemplate()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("belkoweb9718@gmail.com");
		message.setFrom("admin@gmail.com");
		message.setSubject("Important email");
	    message.setText("FATAL - Application crash. Save your job !!");
	    return message;
	}
}