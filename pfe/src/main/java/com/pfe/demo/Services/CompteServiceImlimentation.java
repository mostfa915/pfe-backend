package com.pfe.demo.Services;

import com.pfe.demo.entiter.Roles;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.reposetory.RolesReposetory;
import com.pfe.demo.reposetory.UtilisateurReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImlimentation implements CompteServices  {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UtilisateurReposetory utilisateurReposetory ;
    @Autowired
    private RolesReposetory roleAppReposetory;
    @Override
    public Utilisateur saveUser(Utilisateur utilsateur) {
        /* crypter le mot de passe avant mettres le user dans la bdd */
        String hashPassword =bCryptPasswordEncoder.encode(utilsateur.getPassword());
        utilsateur.setPassword(hashPassword);
        return utilisateurReposetory.save(utilsateur);

    }

    @Override
    public Roles saveRole(Roles role) {
        return roleAppReposetory.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {
        /*rcuperer le role */
        Roles role =roleAppReposetory.findByRoleNom(rolename);
        /*recuprer le user qui je veux ajouter un role*/
        Utilisateur utilisateur=utilisateurReposetory.findByUsername(username);
        /*affecter le role aux user*/
        utilisateur.getRoles().add(role);
    }

    @Override
    public Utilisateur FindUserByUsername(String username) {
        return utilisateurReposetory.findByUsername(username);
    }

}
