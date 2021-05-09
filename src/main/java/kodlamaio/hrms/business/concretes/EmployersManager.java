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
}
