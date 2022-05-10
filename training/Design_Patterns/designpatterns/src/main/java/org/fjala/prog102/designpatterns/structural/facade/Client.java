package org.fjala.prog102.designpatterns.structural.facade;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Client {

    private static final String SMTP_USERNAME = "<your-email-username>@gmail.com";
    // For GMail, use an "App Password" instead of a regular password:
    // https://support.google.com/accounts/answer/185833
    private static final String SMTP_PASSWORD = "<your-email-password>";

    public static void main(String[] args) throws EmailSenderException {
        EmailSenderFacade emailSender = new EmailSenderFacade();
        String emailSubject = "Test email from Facade";
        String emailMessageText = "Test email message body";
        //emailSender.sendEmail("<from-email-username>@gmail.com", "<to-email>", emailSubject, emailMessageText);
        List<String> emailAttachments = Arrays.asList("src/main/resources/Duke1.png", "src/main/resources/Duke2.png");
        emailSender.sendEmail("<from-email-username>@gmail.com", "<to-email>", emailSubject, emailMessageText,
                emailAttachments);
    }

    public static void withoutFacade(String[] args) {

        // Define a Properties object with the SMTP settings
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // User Credentials
        final String username = SMTP_USERNAME;
        final String password = SMTP_PASSWORD;

        // Create a Session with username and password
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage to send
            Message message = new MimeMessage(session);
            // From me
            message.setFrom(new InternetAddress(SMTP_USERNAME));
            // To myself
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(SMTP_USERNAME));
            message.setSubject("JavaMail Test email");

            String msg = "This is my first email using JavaMailer";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("src/main/resources/Duke1.png"));

            Multipart multipart = new MimeMultipart();
            // Add message
            multipart.addBodyPart(mimeBodyPart);
            // Add attachment
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (IOException e) {
            System.err.println("Unable to open attachment");
            System.err.println(e);
        } catch (MessagingException e) {
            System.err.println("Unable to send email");
            System.err.println(e);
        }
    }
}
