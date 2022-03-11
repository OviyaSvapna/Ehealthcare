package patient;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailRegistration 
{
	   
	
	public void Servicemsg(String email)
	{ 
	
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

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject("Successfully completed registration");
			message.setText("Hi\nYou have successfully created account in E-healthCare Management System\n\tThank you!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e)
		{
			System.out.println(e);
		}
		


	}
//	public static void main(String arg[])
//	{
//		MailRegistration m=new MailRegistration();
//		m.Servicemsg();
//	}
      
    
}

