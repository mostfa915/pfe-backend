package com.example.demo;

import com.example.demo.Dao.TaskReposetory;
import com.example.demo.Entiter.RoleApp;
import com.example.demo.Entiter.Task;
import com.example.demo.Entiter.UserApp;
import com.example.demo.service.CompteServices;
import com.example.demo.service.UserdetailServiceImplimentation;
import com.sun.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements  CommandLineRunner {

	@Autowired
	private TaskReposetory taskReposetory;
    @Autowired
	private CompteServices compteServices;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args0) throws Exception {

		/*compteServices.saveUser(new UserApp("admin","1111",null));
		compteServices.saveUser(new UserApp("user","2222",null));

		compteServices.saveUser(new UserApp("naim","2222",null));

		compteServices.saveRole((new RoleApp("ADMIN")));
		compteServices.saveRole((new RoleApp("USER")));
*/
		compteServices.saveUser(new UserApp("rania","1122",null));

		//compteServices.AddRoleToUser("rania","ADMIN");
		//compteServices.AddRoleToUser("user","USER");
		/*compteServices.AddRoleToUser("user","USER");
		compteServices.AddRoleToUser("naim6","ADMIN");*/




        taskReposetory.save(new Task("T1"));
		taskReposetory.save(new Task("T2"));
		taskReposetory.save(new Task("T3"));
		taskReposetory.findAll().forEach(c -> {
			System.out.println(c.getTaskName());
			System.out.println(c.getId());
		});
		/* instancier le bean de BCryptPasswordEncoder car spring ne fait pas le instancier par defaut*/

/*
	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(getBPE());
		daoAuthenticationProvider.setUserDetailsService();
	}
*/
}
	@Bean
	public BCryptPasswordEncoder getBPE(){
		return new BCryptPasswordEncoder() ;
	}

}