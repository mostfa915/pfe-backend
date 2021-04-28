package com.pfe.demo.controller;

import com.pfe.demo.entiter.Discussion;
import com.pfe.demo.reposetory.DiscussionReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Discussion")
public class DiscussionController {
    @Autowired
    private DiscussionReposetory discussionReposetory;
    @GetMapping("/all")
    List<Discussion> getAll() {
        return discussionReposetory.findAll();
    }

    @PostMapping("/add")
    Discussion Ajouter(@RequestBody Discussion discussion) {
        return discussionReposetory.save(discussion);
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
    @GetMapping("/messagebyartisan/{username}")
    List<Discussion> messageartisan(@PathVariable String username ) {
        return discussionReposetory.messagebyartisan(username);
    }
    @GetMapping("/conversation/{user1}/{user2}")
    Discussion getconversation(@PathVariable String user1,@PathVariable String user2)
    {
        return discussionReposetory.findDiscussio(user1,user2);
    }

}
