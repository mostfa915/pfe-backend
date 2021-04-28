package com.formation.demo.controller;

import com.formation.demo.Services.MailService;
import com.formation.demo.entites.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Mail")
public class MailController  {
@Autowired
    private MailService  mailService ;
    @PostMapping (value="/sendMail")
    public String sendMail(@RequestBody Mail mail){
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");
        mail.setFrom("mostfa.wrad@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject(mail.getSubject());
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);
        return "ok";
    }

}
