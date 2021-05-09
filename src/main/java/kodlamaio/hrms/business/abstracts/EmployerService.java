package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.employers;

import java.util.List;

public interface EmployerService {
    List<employers> getAll();
    void add(employers employers);
    void delete(Integer id);
}