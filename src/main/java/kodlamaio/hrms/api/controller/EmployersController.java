package kodlamaio.hrms.api.controller;


import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employersService;

    @Autowired
    public EmployersController(EmployerService employersService) {
        this.employersService = employersService;
    }

    @GetMapping("/getall")
    public DataResult<List<employers>> getAll(){
        return this.employersService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody employers employers){
        return this.employersService.add(employers);
    }
}
