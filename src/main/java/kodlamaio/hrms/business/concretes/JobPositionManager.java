package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>( this.jobPositionDao.findAll(),"Listelendi");

    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("JobPosition added");
    }

    @Override
    public Result delete(Integer id) {
        if(!jobPositionExist(id)){
            return new ErrorResult("JobPosition with id "+ id + "does not exists");
        }
            this.jobPositionDao.deleteById(id);
        return new SuccessResult("JobPosition deleted");

    }

    private boolean jobPositionExist(Integer id){
        var exists = jobPositionDao.existsById(id);
        if(exists){
            return true;
        }
        return false;
    }
}
