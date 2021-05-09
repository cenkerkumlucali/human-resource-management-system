package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
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
    public List<JobPosition> getAll() {
        return this.jobPositionDao.findAll();
    }

    @Override
    public void add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
    }

    @Override
    public void delete(Integer id) {
        if(jobPositionExist(id)){
            this.jobPositionDao.deleteById(id);
        }
        throw new IllegalStateException("JobPosition with id "+ id + "does not exists");

    }

    private boolean jobPositionExist(Integer id){
        var exists = jobPositionDao.existsById(id);
        if(exists){
            return true;
        }
        return false;
    }
}
