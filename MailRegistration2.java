package doctor;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailRegistration2 
{
	   
	
	public void Patmsg(String docmail,String patmail,String reason,String name,String time)
	{ 
		System.out.println(docmail);
  
		String username = "oviyasvapnapro@gmail.com";
		String password = "Projectacc*1";

	    String from = "oviyasvapnapro@gmail.com";
	    String to=docmail;
	   

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



	            
	            Authenticator a =new Authenticator() {

	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    
	                    return new PasswordAuthentication(username, password);
	                    
	                }
	                
	            };

	            Session session = Session.getInstance(props, a);

		try 
		{
	
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(docmail));
			message.setSubject("APPOINTMENT");
			message.setText("Hello Doctor! you have received an appointment from \n NAME : "+ name +
                                "\n REASON : "+ reason + "\n TIME : "+ time+ "\n MAIL : "+ patmail );

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e)
		{
			System.out.println(e);
		}
		


	}
        
        	public void Appointment(String Email,String time)
	{ 
		System.out.println(Email);
  
		String username = "oviyasvapnapro@gmail.com";
		String password = "Projectacc*1";

	    String from = "oviyasvapnapro@gmail.com";
	    String to=Email;
	   

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



	            
	            Authenticator a =new Authenticator() {

	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    
	                    return new PasswordAuthentication(username, password);
	                    
	                }
	                
	            };

	            Session session = Session.getInstance(props, a);

		try 
		{
	
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Email));
			message.setSubject("APPOINTMENT");
			message.setText("Your Appointment is fixed at "+time);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e)
		{
			System.out.println(e);
		}
		


	}
        	public void Reject(String Email)
	{ 
		System.out.println(Email);
  
		String username = "oviyasvapnapro@gmail.com";
		String password = "Projectacc*1";

	    String from = "oviyasvapnapro@gmail.com";
	    String to=Email;
	   

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



	            
	            Authenticator a =new Authenticator() {

	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    
	                    return new PasswordAuthentication(username, password);
	                    
	                }
	                
	            };

	            Session session = Session.getInstance(props, a);

		try 
		{
	
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Email));
			message.setSubject("APPOINTMENT");
			message.setText("Dear patient,\n Sorry ,Your Appointment has been rejected");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e)
		{
			System.out.println(e);
		}
		


	}
  
        
     /*public void Sucessmsg(String email)
	{ 
		System.out.println(email);
  
		String username = "oviyasvapnapro@gmail.com";
		String password = "Projectacc*1";

	    String from = "oviyasvapnapro@gmail.com";
	    String to=email;
	   

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



	            
	            Authenticator a =new Authenticator() {

	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    
	                    return new PasswordAuthentication(username, password);
	                    
	                }
	                
	            };

	            Session session = Session.getInstance(props, a);

		try 
		{
	
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
			message.setSubject("Successfully completed registration");
			message.setText("Hi\\nYou have successfully created account in E-healthCare Management System\\n\\tThank you!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e)
		{
			System.out.println(e);
		}
		


	}*/

      
    
}