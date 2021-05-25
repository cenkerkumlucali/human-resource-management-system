package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.adapters.ValidateMernis;
import kodlamaio.hrms.business.adapters.ValidatePersonService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    JobSeekerDao jobSeekerDao;
    ValidatePersonService validatePersonService;
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,ValidatePersonService validatePersonService) {
        this.jobSeekerDao = jobSeekerDao;
        this.validatePersonService = validatePersonService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>( this.jobSeekerDao.findAll(),"Listelendi");

    }

    @Override
    public Result add(JobSeeker jobSeeker) {

    Result result = BusinessRules.run(emailExist(jobSeeker.getEmail()),
                    nationalIdentityExist(jobSeeker.getNationalIdentity()),
                    checkIfPasswordExists(jobSeeker.getPassword(),jobSeeker.getConfirmPassword()));

    if (!result.isSuccess()){
    return result;
    }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Eklendi");
    }

    @Override
    public Result delete(Integer id) {
        Result result = BusinessRules.run(jobSeekerIdExists(id));
        if (!result.isSuccess()){
            return result;
        }
        this.jobSeekerDao.deleteById(id);
        return new SuccessResult("Silindi");
    }

    private Result emailExist(String email){
    var result = jobSeekerDao.findEmail(email).isPresent();
    if(result){
        return new ErrorResult("Email exists");
    }
    return new SuccessResult();
    }
    private Result nationalIdentityExist(String nationalIdentity){
        var result = jobSeekerDao.findNationalIdentity(nationalIdentity).isPresent();
        if(result){
            return new ErrorResult("zaten bu tc kimlik numarası kullanılıyor");
        }
        return new SuccessResult();
    }
    private Result jobSeekerIdExists(Integer id){
        var exists = jobSeekerDao.existsById(id);
        if(exists){
            return new ErrorResult("jobseeker with id "+ id + "does not exists");
        }
        return new SuccessResult();
    }
    private Result checkIfPasswordExists(String password,String confirmPassword){
        var result = password.equals(confirmPassword);
        if (result){
            return new ErrorResult("Paralolar eşleşmiyor");
        }
        return new SuccessResult();
    }
}
