package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;
    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public List<JobSeeker> getAll(){
        return this.jobSeekerService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody JobSeeker jobSeeker){
        this.jobSeekerService.add(jobSeeker);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Integer id,@RequestBody JobSeeker jobSeeker){
        this.jobSeekerService.delete(id);
    }
}
