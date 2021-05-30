package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }
    @GetMapping("getAllByEmployer")
    DataResult<List<JobAdvertisement>> getAllByEmployer(@RequestParam int employerId){
        return jobAdvertisementService.getByEmployerIdAndIsActiveTrue(employerId);
    }

    @GetMapping("getByIsActiveTrue")
    DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
        return jobAdvertisementService.getByIsActiveTrue();
    }

    @GetMapping("getByApplicationDeadlineLessThanEqual")
    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return jobAdvertisementService.getByDeadlineLessThanEqual(date);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return  this.jobAdvertisementService.add(jobAdvertisement);
    }
}
