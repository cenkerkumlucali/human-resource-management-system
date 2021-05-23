package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    JobSeekerDao jobSeekerDao;
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>( this.jobSeekerDao.findAll(),"Listelendi");

    }

    @Override
    public Result add(JobSeeker jobSeeker) {
    if(emailExist(jobSeeker.getEmail()) | nationalIdentityExist(jobSeeker.getNationalIdentity())){
        return new ErrorResult("Job seeker already exists!");
    }
    if(checkIfPasswordExists(jobSeeker.getPassword(),jobSeeker.getConfirmPassword())){
        return new ErrorResult("Wrong password");
    }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Eklendi");
    }

    @Override
    public Result delete(Integer id) {
        if(!jobSeekerIdExists(id)){
            return new ErrorResult("jobseeker with id "+ id + "does not exists");
        }

            this.jobSeekerDao.deleteById(id);
       return new SuccessResult("Silindi");
    }

    private boolean emailExist(String email){
    var result = jobSeekerDao.findEmail(email).isPresent();
    if(result){
        return true;
    }
    return false;
    }
    private boolean nationalIdentityExist(String nationalIdentity){
        var result = jobSeekerDao.findNationalIdentity(nationalIdentity).isPresent();
        if(result){
            return true;
        }
        return false;
    }
    private boolean jobSeekerIdExists(Integer id){
        var exists = jobSeekerDao.existsById(id);
        if(exists){
            return true;
        }
        return false;
    }
    private boolean checkIfPasswordExists(String password,String confirmPassword){
        var result = password.equals(confirmPassword);
        if (result){
            return true;
        }
        else{
            return false;
        }
    }
}
