package com.won.viewer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Emailer {
    public static void main(String[] args) {
        String to = "joshua.richardson@tlgcohort.com";
        // Mention the Sender's email address
        String from = "caleb.wise@tlgcohort.com";
        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
        String host = "smtp.office365.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("smtp.office365.com", "587");
//        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("joshua.richardson@tlgcohort.com", "password");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setText("This is actual message");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
//    Properties properties = new Properties(); // properties object contains host information
//
//    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication("joshua.richardson@tlgcohort.com", "password");
//        }
//
//
//        try{
//            MimeMessage message = new MimeMessage(session);
//            // Sender email
//            message.setFrom(new InternetAddress("Joshua Richardson"));
//            // Receiver email
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            // Email subject
//            message.setSubject("This is the email subject");
//            // Email body
//            message.setText("This is the email body");
//        } catch (MessagingException e){
//            throw new RuntimeException(e)
//        }
//    });
// Mention the Recipient's email address



}