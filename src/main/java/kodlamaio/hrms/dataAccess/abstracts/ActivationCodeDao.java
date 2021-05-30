package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer> {
    ActivationCode getByUserId(int userId);
}
