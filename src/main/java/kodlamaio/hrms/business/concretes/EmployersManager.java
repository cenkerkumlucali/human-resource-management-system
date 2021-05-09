package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;

    @Autowired
    public EmployersManager(EmployersDao employersDao) {
        this.employersDao = employersDao;
    }

    @Override
    public List<employers> getAll() {
        return this.employersDao.findAll();
    }

    @Override
    public void add(employers employers) {
        this.employersDao.save(employers);
    }

    @Override
    public void delete(Integer id) {
        if(employersIdExists(id)){
            this.employersDao.deleteById(id);
        }else{
            throw new IllegalStateException("employers with id "+ id + "does not exists");
        }
    }


    private boolean employersIdExists(Integer id){
        var exists = employersDao.existsById(id);
        if(exists){
            return true;
        }
        return false;
    }
}
