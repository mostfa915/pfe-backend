package com.example.demo.Web;

import com.example.demo.Dao.RoleAppReposetory;
import com.example.demo.Entiter.RegisterForm;
import com.example.demo.Entiter.RoleApp;
import com.example.demo.Entiter.UserApp;
import com.example.demo.service.CompteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
@CrossOrigin("*")
@RestController
public class CompteController {
@Autowired
    RoleAppReposetory roleAppReposetory ;
    @Autowired
    private CompteServices compteServices ;
@PostMapping("/register")
public UserApp regitrer (@RequestBody RegisterForm userform){
    if(!userform.getPassword().equals(userform.getRepassword()))
    throw new RuntimeException("verifier votre mot de pass");
     UserApp userapp=compteServices.FindUserByUsername(userform.getUsername());
    if(userapp!=null)throw new RuntimeException("username exist");



        UserApp user=new UserApp();
        user.setUsername(userform.getUsername());
        user.setPassword(userform.getPassword());


    RoleApp role =roleAppReposetory.findByRoleName("USER");
    user.getRoles().add(role);

    return compteServices.saveUser(user);
}

}
