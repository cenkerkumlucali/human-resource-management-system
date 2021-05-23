package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }
}
