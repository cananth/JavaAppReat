package mailer;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
public class Mailer{  
	public String username, password, message, subject, email, name, to, cc, bcc,attachment, flash;
    public static void send(Mailer mailer)
    {  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("ananth.kumar48@gmail.com","9963580139");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailer.email));    
           message.setSubject(mailer.subject);    
           message.setText("Hello" + "" + mailer.name + "we have received your query and we would get back to you soon");    
           //send message  
           Transport.send(message); 
           
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("ananth.kumar48@gmail.com"));    
           message.setSubject("java app");    
           message.setText(mailer.email + " " + mailer.name + " " + mailer.message);    
           //send message  
           Transport.send(message); 
              
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
    
    public static void sendPdf(Mailer mailer)
    {
		 Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("ananth.kumar48@gmail.com","9963580139");  
           }    
          });  
		
		 try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress("ananth.kumar48@gmail.com"));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailer.email));  
			message.setSubject(mailer.subject);  
      
    //3) create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart();  
			messageBodyPart1.setText("This is message body");  
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
		String filename = "/host_msuser1/workspace/javaApp/" + mailer.attachment;//change accordingly  
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    //6) set the multiplart object to the message object  
    message.setContent(multipart );  
     
    //7) send message  
    Transport.send(message);  
   
   System.out.println("message sent....");  
   }
   catch (MessagingException ex) {ex.printStackTrace();}  
 }  
}
  
	
