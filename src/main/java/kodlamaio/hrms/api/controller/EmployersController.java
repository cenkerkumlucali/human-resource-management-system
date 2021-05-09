package kodlamaio.hrms.api.controller;


import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.entities.concretes.employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployersService employersService;

    @Autowired
    public EmployersController(EmployersService employersService) {
        this.employersService = employersService;
    }

    @GetMapping("/getall")
    public List<employers> getAll(){
        return this.employersService.getAll();
    }
    @PostMapping("/add")
    public void add(employers employers){
        this.employersService.add(employers);
    }
}
