package com.example.demo.Web;

import com.example.demo.Dao.TaskReposetory;
import com.example.demo.Entiter.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
@Autowired
    private TaskReposetory taskReposetory ;
@GetMapping("/all")
public List<Task>ListTask(){
    return taskReposetory.findAll();
}



@PostMapping("/savetask")
public Task save (@RequestBody Task t){
    return taskReposetory.save(t);

}
}
