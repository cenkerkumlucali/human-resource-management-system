package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
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
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public void add(JobSeeker jobSeeker) {
    if(emailExist(jobSeeker.getEmail()) | nationalIdentityExist(jobSeeker.getNationalIdentity())){
        throw new IllegalStateException("Job seeker already exists!");
    }
        this.jobSeekerDao.save(jobSeeker);
    }

    @Override
    public void delete(Integer id) {
        if(jobSeekerIdExists(id)){
            this.jobSeekerDao.deleteById(id);
        }else{
            throw new IllegalStateException("jobseeker with id "+ id + "does not exists");
        }
    }

    @Override
    public void update(JobSeeker jobSeeker) {

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
}
