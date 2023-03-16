package com.won.viewer;




import com.won.model.activity.Activity;
import com.won.model.user.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Collection;
import java.util.Properties;


/**
 * @author Joshua Richardson
 *  Simple emailer to send "friends" the itinerary
 */
public class Emailer {

    public static void email(String emailAddresses, Collection<Activity> itinerary, User user) {

        final String username = "tlgitinerary@gmail.com";
        final String password = "hjfhpqnfkwutrgtr";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("joshua.richardson.tlgcohort@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailAddresses)
            );
            String setSubject = String.format("Your friend, %s, Would like you to join in a fun filled day!", user.getName());
            message.setSubject(setSubject);

            StringBuilder setText = new StringBuilder();
            setText.append("Hi!  I would like for you to come with me to the following events:\n");
            for (var item : itinerary){
                setText.append(item.toString() + "\n");
            }
            message.setText(setText.toString());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}