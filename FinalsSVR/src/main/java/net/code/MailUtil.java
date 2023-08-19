package net.code;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static void sendMessage(String recipient, String key) {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		String myEmail="seanvastianroxas@gmail.com";
		String password="udfimxpfusolxlzr";
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, password);
			}
		});
		System.out.println("Preparing to send the email...");
		Message msg = prepareMessage(session,myEmail,password,recipient,key);
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Email Sent!!!...");
	}

	private static Message prepareMessage(Session session, String myEmail, String password, String recipient, String key) {
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(myEmail));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			msg.setSubject("One Time Password");
			msg.setText("Your One Time Password is " + key);
			return msg;
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
