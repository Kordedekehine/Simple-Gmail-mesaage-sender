package Email.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("salamikehinde345@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

        javaMailSender.send(mailMessage);
        System.out.println("MAIL SENT");
    }
    //incase we want to send mail with attachment
    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("salamikehinde345@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        //Now we send the attachment
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));

    mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
    javaMailSender.send(mimeMessage);
        System.out.println("Message Sent");
    }
}
