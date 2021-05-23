package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.employers;

import java.util.List;

public interface EmployerService {
    DataResult<List<employers>> getAll();
    Result add(employers employers);
    Result delete(Integer id);
}
