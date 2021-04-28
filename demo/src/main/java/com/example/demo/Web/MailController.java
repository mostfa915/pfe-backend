package com.example.demo.Web;

import com.example.demo.Entiter.Mail;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MailController {
@Autowired
   private  EmailService emailService ;

    @PostMapping(value="/sendMail")
    public String sendMail(@RequestBody Mail mail){
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");
        mail.setFrom("mostfa.wrad@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject(mail.getSubject());
        mail.setContent(mail.getContent());
        emailService.sendSimpleMessage(mail);
        return "ok";
    }
}
