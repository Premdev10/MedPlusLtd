package com.medplus.dao;

import java.util.Properties;
import  java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import javax.activation.*;


public class EmailSender {
	public static void sendEmail(){
		String to="medplusltdmnc@gmail.com";
		System.out.println("email "+to);
		String from="nidhin736@gmail.com"; // Email from send
		String password="777444777nidhin"; // Password of email

		//Get the session object 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class", 
		"javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "465"); 

		Session session = Session.getDefaultInstance(props, 
		new javax.mail.Authenticator() { 
		protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(from,password);
		} 
		}); 

		
		try { 
		MimeMessage message = new MimeMessage(session); 
		message.setFrom(new InternetAddress(from)); 
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
		message.setSubject("New Mail ....."); 
		message.setText("Dear subscriber,"
				+ "this is an email to inform"); // message
		
		//send message 
		Transport.send(message); 

		System.out.println("message sent successfully"); 

		} catch (MessagingException e) {throw new RuntimeException(e);} 

		

}
}