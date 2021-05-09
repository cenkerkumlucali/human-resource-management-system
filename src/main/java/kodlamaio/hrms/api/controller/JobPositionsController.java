package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
    private JobPositionService jobPositionService;

    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }
    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return this.jobPositionService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition){
        this.jobPositionService.add(jobPosition);
    }
}
