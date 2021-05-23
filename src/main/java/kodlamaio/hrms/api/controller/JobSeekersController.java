package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker){
      return  this.jobSeekerService.add(jobSeeker);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Result delete(@PathVariable Integer id,@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerService.delete(id);
    }
}
