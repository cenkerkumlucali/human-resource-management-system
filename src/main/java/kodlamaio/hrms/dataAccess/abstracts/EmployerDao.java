package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<employers,Integer> {
}
