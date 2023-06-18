package com.atmosfera.feedback.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


@Service
public class FeedbackService {
	
	@Value("${mail.to}")
	private String emailTo;
	
	@Value("${mail.from}")
	private String emailFrom;
	
	@Value("${mail.from.pass}")
	private String emailFromPassword;
	private String clientNameValue;
	private String messageText;
	
	public void callback(String phoneNumber, String clientName) {
		clientNameValue = clientName.replaceAll("\\{\"clientName\":\"", "");
		clientNameValue = clientNameValue.replaceAll("\"\\}", "");
		
		messageText = "Номер клиента:  " + phoneNumber + "\n" + "Имя клиента:  " + clientNameValue;
		SendMessage("", messageText);
	}
	
    private void SendMessage(String fail, String messageText) {
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.yandex.ru");
        p.put("mail.smtp.socketFactory.port", 465);
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", 465);

        Session s = Session.getInstance(p,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailFrom, emailFromPassword);

                    }
                }
        );

        Message message = new MimeMessage(s);
        try {
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject("Заявка с atmosfera18.ru");
            message.setText(messageText);
            Transport.send(message);

        }
        catch(Exception e) {
        	
        	System.out.println(e.getMessage());
        	
        }
    }
	
}
