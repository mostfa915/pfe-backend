package com.pfe.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.demo.entiter.Discussion;
import com.pfe.demo.entiter.Message;
import com.pfe.demo.reposetory.DiscussionReposetory;
import com.pfe.demo.reposetory.MessageReposetory;
import com.pfe.demo.reposetory.UtilisateurReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Message")
public class MessageController {
    @Autowired
    private MessageReposetory messageReposetory;
   @Autowired
    private DiscussionReposetory discussionReposetory;
   @Autowired
   private UtilisateurReposetory utilisateurReposetory;
    @GetMapping("/all")
    List<Message> getAll() {
        return messageReposetory.findAll();
    }
    @GetMapping("/messagebyartisan/{id}")
    List<Message> messageartisan(@PathVariable Long id ) {
        return messageReposetory.messagebyartisan(id);
    }

    @PostMapping("/addMessage")
    Message Ajouter(@RequestParam("message") String message,@RequestParam("user1") String user1,@RequestParam("user2") String user2) throws JsonProcessingException {

System.out.println(message);
System.out.println(user1);
        System.out.println(user2);





       Discussion   discussion = discussionReposetory.findDiscussio(user1,user2);


            if (discussion==null) {
                Discussion discussion1 = new Discussion();
                discussion1.setUser1(user1);
                discussion1.setUser2(user2);
               discussionReposetory.save(discussion1);
                Message message1 = new Message();
                message1.setMessage(message);
                Discussion   discussion2= discussionReposetory.findDiscussio(user1,user2);
               message1.setIdDiscussion(discussion2);
                message1.setIdUtilisateur(utilisateurReposetory.findByUsername(user1));
            }
Message message1=new Message();
            message1.setMessage(message);
        message1.setIdDiscussion(discussion);
        message1.setIdUtilisateur(utilisateurReposetory.findByUsername(user1));
        message1.setIdDestinataire(utilisateurReposetory.findByUsername(user2));


        return messageReposetory.save(message1);
    }
    @DeleteMapping("/delete")
    public HashMap<String, String> deleteall() {
        HashMap hashmap = new HashMap();
        try {
            discussionReposetory.deleteAll();
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }

}
