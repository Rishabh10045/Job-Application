package com.rishabh.spring.RESTAPI;

import com.rishabh.spring.RESTAPI.model.JobPost;
import com.rishabh.spring.RESTAPI.repo.JobRepo;
import com.rishabh.spring.RESTAPI.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    JobService service;
    @GetMapping("/jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    @ResponseBody
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keywords}")
    public List<JobPost> searchByKeyword(@PathVariable("keywords") String keyword){
        return service.search(keyword);
    }
    @PostMapping("/jobPost")
    public void addJob(@RequestBody JobPost job){
        System.out.println("add job");
        service.addJob(job);

    }
    @PutMapping("/jobPost")
    public void updateJob(@RequestBody JobPost job){
        service.updateJob(job);
    }

    @DeleteMapping("/jobPost/{id}")
    public void deleteJob(@PathVariable int id){
        service.deleteJjob(id);
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "Success";
    }
}
