package org.fjala.prog102.designpatterns.structural.facade;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
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

public class EmailSenderFacade {

    private static final String SMTP_USERNAME = "<your-email-username>@gmail.com";
    // For GMail, use an "App Password" instead of a regular password:
    // https://support.google.com/accounts/answer/185833
    private static final String SMTP_PASSWORD = "<your-email-password>";

    public void sendEmail(String emailFrom, String emailTo, String emailSubject, String emailMessageText)
            throws EmailSenderException {
        sendEmail(emailFrom, emailTo, emailSubject, emailMessageText, Collections.emptyList());
    }

    public void sendEmail(String emailFrom, String emailTo, String emailSubject, String emailMessageText,
            List<String> emailAttachments) throws EmailSenderException {

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
            message.setFrom(new InternetAddress(emailFrom));
            // To myself
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject(emailSubject);

            // Create Multipart for text and attachments
            Multipart multipart = new MimeMultipart();

            // Add message
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailMessageText, "text/html; charset=utf-8");
            multipart.addBodyPart(mimeBodyPart);

            // Add all attachments
            for (String attachmentPath : emailAttachments) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(new File(attachmentPath));
                multipart.addBodyPart(attachmentBodyPart);
            }

            // Set message content (Multipart)
            message.setContent(multipart);

            // Send message
            Transport.send(message);

        } catch (IOException e) {
            throw new EmailSenderException("Unable to open an attachment", e);
        } catch (MessagingException e) {
            throw new EmailSenderException("Unable to send email", e);
        }

    }
}
