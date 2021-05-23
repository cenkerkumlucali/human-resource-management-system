package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employersDao;

    @Autowired
    public EmployerManager(EmployerDao employersDao) {
        this.employersDao = employersDao;
    }

    @Override
    public DataResult<List<employers>> getAll() {
        return new SuccessDataResult<List<employers>>(this.employersDao.findAll(),"Employers listed");

    }

    @Override
    public Result add(employers employers) {

        this.employersDao.save(employers);
        return new SuccessResult("Employer added");
    }

    @Override
    public Result delete(Integer id) {
        if(!employersIdExists(id)){
            return new ErrorResult("employer with id "+ id + "does not exists");
        }

            this.employersDao.deleteById(id);
            return new SuccessResult("employer deleted");
    }
    private boolean employersIdExists(Integer id){
        var exists = employersDao.existsById(id);
        if(exists){
            return true;
        }
        return false;
    }
}
