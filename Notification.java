import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailNotification {

    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");


        String senderEmail = "your.email@gmail.com";
        String senderPassword = "yourpassword";
        String recipientEmail = "customer.email@example.com";


        String subject = "Your order is complete!";
        String body = "Dear Customer,\n\nYour order is completed.";


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Email notification is sent to " + recipientEmail);
        } catch (MessagingException e) {
            System.out.println("Error sending the email notification: " + e.getMessage());
        }
    }
}
