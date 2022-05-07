package Project.demo.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender{

    private final static Logger LOGGER = LoggerFactory //sl4js
            .getLogger(EmailService.class);

    @Autowired
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void send(String to, String email) {
     try{ //Here we set the box where the email left and go
         MimeMessage mimeMessage = javaMailSender.createMimeMessage();
         MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");
         mimeMessageHelper.setText(email,true);
         mimeMessageHelper.setTo(to);
         mimeMessageHelper.setSubject("Confirm your Email");
         mimeMessageHelper.setFrom("salamikorex345@gmail.com");
         javaMailSender.send(mimeMessage);
     } catch (MessagingException e) {
         LOGGER.error("Failed to send email",e);
         throw new IllegalStateException("Failed to send email");
     }
    }
}
